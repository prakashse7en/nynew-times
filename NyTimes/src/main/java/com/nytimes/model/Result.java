
package com.nytimes.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {

    @JsonProperty("url")
    private String url;
    @JsonProperty("adx_keywords")
    private String adxKeywords;
    @JsonProperty("column")
    private String column;
    @JsonProperty("section")
    private String section;
    @JsonProperty("byline")
    private String byline;
    @JsonProperty("type")
    private String type;
    @JsonProperty("title")
    private String title;
    @JsonProperty("abstract")
    private String _abstract;
    @JsonProperty("published_date")
    private String publishedDate;
    @JsonProperty("source")
    private String source;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("asset_id")
    private Long assetId;
    @JsonProperty("views")
    private Long views;
    /*  @JsonProperty("des_facet")
    private List<String> desFacet = new ArrayList<String>();
    @JsonProperty("org_facet")
    private List<String> orgFacet =  new ArrayList<String>();
    @JsonProperty("per_facet")
    private List<String> perFacet =  new ArrayList<String>();
    @JsonProperty("geo_facet")
    private List<String> geoFacet  =  new ArrayList<String>();*/
    @JsonProperty("media")
    private List<Medium> media = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("adx_keywords")
    public String getAdxKeywords() {
        return adxKeywords;
    }

    @JsonProperty("adx_keywords")
    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

   

    @JsonProperty("section")
    public String getSection() {
        return section;
    }

    @JsonProperty("section")
    public void setSection(String section) {
        this.section = section;
    }

    @JsonProperty("byline")
    public String getByline() {
        return byline;
    }

    @JsonProperty("byline")
    public void setByline(String byline) {
        this.byline = byline;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

   
    @JsonProperty("published_date")
    public String getPublishedDate() {
        return publishedDate;
    }

    @JsonProperty("published_date")
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("asset_id")
    public Long getAssetId() {
        return assetId;
    }

    @JsonProperty("asset_id")
    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    @JsonProperty("views")
    public Long getViews() {
        return views;
    }

    @JsonProperty("views")
    public void setViews(Long views) {
        this.views = views;
    }
    /*
    @JsonProperty("des_facet")
    public List<String> getDesFacet() {
        return desFacet;
    }

    @JsonProperty("des_facet")
    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    @JsonProperty("org_facet")
    public List<String> getOrgFacet() {
        return orgFacet;
    }

    @JsonProperty("org_facet")
    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

   @JsonProperty("per_facet")
    public List<String> getPerFacet() {
        return perFacet;
    }

    @JsonProperty("per_facet")
    public void setPerFacet(List<String> perFacet) {
        this.perFacet = perFacet;
    }

    @JsonProperty("geo_facet")
    public List<String> getGeoFacet() {
		return geoFacet;
	}

    @JsonProperty("geo_facet")
	public void setGeoFacet(List<String> geoFacet) {
		this.geoFacet = geoFacet;
	}
*/
	@JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    @JsonProperty("column")
    public String getColumn() {
		return column;
	}

    @JsonProperty("column")
	public void setColumn(String column) {
		this.column = column;
	}

    @JsonProperty("abstract")
	public String get_abstract() {
		return _abstract;
	}

    @JsonProperty("abstract")
	public void set_abstract(String _abstract) {
		this._abstract = _abstract;
	}


	@JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
