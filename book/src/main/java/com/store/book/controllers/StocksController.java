package com.store.book.controllers;

import com.store.book.domains.dto.StockInsertRequestDTO;
import com.store.book.domains.dto.StockUpdateRequestDTO;
import com.store.book.services.StockService;
import com.store.book.utils.CommonUtils;
import com.store.book.utils.exceptions.ValidationException;
import com.store.book.utils.results.Result;
import com.store.book.utils.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@RestController
@RequestMapping("/api/stocks")
public class StocksController {
    @Autowired
    private StockService stockService;

    @RolesAllowed("admins")
    @GetMapping("/getAll")
    ResponseEntity<Result> getAll(Principal principal) {
        return ResponseEntity.status(200).body(new SuccessDataResult<>(stockService.getAll(CommonUtils.getUsername(principal))));
    }

    @RolesAllowed("admins")
    @GetMapping("/getOne")
    ResponseEntity<Result> getOne(@RequestParam(name = "id") Long id, Principal principal) {
        return ResponseEntity.status(200).body(new SuccessDataResult<>(stockService.getOne(id, CommonUtils.getUsername(principal))));
    }

    @RolesAllowed("admins")
    @PostMapping("/insertOne")
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    ResponseEntity<Result> insertOne(@RequestBody @Validated StockInsertRequestDTO stockInsertRequestDTO, BindingResult result, Principal principal) {
        if(result != null && result.hasErrors()) {
            throw new ValidationException(result);
        }
        return ResponseEntity.status(201).body(new SuccessDataResult<>(stockService.insertOne(stockInsertRequestDTO, CommonUtils.getUsername(principal))));
    }

    @RolesAllowed("admins")
    @PostMapping("/setStock")
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    ResponseEntity setStock(@RequestBody @Validated StockUpdateRequestDTO stockUpdateRequestDTO, BindingResult result, Principal principal) {
        if(result != null && result.hasErrors()) {
            throw new ValidationException(result);
        }
        stockService.setStock(stockUpdateRequestDTO, CommonUtils.getUsername(principal));
        return ResponseEntity.noContent().build();
    }
}
