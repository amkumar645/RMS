package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.FeedbackDto;
import com.ria.rms.service.FeedbackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_Feedbacks)
@Slf4j
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(feedbackService.findAll());
        } else {
            return ResponseEntity.ok(feedbackService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(feedbackService.findById(id));
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody FeedbackDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.save(dto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody FeedbackDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.update(dto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(feedbackService.deleteById(id));
    }
}
