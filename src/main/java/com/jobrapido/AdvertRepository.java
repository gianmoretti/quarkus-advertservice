package com.jobrapido;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AdvertRepository extends CrudRepository<Advert, Long> {

    List<Advert> findByCompany(String company);
}