package com.ria.rms.dao;

import com.ria.rms.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepo extends JpaRepository<Job, String> {
    Optional<List<Job>> findAllByCodeStartsWith(String value);

    Optional<List<Job>> findAllByName(String value);
}
