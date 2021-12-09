package com.example.studentsmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriptionActivity extends AppCompatActivity {
    Button BtnInsc;
    Button BtnAnnu;
    EtudiantDBHandler db = new EtudiantDBHandler (this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        BtnInsc=(Button)findViewById(R.id.BtnInsc);
        BtnAnnu=(Button)findViewById(R.id.BtnAnnu);



        BtnInsc.setOnClickListener(new
                                           OnClickListener(){

                                               @Override
                                               public void onClick(View arg0) {
                                                   // TODO Auto-generated method stub


                                                   EditText texte =((EditText)findViewById(R.id.nom));
                                                   String nom = texte.getText().toString();
                                                   EditText texte1 =((EditText)findViewById(R.id.prenom));
                                                   String prenom = texte1.getText().toString();
                                                   EditText texte4 =((EditText)findViewById(R.id.classe));
                                                   String classe = texte4.getText().toString();
                                                   EditText texte5 =((EditText)findViewById(R.id.groupe));
                                                   String groupe = texte5.getText().toString();
                                                   EditText texte2 =((EditText)findViewById(R.id.login));
                                                   String login = texte2.getText().toString();
                                                   EditText texte3 =((EditText)findViewById(R.id.pwd));
                                                   String pwd = texte3.getText().toString();
                                                   Etudiant etu = new Etudiant(nom, prenom, classe, groupe, login, pwd);
                                                   if((!db.verifyIfUserExists(login))) {
                                                       db.insertEtudiant(etu);
                                                       setResult(RESULT_OK);
                                                       finish();
                                                  }
                                                   else {
                                                      showToast("inscription failed! user already exists");
                                                   }
                                               }  } );

        BtnAnnu.setOnClickListener(new
                                           OnClickListener(){

                                               @Override
                                               public void onClick(View arg0) {
                                                   // TODO Auto-generated method stub
                                                   setResult(RESULT_CANCELED);
                                                   finish();
                                               }  } );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inscription, menu);
        return true;
    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
