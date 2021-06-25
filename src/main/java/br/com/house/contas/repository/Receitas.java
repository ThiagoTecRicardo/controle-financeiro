package br.com.house.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.house.contas.model.Receita;

public interface Receitas extends JpaRepository<Receita, Long>{

}
