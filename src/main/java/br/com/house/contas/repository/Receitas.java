package br.com.house.contas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.house.contas.model.Descricao;
import br.com.house.contas.model.Receita;
import br.com.house.contas.model.Titulo;

public interface Receitas extends JpaRepository<Receita, Long>{

	public List<Titulo> findByDescricaoContaining(Descricao descricao);
}
