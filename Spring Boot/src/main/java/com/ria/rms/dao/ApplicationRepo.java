package com.ria.rms.dao;

import com.ria.rms.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepo extends JpaRepository<Application, String> {
    Optional<List<Application>> findAllByJobId(String value);

    Optional<List<Application>> findAllByApplicantId(String value);
}
