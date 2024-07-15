package edu.pvr.concepts.java8.streams.flatmap;

import edu.pvr.concepts.common.utils.ConsoleUtil;
import edu.pvr.concepts.java8.streams.dto.EmployeeDto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapConcept {
    
    private static List<String> collectAllEmails(List<EmployeeDto> employees) {
        return employees.stream()
                .map(EmployeeDto::getEmails)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<String> allEmails = collectAllEmails(List.of(
                new EmployeeDto("pvr", List.of("pvr@gmail.com", "pvr1@gmail.com")),
                new EmployeeDto("pranav", List.of("pranav@gmail.com", "pranav@gmail.com"))
        ));

        ConsoleUtil.info(allEmails.toString());
    }
}
