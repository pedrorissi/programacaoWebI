package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.entity.Curso;
import br.com.senac.service.CursoService;

@Controller
@RequestMapping(value="curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping(value="/listarCursos")
	public ModelAndView listarTodosCursos() {
		ModelAndView mv = new ModelAndView("curso/listarCursos");
		mv.addObject("cursos",cursoService.buscarTodosCursos());
		return mv;
	}	
	
	@GetMapping("/cadastrarCurso")
	public ModelAndView cadastrarCurso(Curso curso) {
		ModelAndView mv = new ModelAndView("curso/cadastrarCurso");
		mv.addObject("curso",new Curso());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Curso curso) {
		cursoService.salvar(curso);
		return listarTodosCursos();
	}
}
