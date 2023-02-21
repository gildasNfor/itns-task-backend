package com.test.intern.besoin.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BesoinRepository extends MongoRepository<Besoin, String> {

    @Query("{name:'?0'}")
    Besoin findItemByName(String name);
}
