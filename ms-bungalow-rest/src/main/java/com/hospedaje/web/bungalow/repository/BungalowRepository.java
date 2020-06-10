package com.hospedaje.web.bungalow.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospedaje.web.bungalow.entity.Bungalow;


@Repository
@Transactional
public interface BungalowRepository extends ReactiveMongoRepository<Bungalow, Integer>{

}
