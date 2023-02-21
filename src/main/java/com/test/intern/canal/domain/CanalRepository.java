package com.test.intern.canal.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

public interface CanalRepository extends MongoRepository<Canal, String> {

    @Query("{name:'?0'}")
    Canal findItemByName(String name);
}
