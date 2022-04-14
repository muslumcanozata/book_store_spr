package com.store.book.services;

import com.store.book.domains.dto.StockInsertRequestDTO;
import com.store.book.domains.dto.StockUpdateRequestDTO;
import com.store.book.domains.dto.StocksDTO;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockService {
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    StocksDTO insertOne(StockInsertRequestDTO stockInsertRequestDTO, String username);

    StocksDTO getOne(Long id, String username);

    List<StocksDTO> getAll(String username);

    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    void increaseStock(StockUpdateRequestDTO stockUpdateRequestDTO, String username);

    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    void decreaseStock(StockUpdateRequestDTO stockUpdateRequestDTO, String username);

    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    void setStock(StockUpdateRequestDTO stockUpdateRequestDTO, String username);
}
