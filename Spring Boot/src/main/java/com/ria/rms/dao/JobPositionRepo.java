package com.ria.rms.dao;

import com.ria.rms.entity.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobPositionRepo extends JpaRepository<JobPosition, String> {

    Optional<List<JobPosition>> findAllByCodeStartsWith(String value);

    Optional<List<JobPosition>> findAllByName(String value);
}
