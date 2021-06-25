package br.com.house.contas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.house.contas.model.StatusTitulo;
import br.com.house.contas.model.Titulo;
import br.com.house.contas.repository.Titulos;
import br.com.house.contas.repository.filter.TituloFilter;

@Service
public class CadastroTituloService {
	
	@Autowired
	private Titulos titulos;
	
	public void salvar(Titulo titulo) {
		
		try {
		titulos.save(titulo);
		}catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}
	
	public void excluir(Long codigo) {
		titulos.deleteById(codigo);
	}

	public String receber(Long codigo) {
		Titulo titulo = titulos.getOne(codigo);
		titulo.setStatus(StatusTitulo.PAGO);
		titulos.save(titulo);
		
		return StatusTitulo.PAGO.getDescricao();
	}
	
	public List<Titulo> filtrar(TituloFilter filtro) {
		String descricao = filtro.getDescricao() == null ? "" : filtro.getDescricao();
		return titulos.findByDescricaoContaining(descricao);
	}

}
