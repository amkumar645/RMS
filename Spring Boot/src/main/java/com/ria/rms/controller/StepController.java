package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.StepDto;
import com.ria.rms.service.StepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_Steps)
@Slf4j
public class StepController {
    @Autowired
    private StepService stepService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(stepService.findAll());
        } else {
            return ResponseEntity.ok(stepService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(stepService.findById(id));
    }

    @GetMapping(UrlConstants.NAME)
    public ResponseEntity<?> findByName(@PathVariable String value) {
        return ResponseEntity.ok(stepService.findByName(value));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StepDto stepDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stepService.save(stepDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody StepDto stepDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(stepService.save(stepDto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(stepService.deleteById(id));
    }
}
