package com.jobrapido;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.common.base.Objects;

@Entity
public class Advert {

    private Integer id;
    private String body;
    private String title;
    private String company;    

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="giftSeq")
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Advert id(Integer id) {
        this.id = id;
        return this;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Advert body(String body) {
        this.body = body;
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
        return Objects.equal(id, advert.id) && Objects.equal(body, advert.body) && Objects.equal(title, advert.title) && Objects.equal(company, advert.company);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, body, title, company);
    }

    @Override
    public String toString() {
        return "{" +
            "  \"id\": \"" + getId() + "\"" +
            ", \"body\": \"" + getBody() + "\"" +
            ", \"title\": \"" + getTitle() + "\"" +
            ", \"company\": \"" + getCompany() + "\"" +
            "}";
    }
}

