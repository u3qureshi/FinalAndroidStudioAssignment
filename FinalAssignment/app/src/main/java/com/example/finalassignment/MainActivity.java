package com.example.finalassignment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.text.method.ScrollingMovementMethod;
import android.view.MenuInflater;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private ImageView canada;
    private ImageView china;
    private ImageView mexico;
    private ImageView saudi;
    private ImageView us;
    private TextView textView;
    private String[] descriptionsArray = {"Some facts about Canada:\n-It is the second largest country in the world in area (after Russia)\n-Despite Canada’s great size, it is one of the world’s most sparsely populated countries\n-Canada is officially bilingual in English and French\n-The word Canada is derived from the Huron-Iroquois 'kanata', meaning a village or settlement\n-Canada's capital is Ottawa, and its three largest metropolitan areas are Toronto, Montreal, and Vancouver",
            "Some facts about China:\n-It is the world's most populous country, with a population of around 1.4 billion\n-China is very large in land mass and is surpassed in area by only Russia and Canada\n-The national capital is Beijing\n-China emerged as one of the world's first civilizations in the fertile basin of the Yellow River in the North China Plain\n-The official dialect of China is Mandarin, also call “Putonghua”. More than 70% of the Chinese population speaks Mandarin",
            "Some facts about Mexico:\n-It is a country of southern North America and the third largest country in Latin America, after Brazil and Argentina\n-Mexican society is characterized by extremes of wealth and poverty\n-It is the 13th largest country by area\n-With approximately 126,014,024 inhabitants, it is the 10th-most-populous country and has the most Spanish-speakers\n-Pre-Columbian Mexico traces its origins to 8,000 BC and is identified as one of the six cradles of civilization",
            "Some facts about Saudi Arabia:\n-Extending across most of the northern and central Arabian Peninsula, Saudi Arabia is a young country that is heir to a rich history\n-It has a land area of about 2,150,000 sq km, making it the fifth-largest country in Asia\n-In its western highlands, along the Red Sea, lies the Hejaz, which is the cradle of Islam and the site of that religion’s holiest cities, Mecca and Medina\n-Along the Persian Gulf, are the country’s abundant oil fields that have made Saudi Arabia synonymous with petroleum wealth",
            "Some facts about USA:\n-Officially called the United States of America\n-It consists of 50 states, a federal district, five major unincorporated territories and 326 Indian reservations\n-At nearly 9.8 million square kilometers, it is the world's fourth-largest country by geographic area\n-The national capital is Washington, D.C., and the most populous city and financial center is New York City\n-Although it is very diverse, English is by far the most prominent spoken language"};
    private Button quizButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        canada = findViewById(R.id.canadaIV);
        china = findViewById(R.id.chinaIV);
        mexico = findViewById(R.id.mexicoIV);
        saudi = findViewById(R.id.saudiIV);
        us = findViewById(R.id.usIV);
        textView = findViewById(R.id.descriptionsTV);
        quizButton = findViewById(R.id.quizButton);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.search:
                Toast.makeText(this, "You clicked Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "You clicked Help", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.more_help:
                Toast.makeText(this, "You clicked More Help", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    public void onImageClick(View view){
        switch(view.getId()){
            case R.id.canadaIV:
                showDescriptionsText(0);
                break;
            case R.id.chinaIV:
                showDescriptionsText(1);
                break;
            case R.id.mexicoIV:
                showDescriptionsText(2);
                break;
            case R.id.saudiIV:
                showDescriptionsText(3);
                break;
            case R.id.usIV:
                showDescriptionsText(4);
                break;
            default:
                showDescriptionsText(0);
                break;
        }
    }

    public void onQuizButtonClick(View view){

        //Instantiate an AlertDialog.Builder with its constructor.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // call set methods to set the dialog characteristics.
        builder.setTitle("Quiz Alert");
        builder.setMessage("Are you sure you are ready to take the quiz?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("No", null);
        // Create and show the AlertDialog.
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showDescriptionsText(int i){
        textView.setText(descriptionsArray[i]);
    }
}