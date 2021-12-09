package com.example.studentsmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.net.Uri;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ContacterActivity extends AppCompatActivity {
    Button BtnWeb;
    Button BtnAppel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacter);
        BtnWeb=(Button)findViewById(R.id.web);
        BtnAppel=(Button)findViewById(R.id.appel);

        BtnWeb.setOnClickListener(new
                                          OnClickListener(){

                                              @Override
                                              public void onClick(View arg0) {
                                                  // TODO Auto-generated method stub
                                                  Uri uri = Uri.parse("http://www.yahoo.fr/");
                                                  Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                                  startActivity(intent);
                                              }  } );
        BtnAppel.setOnClickListener(new
                                            OnClickListener(){

                                                @Override
                                                public void onClick(View arg0) {
                                                    // TODO Auto-generated method stub
                                                    Uri uri = Uri.parse("tel:27496907");
                                                    Intent intent = new Intent(Intent.ACTION_CALL, uri);
                                                    startActivity(intent);
                                                }  } );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contacter, menu);
        return true;
    }

}
