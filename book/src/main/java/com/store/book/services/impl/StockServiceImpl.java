package com.store.book.services.impl;

import com.store.book.daos.StocksDao;
import com.store.book.domains.dto.StockInsertRequestDTO;
import com.store.book.domains.dto.StockUpdateRequestDTO;
import com.store.book.domains.dto.StocksDTO;
import com.store.book.domains.entity.Stocks;
import com.store.book.mongo.model.OperationTypes;
import com.store.book.mongo.service.LogService;
import com.store.book.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StocksDao stocksDao;

    @Autowired
    LogService logService;

    private final String TABLE_NAME = "stocks";

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    public StocksDTO insertOne(StockInsertRequestDTO stockInsertRequestDTO, String username) {
        logService.insert(OperationTypes.CREATE.getName(), TABLE_NAME, username);
        Stocks stocks = Stocks.fromInsertRequestDTO(stockInsertRequestDTO);
        Stocks providedStocks = stocksDao.save(stocks);
        return StocksDTO.fromEntity(providedStocks);
    }

    @Override
    public StocksDTO getOne(Long id, String username) {
        logService.insert(OperationTypes.READ.getName(), TABLE_NAME, username);
        Optional<Stocks> stocks = stocksDao.findById(id);
        return StocksDTO.fromEntity(stocks.orElse(new Stocks()));
    }

    @Override
    public List<StocksDTO> getAll(String username) {
        logService.insert(OperationTypes.READ.getName(), TABLE_NAME, username);
        List<Stocks> stocks = stocksDao.findAll();
        return stocks.parallelStream().map(StocksDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    public void increaseStock(StockUpdateRequestDTO stockUpdateRequestDTO, String username) {
        logService.insert(OperationTypes.UPDATE.getName(), TABLE_NAME, username);
        stocksDao.increaseStock(stockUpdateRequestDTO.getBookId(), stockUpdateRequestDTO.getAmount());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    public void decreaseStock(StockUpdateRequestDTO stockUpdateRequestDTO, String username) {
        logService.insert(OperationTypes.UPDATE.getName(), TABLE_NAME, username);
        stocksDao.decreaseStock(stockUpdateRequestDTO.getBookId(), stockUpdateRequestDTO.getAmount());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    public void setStock(StockUpdateRequestDTO stockUpdateRequestDTO, String username) {
        logService.insert(OperationTypes.UPDATE.getName(), TABLE_NAME, username);
        stocksDao.setStock(stockUpdateRequestDTO.getBookId(), stockUpdateRequestDTO.getAmount());
    }

}
