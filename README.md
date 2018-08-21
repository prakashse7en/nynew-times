NyTimes Micorservice

Micro service which interacts with NyTimes REST api to fecth the nytimes most popular section  data

Prerequisites
-------------
*)Install JDK1.7/1.8 and apache maven and STS preferred else any other IDE like Eclipse
*)Api key creation
	.)Fetch api key from Nytimes app by registering your email. 
	.)Api key is sent to your email for your future use

Projects
---------
*)eureka-service
	.)Eureka server is used where all the microservices created is registered to this server .
	.)Going forward any third party endpoint wants to use the registered microservice can use the links present in section "Instances currently registered with Eureka"
	.)Advantage all the status of the service and instances can be seen in eureka server console.
		Files
		-----
		>)EurekaServiceApplication.java - marked as spring boot application and EnableEurekaServer
		>)application.properties.java - following properties are marked are done "eureka.client.register-with-eureka=false,eureka.client.fetch-registry=false"

*)NyTimes
	.)Nytimes microservice is used to fetch the nytimes most popular section data 
	.)Registers to eureka server using eureka client annotation
	.)Circuit breaker is created in order prevent service on hard failures
		Files
		-----
		>)Application.java - spring boot main application enable circuit breaker using "EnableCircuitBreaker" and "EnableDiscoveryClient" to be discovered by the eureka server
		>)ApplicationConfig.java - Configuration file where configuration related things are done. Rest Template is instantiated along with read and connection timeout being set.
		>)NyTimesController.java - marked with rest controller and rest endpoint is created to fetch the data from nytimes api . Get mapping is used to fetch the data
		>)Model classes that supporting nytimes response are present at "com.nytimes.model" package
		>)NyTimesService.java - used to call the nytimes service  and @HystrixCommand is marked on getMostViewedResp since if there is failure in the thirdparty getDefaultMostViewedResp will be called
	.)"com.test" contains all the  test cases written using junit and mockito
