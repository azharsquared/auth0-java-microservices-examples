package com.example.busservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BusRepository extends JpaRepository<Bus, Long> {
}
