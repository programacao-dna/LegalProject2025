package io.americanas.legals.service;

import io.americanas.legals.model.DepartamentoModel;
import io.americanas.legals.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository repository;

    public Optional<DepartamentoModel> addNewDepartment(DepartamentoModel department) {
        DepartamentoModel savedModel = repository.save(department);
        return Optional.of(savedModel);
    }

    public List<DepartamentoModel> getAllDepartments() {
        return repository.findAll();
    }

}
