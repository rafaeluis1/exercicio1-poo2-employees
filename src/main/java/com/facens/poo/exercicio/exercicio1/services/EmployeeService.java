package com.facens.poo.exercicio.exercicio1.services;

import java.util.ArrayList;
import java.util.List;

import com.facens.poo.exercicio.exercicio1.dto.EmployeeDTO;
import com.facens.poo.exercicio.exercicio1.entities.Employee;
import com.facens.poo.exercicio.exercicio1.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<EmployeeDTO> getEmployees(){

        List<Employee> list = repo.getEmployees();

        List<EmployeeDTO> listDTO = new ArrayList<>();

        for (Employee c: list){

            listDTO.add(new EmployeeDTO(c.getId(),c.getName(),c.getCargo()));
        }

        return listDTO;


    }
    
}
