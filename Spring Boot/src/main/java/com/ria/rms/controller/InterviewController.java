package com.ria.rms.controller;


import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.InterviewDto;
import com.ria.rms.service.InterviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_Interviews)
@Slf4j
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(interviewService.findAll());
        } else {
            return ResponseEntity.ok(interviewService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(interviewService.findById(id));
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody InterviewDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(interviewService.save(dto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody InterviewDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(interviewService.update(dto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(interviewService.deleteById(id));
    }
}
