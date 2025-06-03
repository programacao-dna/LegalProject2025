package io.americanas.legals.controller;

import io.americanas.legals.model.DepartamentoModel;
import io.americanas.legals.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    DepartamentoService service;

    @PostMapping
    public DepartamentoModel createDepartamento(@RequestBody DepartamentoModel departamento) {
        return service.addNewDepartment(departamento).orElseThrow(() -> new RuntimeException("Departamento não criado"));
    }

    @GetMapping
    public List<DepartamentoModel> getAllDepartamentos() {
        return service.getAllDepartments();
    }

}
