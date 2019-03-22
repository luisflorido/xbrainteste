package me.luis.xbraintest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.luis.xbraintest.model.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}
