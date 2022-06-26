package com.ria.rms.dao;

import com.ria.rms.entity.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobCategoryRepo extends JpaRepository<JobCategory, String> {
    Optional<List<JobCategory>> findAllByCodeStartsWith(String value);

    Optional<List<JobCategory>> findAllByName(String value);
}
