package com.example.class6.Service;

import com.example.class6.Model.Student;

public class AverageService {
    public static Double calculate(Student student) {
        return student
                .getGrades()
                .stream()
                .reduce(0d, Double::sum)
                / student.getGrades().size();
    }
}
