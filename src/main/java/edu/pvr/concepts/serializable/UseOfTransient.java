package edu.pvr.concepts.serializable;

import edu.pvr.concepts.common.utils.ConsoleUtil;
import edu.pvr.concepts.serializable.dto.EmployeeDto;
import edu.pvr.concepts.serializable.dto.EmployeeWithoutSerializableDto;

import static edu.pvr.concepts.common.utils.FileUtils.createDirectoryIfNotExists;
import static edu.pvr.concepts.serializable.SerializationUtil.deserializeFromFile;
import static edu.pvr.concepts.serializable.SerializationUtil.serializeToFile;

public class UseOfTransient {

    private static void serializeDeserialize() {
        EmployeeDto employee = new EmployeeDto("John Doe", "Cityville", "securepassword");

        createDirectoryIfNotExists("tmp");
        String filename = "employee.ser";
        String dir = "tmp";
        serializeToFile(employee, dir, filename);

        ConsoleUtil.info("Employee serialized to " + filename);

        EmployeeDto emp = deserializeFromFile(EmployeeDto.class, dir, filename);

        if (emp != null) {
            ConsoleUtil.success("Employee deserialized: " + emp);
        } else {
            ConsoleUtil.danger("Error deserializing the Employee object.");
        }
    }

    private static void serializeDeserializeForNonMarked() {
        EmployeeWithoutSerializableDto employee = new EmployeeWithoutSerializableDto("John Doe", "Cityville", "securepassword");

        createDirectoryIfNotExists("tmp");
        String filename = "employee.ser";
        String dir = "tmp";
        serializeToFile(employee, dir, filename);

        ConsoleUtil.info("Employee serialized to " + filename);

        EmployeeDto emp = deserializeFromFile(EmployeeDto.class, dir, filename);

        if (emp != null) {
            ConsoleUtil.success("Employee deserialized: " + emp);
        } else {
            ConsoleUtil.danger("Error deserializing the Employee object.");
        }
    }

    public static void main(String[] args) {
        serializeDeserialize();
        serializeDeserializeForNonMarked();
    }
}
