package com.centercity.server.repository;

import com.centercity.server.entity.STOWork;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository <STOWork, Long> {
}
