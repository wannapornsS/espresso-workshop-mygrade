package com.example;

public class MyGradeController {

    private GradeDisplay display;

    private GradeConverter converter = new GradeConverter();

    public MyGradeController(GradeDisplay display){
        this.display = display;
    }

    public void onSubmit(){
        Integer score = this.display.getScore();
        String grade = this.converter.fromScore(score);
        this.display.setGrade(grade);
    }

    public void setGradeConverter(GradeConverter converter) {
        this.converter = converter;
    }
}
