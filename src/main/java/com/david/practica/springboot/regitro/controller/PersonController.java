package com.david.practica.springboot.regitro.controller;

import com.david.practica.springboot.regitro.model.Person;
import com.david.practica.springboot.regitro.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "persons-list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("person", new Person());
        return "person-form";
    }

    @PostMapping
    public String save(Person person) {
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "person-form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return "redirect:/persons";
    }




}
