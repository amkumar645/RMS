package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.JobDto;
import com.ria.rms.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_Jobs)
@Slf4j
public class JobController {


    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(jobService.findAll());
        } else {
            return ResponseEntity.ok(jobService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(jobService.findById(id));
    }

    @GetMapping(UrlConstants.CODE)
    public ResponseEntity<?> findByCode(@PathVariable String value) {
        return ResponseEntity.ok(jobService.findByCode(value));
    }

    @GetMapping(UrlConstants.NAME)
    public ResponseEntity<?> findByName(@PathVariable String value) {
        return ResponseEntity.ok(jobService.findByName(value));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody JobDto jobDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.save(jobDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody JobDto jobDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobService.update(jobDto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(jobService.deleteById(id));
    }
}
