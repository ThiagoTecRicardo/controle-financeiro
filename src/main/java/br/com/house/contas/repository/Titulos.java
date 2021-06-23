package br.com.house.contas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.house.contas.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long>{
	
	

}
