package com.ria.rms.dao;

import com.ria.rms.entity.Proc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProcRepo extends JpaRepository<Proc, String> {
    Optional<List<Proc>> findAllByName(String value);
}
