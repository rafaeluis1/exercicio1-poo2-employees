package com.facens.poo.exercicio.exercicio1.repositories;

import java.util.ArrayList;
import java.util.List;

import com.facens.poo.exercicio.exercicio1.entities.Employee;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepository {
    public List<Employee> getEmployees(){


        Employee c1 = new Employee();
        c1.setId(1);
        c1.setName("Eduardo Garcia");
        c1.setAddress("Rua Antonio Castanharo");
        c1.setCargo("Chapa");

        Employee c2 = new Employee();
        c2.setId(2);
        c2.setName("Claudio Cruz");
        c2.setAddress("Rua Brasilia");
        c2.setCargo("Pintor");

        Employee c3 = new Employee();
        c3.setId(3);
        c3.setName("Cristofer Gonçalo");
        c3.setAddress("Rua India");
        c3.setCargo("Auxiliar de Obras");


        List<Employee> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        

        return list;

    }
    
}
