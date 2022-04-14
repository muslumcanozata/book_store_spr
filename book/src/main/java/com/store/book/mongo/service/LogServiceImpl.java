package com.store.book.mongo.service;

import com.store.book.mongo.dao.LogDao;
import com.store.book.mongo.model.LogDTO;
import com.store.book.mongo.model.LogEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * LogServiceImpl
 * @author mcozata
 * @since 2022/04/11
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<LogDTO> getAll(String username) {
        List<LogEntity> logEntityList = logDao.findAll();
        return logEntityList.parallelStream().map(item -> mapper.map(item, LogDTO.class)).collect(Collectors.toList());
    }

    @Override
    public LogDTO getOne(String id, String username) {
        Optional<LogEntity> logEntity = logDao.findById(id);
        return mapper.map(logEntity, LogDTO.class);
    }

    @Override
    public void insert(String operationName, String tableName, String username) {
        LogEntity logEntity = new LogEntity();
        logEntity.setUsername(username);
        logEntity.setDateTime(new Date());
        logEntity.setOperationName(operationName);
        logEntity.setTableName(tableName);
        logDao.insert(logEntity);
    }
}
