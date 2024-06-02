package org.ppc.controllers;

import org.ppc.entities.Employee;
import org.ppc.entities.Orgnisation;
import org.ppc.services.OrgnisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrgnisationController {

    @Autowired
    OrgnisationService orgnisationService;

    @GetMapping("/{id}/employees")
    public int getAllEmployee(@PathVariable int id){
       return orgnisationService.getAllEmployee(id).size();
    }

    @PostMapping("/{name}")
    public Orgnisation add(@PathVariable String name){
        return orgnisationService.add(name);
    }

}
