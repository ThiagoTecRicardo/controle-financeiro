package br.com.house.contas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.house.contas.model.Receita;
import br.com.house.contas.model.StatusReceber;
import br.com.house.contas.model.StatusTitulo;
import br.com.house.contas.repository.Receitas;

@Service
public class cadastroReceitaService {

	@Autowired
	private Receitas receitas;

	public void salvar(Receita receita) {

		try {
			receitas.save(receita);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}

	public void excluir(Long codigo) {
		receitas.deleteById(codigo);
	}
	
	public String receber(Long codigo) {
		Receita receita = receitas.getOne(codigo);
		receita.setStatus(StatusReceber.PAGO);
		receitas.save(receita);
		
		return StatusTitulo.PAGO.getDescricao();
	}

	

	
}
