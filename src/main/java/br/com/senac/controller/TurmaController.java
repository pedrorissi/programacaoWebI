package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping(value= "turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping(value= "/listarTurmas")
	public ModelAndView listarTodasTurmas() {
		ModelAndView mv = new ModelAndView("turma/listarTurmas");
		mv.addObject("turmas",turmaService.buscarTodasTurmas());
		return mv;
	}
	
	@GetMapping("/cadastrarTurma")
	public ModelAndView cadastrarTurma(Turma turma) {
		ModelAndView mv = new ModelAndView("turma/cadastrarTurma");
		mv.addObject("turma",new Turma());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Turma turma) {
		turmaService.salvar(turma);
		return listarTodasTurmas();
	}
	
}
