package br.com.house.contas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.house.contas.model.Receita;
import br.com.house.contas.repository.Receitas;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	private Receitas receitas;
	
	@RequestMapping
	public List<Receita> listar() {
		
		List<Receita> todasReitas = receitas.findAll();
		
		return todasReitas;
		
	}

}
