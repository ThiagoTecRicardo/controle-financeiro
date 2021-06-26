package br.com.house.contas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.house.contas.model.Receita;
import br.com.house.contas.model.StatusTitulo;
import br.com.house.contas.model.Titulo;
import br.com.house.contas.repository.Receitas;
import br.com.house.contas.repository.filter.TituloFilter;
import br.com.house.contas.service.cadastroReceitaService;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {
	
	@Autowired
	private Receitas receitas;
	
	@Autowired
	private cadastroReceitaService cadastroReceitaService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {

		ModelAndView mv = new ModelAndView("CadastroReceita");
		mv.addObject(new Receita()); 

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Receita receita ,Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			return "CadastroReceita";
		}
		
		try {
			cadastroReceitaService.salvar(receita);
			attributes.addFlashAttribute("mensagem", "Receita salvo com sucesso!");
			return "redirect:/receitas/novo";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return "CadastroTitulo";
		}
	}

	@RequestMapping
	public ModelAndView pesquisar(Receita receita) {
		List<Receita> todasReceitas = receitas.findAll();
		
		ModelAndView mv = new ModelAndView("PesquisaReceitas");
		mv.addObject("receitas", todasReceitas);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Long codigoReceita) {
		Receita receita = receitas.getOne(codigoReceita);
		
		ModelAndView mv = new ModelAndView("CadastroTitulo"); 
		mv.addObject(receita);
		return mv;
	}
	

	
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		cadastroReceitaService.excluir(codigo);
		
		attributes.addFlashAttribute("mensagem", "Título excluído com sucesso!");
		return "redirect:/titulos";
	}
	
	
	@RequestMapping(value = "/{codigo}/receber", method = RequestMethod.PUT)
	public @ResponseBody String receber(@PathVariable Long codigo) {
		return cadastroReceitaService.receber(codigo);
	}

	@ModelAttribute("todosStautsTitulo")
	public List<StatusTitulo> todosStatusTitulo() {

		return Arrays.asList(StatusTitulo.values());

	}

}
