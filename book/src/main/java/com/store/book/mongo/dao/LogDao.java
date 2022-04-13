package com.store.book.mongo.dao;

import com.store.book.mongo.model.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogDao extends MongoRepository<LogEntity, String> {
}
