package com.jobrapido;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class AdvertService {

    @Inject
    AdvertRepository advertRepository;

    @Inject
    EntityManager em;
    
    public List<Advert> getAllAdverts(){
        final List<Advert> adverts = (List<Advert>) em.createQuery("from Advert").getResultList();
        return adverts;
    }
    
    public List<Advert> getAdverts(final String company) {
        final List<Advert> adverts = advertRepository.findByCompany(company);
        return adverts;
    }

    @Transactional
    public void createAdvert(
        final String url, 
        final String title, 
        final String website, 
        final String company) {
        final Advert newAdvert = new Advert();
        newAdvert.setTitle(title);
        newAdvert.setUrl(url);
        newAdvert.setWebsite(website);
        newAdvert.setCompany(company);
        //em.persist(newAdvert);
        advertRepository.save(newAdvert);
    }
}