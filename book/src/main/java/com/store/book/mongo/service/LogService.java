package com.store.book.mongo.service;

import com.store.book.mongo.model.LogDTO;

import java.util.List;

/**
 * LogService
 * @author mcozata
 * @since 2022/04/11
 */
public interface LogService {

    /**
     * getOne
     * @author mcozata
     * @param username
     * @return List<LogDTO>
     * @since 2022/04/11
     */
    List<LogDTO> getAll(String username);

    /**
     * getOne
     * @author mcozata
     * @param id
     * @param username
     * @return LogDTO
     * @since 2022/04/11
     */
    LogDTO getOne(String id, String username);

    /**
     * insert
     * @author mcozata
     * @param operationName
     * @param tableName
     * @param username
     * @since 2022/04/11
     */
    void insert(String operationName, String tableName, String username);
}
