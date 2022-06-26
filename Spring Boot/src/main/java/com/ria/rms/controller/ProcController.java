package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.ProcDto;
import com.ria.rms.service.ProcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_Processes)
@Slf4j
public class ProcController {
    @Autowired
    private ProcService procService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(procService.findAll());
        } else {
            return ResponseEntity.ok(procService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(procService.findById(id));
    }

    @GetMapping(UrlConstants.NAME)
    public ResponseEntity<?> findByName(@PathVariable String value) {
        return ResponseEntity.ok(procService.findByName(value));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProcDto procDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(procService.save(procDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProcDto procDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(procService.save(procDto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(procService.deleteById(id));
    }
}
