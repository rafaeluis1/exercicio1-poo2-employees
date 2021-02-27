package com.facens.poo.exercicio.exercicio1.repositories;

import com.facens.poo.exercicio.exercicio1.entities.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
