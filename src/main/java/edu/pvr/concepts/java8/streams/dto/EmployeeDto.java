package edu.pvr.concepts.java8.streams.dto;

import java.util.List;

public class EmployeeDto {

    private String name;
    private List<String> emails;

    public EmployeeDto(String name, List<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
