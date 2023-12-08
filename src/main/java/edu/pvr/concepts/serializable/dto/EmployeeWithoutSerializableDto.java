package edu.pvr.concepts.serializable.dto;

public class EmployeeWithoutSerializableDto {

    private String name;
    private String place;
    private String password;

    public EmployeeWithoutSerializableDto(String name, String place, String password) {
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
