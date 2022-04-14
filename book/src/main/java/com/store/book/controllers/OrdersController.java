package com.store.book.controllers;

import com.store.book.domains.dto.OrderInsertRequestDTO;
import com.store.book.services.OrderService;
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
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @RolesAllowed("admins")
    @GetMapping("/getAll")
    ResponseEntity<Result> getAll(Principal principal) {
        return ResponseEntity.status(200).body(new SuccessDataResult<>(orderService.getAll(CommonUtils.getUsername(principal))));
    }

    @RolesAllowed("admins")
    @GetMapping("/getOne")
    ResponseEntity<Result> getOne(@RequestParam(name = "id") Long id, Principal principal) {
        return ResponseEntity.status(200).body(new SuccessDataResult<>(orderService.getOne(id, CommonUtils.getUsername(principal))));
    }

    @RolesAllowed("admins")
    @PostMapping("/insertOne")
    @Transactional(propagation = Propagation.SUPPORTS,isolation= Isolation.READ_UNCOMMITTED,rollbackFor = Exception.class)
    ResponseEntity<Result> insertOne(@RequestBody @Validated OrderInsertRequestDTO orderInsertRequestDTO, BindingResult result, Principal principal) {
        if(result != null && result.hasErrors()) {
            throw new ValidationException(result);
        }
        return ResponseEntity.status(201).body(new SuccessDataResult<>(orderService.insertOne(orderInsertRequestDTO, CommonUtils.getUsername(principal))));
    }
}
