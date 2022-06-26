package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.JobCategoryDto;
import com.ria.rms.service.JobCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_JobCategories)
@Slf4j
public class JobCategoryController {


    @Autowired
    private JobCategoryService jobCategoryService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(jobCategoryService.findAll());
        } else {
            return ResponseEntity.ok(jobCategoryService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(jobCategoryService.findById(id));
    }

    @GetMapping(UrlConstants.CODE)
    public ResponseEntity<?> findByCode(@PathVariable String value) {
        return ResponseEntity.ok(jobCategoryService.findByCode(value));
    }

    @GetMapping(UrlConstants.NAME)
    public ResponseEntity<?> findByName(@PathVariable String value) {
        return ResponseEntity.ok(jobCategoryService.findByName(value));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody JobCategoryDto jobCategoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobCategoryService.save(jobCategoryDto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody JobCategoryDto jobCategoryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobCategoryService.update(jobCategoryDto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(jobCategoryService.deleteById(id));
    }
}
