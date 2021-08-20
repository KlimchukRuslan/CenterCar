package com.centercity.server.repository;

import com.centercity.server.entity.FinDataUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinRepository extends JpaRepository<FinDataUser, Long> {

}