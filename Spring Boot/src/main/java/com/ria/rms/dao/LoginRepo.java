package com.ria.rms.dao;

import com.ria.rms.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepo extends JpaRepository<Login, String> {
}
