package com.centercity.server.repository;

import com.centercity.server.entity.FinDateAndWeek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinDateRepository extends JpaRepository<FinDateAndWeek, Long> {

}