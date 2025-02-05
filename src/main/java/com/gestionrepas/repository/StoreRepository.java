package com.gestionrepas.repository;

import com.gestionrepas.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
