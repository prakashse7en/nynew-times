package com.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.nytimes.Application;
import com.nytimes.model.NyTimesResponse;
import com.nytimes.service.NyTimesService;


@SpringBootTest(classes=Application.class,webEnvironment=WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes=RestTemplate.class)
@RunWith(SpringRunner.class)
public class NyTimesControllerTest {

	static ConfigurableApplicationContext eurekaServer;
	
	@InjectMocks
	NyTimesService nyTimesServiceMock;
	
	@Mock
	RestTemplate restemplateMock;
	
	@BeforeClass
    public static void startEureka() {
        eurekaServer = SpringApplication.run(EurekaServer.class,
                "--server.port=8761",
                "--eureka.instance.leaseRenewalIntervalInSeconds=1");
    }

    @AfterClass
    public static void closeEureka() {
        eurekaServer.close();
    }

    @LocalServerPort
    private int port;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getNyResponseTest(){
		NyTimesResponse nyTimesResponse = CommonUtil.getDefaultMostViewedResp();
		Mockito.when(restemplateMock.getForObject(anyString(), anyObject())).thenReturn(nyTimesResponse);
		assertNotNull(nyTimesServiceMock.getMostViewedResp());
		//asert the data
	}
	
	@Test
	public void getNyResponseNullTest(){
		NyTimesResponse nyTimesResponse = CommonUtil.getDefaultMostViewedResp();
		Mockito.when(restemplateMock.getForObject(anyString(), anyObject())).thenReturn(nyTimesResponse);
		NyTimesResponse fetchedNyTimesResponse =  nyTimesServiceMock.getMostViewedResp();
		assertNull(fetchedNyTimesResponse.getResults().get(0).getType());
		//asert the data
	}
	
	@Configuration
    @EnableAutoConfiguration
    @EnableEurekaServer
    static class EurekaServer {
    }
}
