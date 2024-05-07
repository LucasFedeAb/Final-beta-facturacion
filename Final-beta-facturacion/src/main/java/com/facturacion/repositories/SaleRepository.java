package com.facturacion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.models.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository <Sale, Integer> {
	List<Sale> findByClientId(Integer clientId);
	List<Sale> findByClientDni(Integer clientId);
}
