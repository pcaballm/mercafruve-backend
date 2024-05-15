package com.api.crud.repositories;

import com.api.crud.models.LogSubasta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LogSubastaRepository extends JpaRepository<LogSubasta, Long> {

    List<LogSubasta> findAllBySubasta(Long id);
}
