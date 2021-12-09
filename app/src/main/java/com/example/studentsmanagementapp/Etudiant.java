package com.example.studentsmanagementapp;

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private String groupe;
    private String classe;
    private String login;
    private String pwd;

    public Etudiant(String nom, String prenom, String groupe, String classe, String login, String pwd) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
        this.classe = classe;
        this.login = login;
        this.pwd = pwd;
    }


    public Etudiant() {
        // TODO Auto-generated constructor stub
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}

