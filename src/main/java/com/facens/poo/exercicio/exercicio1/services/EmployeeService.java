package com.facens.poo.exercicio.exercicio1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.poo.exercicio.exercicio1.dto.EmployeeDTO;
import com.facens.poo.exercicio.exercicio1.dto.EmployeeInsertDTO;
import com.facens.poo.exercicio.exercicio1.dto.EmployeeUpdateDTO;
import com.facens.poo.exercicio.exercicio1.entities.Employee;
import com.facens.poo.exercicio.exercicio1.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<EmployeeDTO> getEmployees() {

        List<Employee> list = repo.findAll();
        return toDTOList(list);

    }

    public EmployeeDTO getEmployeeById(Integer id) {

        Optional<Employee> op = repo.findById(id);
        Employee employee = op
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found"));

        return new EmployeeDTO(employee);
    }

    public EmployeeDTO insert(EmployeeInsertDTO insertDTO) {

        Employee entity = new Employee(insertDTO);
        entity = repo.save(entity);
        return new EmployeeDTO(entity);

    }

    public EmployeeDTO update(Integer id, EmployeeUpdateDTO updateDTO) {
        try {
            Employee entity = repo.getOne(id);
            entity.setSalary(updateDTO.getSalary());
            entity = repo.save(entity);
            return new EmployeeDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    public void delete(Integer id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }

    public List<EmployeeDTO> toDTOList(List<Employee> list) {
        List<EmployeeDTO> listDTO = new ArrayList<>();

        for (Employee c : list) {

            listDTO.add(new EmployeeDTO(c.getId(), c.getName(), c.getCargo()));
        }

        return listDTO;

    }

}
