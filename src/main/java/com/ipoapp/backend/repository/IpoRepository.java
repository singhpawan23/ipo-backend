package com.ipoapp.backend.repository;

import com.ipoapp.backend.model.Ipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IpoRepository extends JpaRepository<Ipo, Long> {
}