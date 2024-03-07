package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class landingPage extends AppCompatActivity {

    List<QuizModel> quizModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        quizModelList = new ArrayList<>();


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_landing_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getDataFromFirebase();
    }

    private void getDataFromFirebase(){
        quizModelList.add(new QuizModel("1", "Programming", "All the basic programming", "10"));

        quizModelList.add(new QuizModel("2", "Mathematics", "All the basic mathematics", "20"));
    }

}