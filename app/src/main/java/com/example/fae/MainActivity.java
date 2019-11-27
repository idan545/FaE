package com.example.fae;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById (R.id.btn);
    }

    public class Student {

        private int GradeClass;
        private int StuClass;
        private String StuName;
        private String StuID;

        public Student(int GradeClass, int StuClass, String StuName, String StuID) {
            this.GradeClass = GradeClass;
            this.StuClass = StuClass;
            this.StuName = StuName;
            this.StuID = StuID;
        }
    }
    public class StuGrade {

        private String StuID;
        private String ClassSubject;
        private String GradeType;
        private int FinalGrade;

        public StuGrade(String StuID, String ClassSubject, String GradeType, int FinalGrade) {
            this.StuID = StuID;
            this.ClassSubject = ClassSubject;
            this.GradeType = GradeType;
            this.FinalGrade = FinalGrade;
        }
    }
    }
