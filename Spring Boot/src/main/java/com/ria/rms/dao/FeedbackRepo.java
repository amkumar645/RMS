package com.ria.rms.dao;

import com.ria.rms.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback, String> {

}
