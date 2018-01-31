package com.example;

import java.util.LinkedHashMap;
import java.util.Map;

public class GradeConverter {

    public String fromScore(Integer score) {

        Map<Integer, String> rules = getConversionRules();

        String grade = "F";

        for( Map.Entry<Integer, String> entry: rules.entrySet()) {
            if ( score >= entry.getKey()){
                grade = entry.getValue();
                break;
            }
        }
        return grade;
    }

    private Map<Integer, String> getConversionRules() {
        Map<Integer, String> rules = new LinkedHashMap<>();

        rules.put(80, "A");
        rules.put(70, "B");
        rules.put(60, "C");
        rules.put(50, "D");

        return rules;
    }
}
