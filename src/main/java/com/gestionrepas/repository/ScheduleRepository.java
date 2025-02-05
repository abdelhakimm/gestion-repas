package com.gestionrepas.repository;

import com.gestionrepas.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
