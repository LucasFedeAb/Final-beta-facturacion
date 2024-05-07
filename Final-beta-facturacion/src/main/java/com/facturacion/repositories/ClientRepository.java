package com.facturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.models.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}