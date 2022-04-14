package com.store.book.mongo.controller;

import com.store.book.mongo.model.LogDTO;
import com.store.book.mongo.service.LogService;
import com.store.book.utils.CommonUtils;
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
    public ResponseEntity<List<LogDTO>> getAll(Principal principal) {
        List<LogDTO> logDTOList = logService.getAll(CommonUtils.getUsername(principal));

        return ResponseEntity.ok(logDTOList);
    }

    @RolesAllowed("admins")
    @PostMapping(value="/getOne/")
    public ResponseEntity<LogDTO>  getOne(@RequestParam(name = "id") String id, Principal principal) {

        LogDTO logDTO = logService.getOne(id, CommonUtils.getUsername(principal));

        return ResponseEntity.ok(logDTO);
    }
}
