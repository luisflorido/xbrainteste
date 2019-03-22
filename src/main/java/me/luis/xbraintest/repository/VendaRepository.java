package me.luis.xbraintest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.luis.xbraintest.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
