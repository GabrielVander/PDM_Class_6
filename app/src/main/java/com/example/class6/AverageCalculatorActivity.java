package com.example.class6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.class6.Model.Student;
import com.example.class6.Service.AverageService;

public class AverageCalculatorActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_average_calculator);

        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewFirstGrade = findViewById(R.id.textViewFirstGrade);
        TextView textViewSecondGrade = findViewById(R.id.textViewSecondGrade);
        TextView textViewAverage = findViewById(R.id.textViewAverage);

        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("student");

        assert student != null;
        textViewName.setText(student.getName());
        textViewFirstGrade.setText(student.getGrades().get(0).toString());
        textViewSecondGrade.setText(student.getGrades().get(1).toString());
        textViewAverage.setText(AverageService.calculate(student).toString());
    }
}