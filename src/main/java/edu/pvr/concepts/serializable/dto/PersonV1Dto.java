package edu.pvr.concepts.serializable.dto;

import java.io.Serializable;

public class PersonV1Dto implements Serializable {
    private static final long serialVersionUID = 3L;

    private String name;
    private int phoneNo;

    public PersonV1Dto(String name, int phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "PersonV1Dto{" +
                "name='" + name + '\'' +
                ", phoneNo=" + phoneNo +
                '}';
    }
}
