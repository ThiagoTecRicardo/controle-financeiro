package br.com.house.contas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.house.contas.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long>{
	
	public List<Titulo> findByDescricaoContaining(String descricao);

}
