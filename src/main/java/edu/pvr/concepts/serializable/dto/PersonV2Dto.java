package edu.pvr.concepts.serializable.dto;

import java.io.Serializable;

public class PersonV2Dto implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name;
    private String phoneNo;

    public PersonV2Dto(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "PersonV2Dto{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
