package com.ria.rms.dao;

import com.ria.rms.entity.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StepRepo extends JpaRepository<Step, String> {
    Optional<List<Step>> findAllByName(String value);
}
