package com.store.book.mongo.controller;

import com.store.book.mongo.model.LogDTO;
import com.store.book.mongo.service.LogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Logs API")
@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private LogService logService ;

    @GetMapping(value="/getAll")
    public ResponseEntity<List<LogDTO>> getAll() {
        List<LogDTO> logDTOList = logService.getAll();

        return ResponseEntity.ok(logDTOList);
    }

    @PostMapping(value="/getOne/")
    public ResponseEntity<LogDTO>  getOne(@RequestParam(name = "id") String id) {

        LogDTO logDTO = logService.getOne(id);

        return ResponseEntity.ok(logDTO);
    }
}
