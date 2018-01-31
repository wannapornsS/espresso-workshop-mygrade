package com.example.jacksw.mygrade;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.GradeDisplay;
import com.example.MyGradeController;

public class MainActivity extends AppCompatActivity implements GradeDisplay {

    MyGradeController controller = new MyGradeController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSubmit(View view) {
        this.controller.onSubmit();
    }

    @NonNull
    public Integer getScore() {
        EditText scoreInput = (EditText)findViewById(R.id.scoreInput);
        return Integer.parseInt(scoreInput.getText().toString());
    }

    public void setGrade(String grade) {
        TextView gradeText = (TextView)findViewById(R.id.gradeView);
        gradeText.setText(grade);

        gradeText.setVisibility(View.VISIBLE);
        TextView gradeCaption = (TextView)findViewById(R.id.gradeCaption);
        gradeCaption.setVisibility(View.VISIBLE);
    }

}
