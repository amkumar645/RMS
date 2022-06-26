package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.JobPositionDto;
import com.ria.rms.service.JobPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_JobPositions)
@Slf4j
public class JobPositionController {


    @Autowired
    private JobPositionService jobPositionService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(jobPositionService.findAll());
        } else {
            return ResponseEntity.ok(jobPositionService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(jobPositionService.findById(id));
    }

    @GetMapping(UrlConstants.CODE)
    public ResponseEntity<?> findByCode(@PathVariable String value) {
        return ResponseEntity.ok(jobPositionService.findByCode(value));
    }

    @GetMapping(UrlConstants.NAME)
    public ResponseEntity<?> findByName(@PathVariable String value) {
        return ResponseEntity.ok(jobPositionService.findByName(value));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody JobPositionDto jobPositionDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPositionService.save(jobPositionDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody JobPositionDto jobPositionDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPositionService.update(jobPositionDto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(jobPositionService.deleteById(id));
    }
}
