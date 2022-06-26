package com.ria.rms.controller;

import com.ria.rms.constants.UrlConstants;
import com.ria.rms.dto.LoginDto;
import com.ria.rms.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(UrlConstants.API_V_1_Login)
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam Map<String, Object> queryParams) {
        if (queryParams.isEmpty()) {
            return ResponseEntity.ok(loginService.findAll());
        } else {
            return ResponseEntity.ok(loginService.findAll(queryParams));
        }
    }

    @GetMapping(UrlConstants.ID)
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(loginService.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody LoginDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(dto));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody LoginDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(loginService.update(dto));
    }

    @DeleteMapping(UrlConstants.ID)
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(loginService.deleteById(id));
    }
}
