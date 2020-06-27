package com.example.class6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.class6.Model.Student;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Student student = new Student();

    private EditText editTextName;
    private TextView textViewFirstGradeValue;
    private TextView textViewSecondGradeValue;

    private final int GRADE_INSERTION_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        textViewFirstGradeValue = findViewById(R.id.textViewFirstGradeValue);
        textViewSecondGradeValue = findViewById(R.id.textViewSecondGradeValue);
        Button buttonInsertGrades = findViewById(R.id.buttonInsertGrades);
        Button buttonCalculateAverage = findViewById(R.id.buttonCalculateAverage);

        buttonInsertGrades.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), GradeInsertionActivity.class);
            intent.putExtra("student", student);
            startActivityForResult(intent, GRADE_INSERTION_ACTIVITY_REQUEST_CODE);
        });

        buttonCalculateAverage.setOnClickListener(view -> {
            student.setName(String.valueOf(editTextName.getText()));

            Intent intent = new Intent(getApplicationContext(), AverageCalculatorActivity.class);
            intent.putExtra("student", student);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                student = (Student) Objects.requireNonNull(data.getSerializableExtra("student"));
                updateView();
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private void updateView() {
        textViewFirstGradeValue.setText(student.getGrades().get(0).toString());
        textViewSecondGradeValue.setText(student.getGrades().get(1).toString());
    }

}