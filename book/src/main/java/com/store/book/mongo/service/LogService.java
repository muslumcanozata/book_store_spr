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
     * @return List<LogDTO>
     * @since 2022/04/11
     */
    List<LogDTO> getAll();

    /**
     * getOne
     * @author mcozata
     * @param id
     * @return LogDTO
     * @since 2022/04/11
     */
    LogDTO getOne(String id);

    /**
     * insert
     * @author mcozata
     * @param operationName
     * @param tableName
     * @since 2022/04/11
     */
    void insert(String operationName, String tableName);
}
