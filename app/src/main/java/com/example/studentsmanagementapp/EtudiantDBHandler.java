package com.example.studentsmanagementapp;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class EtudiantDBHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DbEtudiant";
    private static final String TABLE_Etudiant = "tableEtudiant";
    private static final String COLONNE_ID = "id";
    private static final String COLONNE_NOM = "nom";
    private static final String COLONNE_PRENOM = "prenom";
    private static final String COLONNE_LOGIN = "login";
    private static final String COLONNE_PWD = "pwd";
    private static final String REQUETE_CREATION_BD = "create table "+ TABLE_Etudiant + " (" + COLONNE_ID+ " integer primary key autoincrement, "  +
            COLONNE_NOM +  " TEXT not null, "  +
            COLONNE_PRENOM + " TEXT not null, " + COLONNE_LOGIN + " TEXT not null, " + COLONNE_PWD + " TEXT not null); ";
    private static final int COLONNE_ID_ID = 0;
    private static final int COLONNE_NOM_ID = 1;
    private static final int COLONNE_PRENOM_ID = 2;
    private static final int COLONNE_LOGIN_ID = 3;
    private static final int COLONNE_PWD_ID = 4;



    public EtudiantDBHandler(Context context, String name,
                             CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }
    public EtudiantDBHandler(Context context)
    { super(context, DATABASE_NAME ,null, DATABASE_VERSION );   }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(REQUETE_CREATION_BD);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL(TABLE_Etudiant);
        onCreate(db);
    }
    public boolean insertEtudiant(Etudiant etu) {
        SQLiteDatabase maBD = this.getWritableDatabase();

        ContentValues valeurs = new ContentValues();

        valeurs.put(COLONNE_NOM, etu.getNom());

        valeurs.put(COLONNE_PRENOM, etu.getPrenom());
        valeurs.put(COLONNE_LOGIN, etu.getLogin());
        valeurs.put(COLONNE_PWD, etu.getPwd());
        maBD.insert(TABLE_Etudiant, null, valeurs);

        maBD.close();
        return true;
    }

    public ArrayList<Etudiant> getAllEtudiants() {

        SQLiteDatabase  maBD = this.getReadableDatabase();

        Cursor c = maBD.query(TABLE_Etudiant,
                new String[] { COLONNE_ID, COLONNE_NOM, COLONNE_PRENOM,COLONNE_LOGIN, COLONNE_PWD},  null, null, null,null, null);
        return cursorToEtudiants(c);

    }

    public int deleteStudent(int studentId) {
        String id = Integer.toString(studentId);

        SQLiteDatabase maBD = this.getReadableDatabase();
        // Define 'where' part of query.
        String selection = COLONNE_ID + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { id };
        // Issue SQL statement.
        int deletedRows = maBD.delete(TABLE_Etudiant, selection, selectionArgs);

        return deletedRows;
    }

    public boolean verifyInscription(String login, String password) {

        SQLiteDatabase maBD = this.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                COLONNE_NOM,
                COLONNE_LOGIN,
                COLONNE_PWD
        };

// Filter results WHERE "title" = 'My Title'
        String selection = COLONNE_LOGIN + " = ?" + "AND " + COLONNE_PWD + " = ?";
        String[] selectionArgs = { login, password };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                COLONNE_LOGIN + " DESC";

        Cursor c = maBD.query(
                TABLE_Etudiant,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        if (c != null && c.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<Etudiant> cursorToEtudiants(Cursor c) {
        if (c==null  || c.getCount() == 0)
            return new ArrayList<Etudiant>(0);

        ArrayList<Etudiant> retEtud = new ArrayList<Etudiant>(c.getCount());
        c.moveToFirst();
        do { Etudiant etudiant = new Etudiant();
            etudiant.setId(c.getInt(COLONNE_ID_ID));
            etudiant.setNom(c.getString(COLONNE_NOM_ID ));
            etudiant.setPrenom(c.getString(COLONNE_PRENOM_ID ));
            etudiant.setLogin(c.getString(COLONNE_LOGIN_ID ));
            etudiant.setPwd(c.getString(COLONNE_PWD_ID ));
            retEtud.add(etudiant);
        } while (c.moveToNext()); //
        c.close();
        return retEtud;
    }


}

