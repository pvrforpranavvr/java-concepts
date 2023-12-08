package edu.pvr.concepts.serializable.dto;

import java.io.Serializable;

public class EmployeeDto implements Serializable {

    private String name;
    private String place;
    private transient String password;

    public EmployeeDto(String name, String place, String password) {
        this.name = name;
        this.place = place;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
