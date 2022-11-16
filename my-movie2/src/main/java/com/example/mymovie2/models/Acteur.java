package com.example.mymovie2.models;


import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

public class Acteur {
    @ApiModelProperty(notes = "Nom de l'acteur",name="nom",required=true,value="test nom")
    private String nom;
    @ApiModelProperty(notes = "Prénom de l'acteur",name="prenom",required=true,value="test prénom")
    private String prenom;
    @ApiModelProperty(notes = "Date de  naissance de l'acteur",name="date_naissance",required=true,value="test date de naissance")
    private String date_naissance;
    @ApiModelProperty(notes = "Filmographie de l'acteur",name="filmographie",required=true,value="test filmographie")
    private ArrayList<Film> filmographie;

    public Acteur(String nom, String prenom, String date_naissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_naissance = date_naissance;
        this.filmographie = new ArrayList<>();
    }

    public void addFilm(Film film){
        this.filmographie.add(film);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public ArrayList<Film> getFilmographie() {
        return filmographie;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance='" + date_naissance + '\'' +
                ", filmographie=" + filmographie +
                '}';
    }
}
