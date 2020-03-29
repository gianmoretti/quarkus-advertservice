package com.jobrapido;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.base.Objects;

@Entity
public class Advert {

    private Integer id;
    private String title;
    private String url;
    private String website;
    private String company;    

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return this.id;
    }

    /**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public Advert id(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Advert title(String title) {
        this.title = title;
        return this;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Advert company(String company) {
        this.company = company;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Advert)) {
            return false;
        }
        Advert advert = (Advert) o;
        return 
            Objects.equal(id, advert.id) && 
            Objects.equal(url, advert.url) && 
            Objects.equal(website, advert.website) &&  
            Objects.equal(title, advert.title) && 
            Objects.equal(company, advert.company);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, url, website, title, company);
    }

    @Override
    public String toString() {
        return "{" +
            "  \"id\": \"" + getId() + "\"" +
            ", \"url\": \"" + getUrl() + "\"" +
            ", \"website\": \"" + getWebsite() + "\"" +
            ", \"title\": \"" + getTitle() + "\"" +
            ", \"company\": \"" + getCompany() + "\"" +
            "}";
    }
}

