package com.store.book.mongo.controller;

import com.store.book.mongo.model.LogDTO;
import com.store.book.mongo.service.LogService;
import com.store.book.utils.CommonUtils;
import com.store.book.utils.results.SuccessDataResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@Api(tags = "Logs API")
@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService logService ;

    @RolesAllowed("admins")
    @GetMapping(value="/getAll")
    public ResponseEntity<SuccessDataResult<List<LogDTO>>> getAll(Principal principal) {
        List<LogDTO> logDTOList = logService.getAll(CommonUtils.getUsername(principal));

        return ResponseEntity.ok(new SuccessDataResult<>(logDTOList));
    }

    @RolesAllowed("admins")
    @PostMapping(value="/getOne/")
    public ResponseEntity<SuccessDataResult<LogDTO>> getOne(@RequestParam(name = "id") String id, Principal principal) {

        LogDTO logDTO = logService.getOne(id, CommonUtils.getUsername(principal));

        return ResponseEntity.ok(new SuccessDataResult<>(logDTO));
    }
}
