package com.example.finalassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private TextView q1TV;
    private TextView q2TV;
    private TextView q3TV;
    private TextView q4TV;
    private TextView q5TV;
    private EditText a1ET;
    private EditText a2ET;
    private EditText a3ET;
    private EditText a4ET;
    private EditText a5ET;
    private Button submitButton;
    String q1;
    String q2;
    String q3;
    String q4;
    String q5;
    private SQLiteDatabase db;
    int correctAnswerCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        q1TV = findViewById(R.id.q1TV);
        q2TV = findViewById(R.id.q2TV);
        q3TV = findViewById(R.id.q3TV);
        q4TV = findViewById(R.id.q4TV);
        q5TV = findViewById(R.id.q5TV);
        a1ET = findViewById(R.id.a1ET);
        a2ET = findViewById(R.id.a2ET);
        a3ET = findViewById(R.id.a3ET);
        a4ET = findViewById(R.id.a4ET);
        a5ET = findViewById(R.id.a5ET);
        submitButton = findViewById(R.id.submitButton);

        db = openOrCreateDatabase("quiz", MODE_PRIVATE,null);
        db.execSQL("DROP TABLE IF EXISTS countryQuiz");

        db.execSQL("CREATE TABLE countryQuiz(" +
                "number INTEGER NOT NULL PRIMARY KEY," +
                "question VARCHAR(100)," +
                "answer VARCHAR(32))");
        db.execSQL("INSERT INTO countryQuiz VALUES(1,'What is the second largest country in the world by area?','canada')");
        db.execSQL("INSERT INTO countryQuiz VALUES(2,'Which country has the official dialect of Mandarin?','china')");
        db.execSQL("INSERT INTO countryQuiz VALUES(3,'After Brazil and Argentina, what is the third largest country in Latin America?','mexico')");
        db.execSQL("INSERT INTO countryQuiz VALUES(4,'Which country is the cradle of Islam and the site of Mecca and Medina?','saudi arabia')");
        db.execSQL("INSERT INTO countryQuiz VALUES(5,'In which country is Washington, D.C. the national capital?','us')");

    }

    public void onSubmitClick(View view){
        q1 = q1TV.getText().toString().toLowerCase();
        q2 = q2TV.getText().toString().toLowerCase();
        q3 = q3TV.getText().toString().toLowerCase();
        q4 = q4TV.getText().toString().toLowerCase();
        q5 = q5TV.getText().toString().toLowerCase();

        if(dbQuery(1,q1))
            correctAnswerCount++;
        if(dbQuery(2,q2))
            correctAnswerCount++;
        if(dbQuery(3,q3))
            correctAnswerCount++;
        if(dbQuery(4,q4))
            correctAnswerCount++;
        if(dbQuery(5,q5))
            correctAnswerCount++;

        Toast.makeText(QuizActivity.this, "You got " + correctAnswerCount + " questions correct.", Toast.LENGTH_SHORT).show();
    }
    public boolean dbQuery(int num, String userAnswer){

        String query = "SELECT answer FROM countryQuiz WHERE num = " + num;
        String queryAnswer="";

        Cursor cr = db.rawQuery(query,null);

        while(cr.moveToNext()){
            for(int i=0; i<cr.getColumnCount(); i++){
                if(cr.getString(i).equals(userAnswer))
                    return true;
            }
        }

        cr.close();
        return false;
    }
}