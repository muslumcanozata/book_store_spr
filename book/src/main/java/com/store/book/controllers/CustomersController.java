package com.store.book.controllers;

import com.store.book.domains.dto.CustomerInsertRequestDTO;
import com.store.book.services.CustomerService;
import com.store.book.utils.CommonUtils;
import com.store.book.utils.exceptions.ValidationException;
import com.store.book.utils.results.Result;
import com.store.book.utils.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.smartcardio.CommandAPDU;
import java.security.Principal;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    @Autowired
    private CustomerService customerService;

    @RolesAllowed("admins")
    @GetMapping("/getAll")
    ResponseEntity<Result> getAll(Principal principal) {
        return ResponseEntity.status(200).body(new SuccessDataResult<>(customerService.getAll(CommonUtils.getUsername(principal))));
    }

    @RolesAllowed("admins")
    @GetMapping("/getOne")
    ResponseEntity<Result> getOne(@RequestParam(name = "id") Long id, Principal principal) {
        String username = CommonUtils.getUsername(principal);
        return ResponseEntity.status(200).body(new SuccessDataResult<>(customerService.getOne(id, username)));
    }

    @RolesAllowed("admins")
    @PostMapping("/insertOne")
    ResponseEntity<Result> insertOne(@RequestBody @Validated CustomerInsertRequestDTO customerInsertRequestDTO, BindingResult result, Principal principal) {
        if(result != null && result.hasErrors()) {
            throw new ValidationException(result);
        }
        String username = CommonUtils.getUsername(principal);
        return ResponseEntity.status(201).body(new SuccessDataResult<>(customerService.insertOne(customerInsertRequestDTO, username)));
    }
}
