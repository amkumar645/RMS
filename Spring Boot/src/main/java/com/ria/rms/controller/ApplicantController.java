package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.ApplicantDto;
import com.ria.rms.service.ApplicantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_Applicants)
@Slf4j
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(applicantService.findAll());
        } else {
            return ResponseEntity.ok(applicantService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(applicantService.findById(id));
    }

    @GetMapping(UrlConstants.EMAIL)
    public ResponseEntity<?> findByName(@PathVariable String value) {
        return ResponseEntity.ok(applicantService.findByEmail(value));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ApplicantDto applicantDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicantService.save(applicantDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ApplicantDto applicantDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applicantService.update(applicantDto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(applicantService.deleteById(id));
    }
}
