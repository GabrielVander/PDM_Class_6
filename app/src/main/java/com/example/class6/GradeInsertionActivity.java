package com.example.class6;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.class6.Model.Student;

public class GradeInsertionActivity extends AppCompatActivity {
    private EditText editDecimalFirstGrade;
    private EditText editDecimalSecondGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_inssertion);

        Intent intent = getIntent();

        editDecimalFirstGrade = findViewById(R.id.editDecimalFirstGrade);
        editDecimalSecondGrade = findViewById(R.id.editDecimalSecondGrade);
        Button buttonOk = findViewById(R.id.buttonOk);

        buttonOk.setOnClickListener(view -> {
            Student student = (Student) intent.getSerializableExtra("student");

            assert student != null;
            student.addGrade(Double.valueOf(String.valueOf(editDecimalFirstGrade.getText())));
            student.addGrade(Double.valueOf(String.valueOf(editDecimalSecondGrade.getText())));

            Intent newIntent = new Intent();
            newIntent.putExtra("student", student);

            setResult(RESULT_OK, newIntent);

            finish();
        });
    }
}