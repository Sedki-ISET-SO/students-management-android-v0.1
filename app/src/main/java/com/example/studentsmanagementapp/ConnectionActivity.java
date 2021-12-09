package com.example.studentsmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectionActivity extends AppCompatActivity {
    Button BtnConn;
    Button BtnAnnu;
    EtudiantDBHandler db = new EtudiantDBHandler (this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        BtnConn = (Button) findViewById(R.id.BtnConn);
        BtnAnnu = (Button) findViewById(R.id.BtnAnnuC);

        BtnConn.setOnClickListener(new
                                           OnClickListener() {

                                               @Override
                                               public void onClick(View arg0) {
                                                   EditText texte =((EditText)findViewById(R.id.login));
                                                   String login = texte.getText().toString();
                                                   EditText texte1 =((EditText)findViewById(R.id.pwd));
                                                   String password = texte1.getText().toString();
                                                   if(db.verifyInscription(login, password)) {
                                                       // TODO Auto-generated method stub
                                                       setResult(RESULT_OK);

                                                       finish();
                                                   }
                                                   else {
                                                       showToast("login failed! please check your credentials");
                                                   }
                                               }
                                           });
        BtnAnnu.setOnClickListener(new
                                           OnClickListener() {

                                               @Override
                                               public void onClick(View arg0) {
                                                   // TODO Auto-generated method stub
                                                   setResult(RESULT_CANCELED);
                                                   finish();
                                               }
                                           });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.connection, menu);
        return true;
    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
