package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.ApplicationDto;
import com.ria.rms.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_Applications)
@Slf4j
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(applicationService.findAll());
        } else {
            return ResponseEntity.ok(applicationService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(applicationService.findById(id));
    }

    @GetMapping(UrlConstants.JOB_ID)
    public ResponseEntity<?> findByJobId(@PathVariable String value) {
        return ResponseEntity.ok(applicationService.findByJobId(value));
    }

    @GetMapping(UrlConstants.APPLICANT_ID)
    public ResponseEntity<?> findByAppId(@PathVariable String value) {
        return ResponseEntity.ok(applicationService.findByApplicantId(value));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ApplicationDto applicationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationService.save(applicationDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ApplicationDto applicationDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationService.update(applicationDto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(applicationService.deleteById(id));
    }
}
