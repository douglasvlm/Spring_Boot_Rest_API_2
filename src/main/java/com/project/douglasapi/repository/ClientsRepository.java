package com.project.douglasapi.repository;

import com.project.douglasapi.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
