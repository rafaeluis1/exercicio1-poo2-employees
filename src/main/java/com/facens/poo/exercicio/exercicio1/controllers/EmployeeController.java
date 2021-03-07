package com.facens.poo.exercicio.exercicio1.controllers;

import java.net.URI;
import java.util.List;

import com.facens.poo.exercicio.exercicio1.dto.EmployeeDTO;
import com.facens.poo.exercicio.exercicio1.dto.EmployeeInsertDTO;
import com.facens.poo.exercicio.exercicio1.dto.EmployeeUpdateDTO;
import com.facens.poo.exercicio.exercicio1.entities.Employee;
import com.facens.poo.exercicio.exercicio1.services.EmployeeService;

import org.hibernate.internal.util.beans.BeanInfoHelper.ReturningBeanInfoDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        List<EmployeeDTO> list = service.getEmployees();

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> insert(@RequestBody EmployeeInsertDTO insertDTO) {
        EmployeeDTO dto = service.insert(insertDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
        EmployeeDTO dto = service.getEmployeeById(id);

        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeUpdateDTO updateDto, @PathVariable Integer id) {
        EmployeeDTO dto = service.update(id, updateDto);
        return ResponseEntity.ok().body(dto);
    }

}
