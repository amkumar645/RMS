package com.ria.rms.dao;

import com.ria.rms.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepo extends JpaRepository<Interview, String> {

}
