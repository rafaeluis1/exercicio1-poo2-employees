package com.facens.poo.exercicio.exercicio1.dto;

public class EmployeeDTO {
    

    private Integer id;
    private String name;
    private String cargo;

    public EmployeeDTO() {
	}

    public EmployeeDTO(Integer id2, String name2, String cargo2) {
        setId(id2);
        setName(name2);
        setCargo(cargo2);
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    
}
