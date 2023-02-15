package com.crud.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.modelo.Persona;
import com.crud.serviceInterface.IPersonaService;
import javax.validation.Valid;
import org.springframework.ui.Model;

@Controller
@RequestMapping
public class PersonaControler {

    @Autowired
    private IPersonaService service;

    @GetMapping("/")
    public String inicio() {
        return "index";
    }
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("personasLista", service.listar());
                model.addAttribute("personaGuardar", new Persona());
		return "productos";
	}
	@GetMapping("/listar/{id}")
	public String listarId(@PathVariable int id,Model model) {
		model.addAttribute("personaGuardar", service.listarId(id));
                model.addAttribute("personasLista", service.listar());
		return "productos";
	}
	
	@PostMapping("/save")
	public String save(@Valid Persona p,Model model) {
		int id=service.save(p);
		if(id==0) {
			return "productos";
		}
		return "redirect:/listar";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable int id,Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
}
