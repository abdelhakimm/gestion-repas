package com.gestionrepas.repository;

import com.gestionrepas.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
