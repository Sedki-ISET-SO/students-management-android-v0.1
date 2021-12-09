package com.example.studentsmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Button monbtn1 ,monbtn2;
    EtudiantDBHandler db = new EtudiantDBHandler (this);
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case (1):
                switch (resultCode){
                    case RESULT_OK:
                        Toast.makeText(this,"inscription avec succ�s",
                                Toast.LENGTH_SHORT).show();
                        return;
                    case RESULT_CANCELED:
                        Toast.makeText(this," inscription Annuler",
                                Toast.LENGTH_SHORT).show();
                        return;

                }
            case (2):
                switch (resultCode){
                    case RESULT_OK:

                        Toast.makeText(this,"connection avec succ�s",
                                Toast.LENGTH_SHORT).show();
                        return;
                    case RESULT_CANCELED:
                        Toast.makeText(this," Annuler",
                                Toast.LENGTH_SHORT).show();
                        return;
                }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //db





        //btn1
        ((Button)findViewById(R.id.btn1)).setOnClickListener(
                new OnClickListener(){

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        Intent intent= new Intent(MainActivity.this,InscriptionActivity.class);
                        startActivityForResult(intent,1);
                    }
                });

        //btn2

        ((Button)findViewById(R.id.btn2)).setOnClickListener(
                new OnClickListener(){

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        Intent intent= new Intent(MainActivity.this,ConnectionActivity.class);
                        startActivityForResult(intent,2);
                    }
                });

        //btn3
        ((Button)findViewById(R.id.btn3)).setOnClickListener(
                new OnClickListener(){

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        Intent intent= new Intent(MainActivity.this,ContacterActivity.class);
                        startActivity(intent);
                    }
                });

        ((Button)findViewById(R.id.btn4)).setOnClickListener(
                new OnClickListener(){

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        List<Etudiant> etud = db.getAllEtudiants();
                        String mess= "";

                        for (Etudiant pl :etud){

                            mess += "Id:"+ pl.getId() + " ,Nom: " + pl.getNom() +" ,prenon: " + pl.getPrenom()+" ,login: " + pl.getLogin()
                                    +" ,pwd: " + pl.getPwd(); }
                        Toast.makeText(MainActivity.this, mess, Toast.LENGTH_SHORT).show();
                    }
                });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
