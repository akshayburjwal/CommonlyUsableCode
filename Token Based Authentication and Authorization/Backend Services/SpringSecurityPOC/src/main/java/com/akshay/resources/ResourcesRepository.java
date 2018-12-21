package com.akshay.resources;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourcesRepository extends JpaRepository<Resource, Long> {
}