package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Professor;
import br.com.senac.service.ProfessorService;

@Controller
@RequestMapping(value= "professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping(value= "/listarProfessores")
	public ModelAndView listarTodosProfessores() {
		ModelAndView mv = new ModelAndView("professor/listarProfessores");
		mv.addObject("professores",professorService.buscarTodosProfessores());
		return mv;
	}
	
	@GetMapping("/cadastrarProfessor")
	public ModelAndView cadastrarProfessor(Professor professor) {
		ModelAndView mv = new ModelAndView("professor/cadastrarProfessor");
		mv.addObject("professor",new Professor());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Professor professor) {
		professorService.salvar(professor);
		return listarTodosProfessores();
	}
	
}
