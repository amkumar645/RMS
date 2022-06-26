package com.ria.rms.dao;

import com.ria.rms.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicantRepo extends JpaRepository<Applicant, String> {
    Optional<List<Applicant>> findAllByEmail(String value);
}
