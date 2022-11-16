package com.example.mymovie2.models;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;

public class Film {
    @ApiModelProperty(notes = "Titre du film",name="titre",required=true,value="test titre")
    private String titre;
    @ApiModelProperty(notes = "Realisateur du film",name="realisateur",required=true,value="test realisateur")
    private String realisateur;
    @ApiModelProperty(notes = "Acteur principal du film",name="acteur_principal",required=true,value="test acteur principal")
    private Acteur acteur_principal;
    @ApiModelProperty(notes = "Date de sortie du film",name="date_sortie",required=true,value="test date de sortie")
    private String date_sortie;
    @ApiModelProperty(notes = "Acteurs du film",name="acteurs",required=true,value="test acteur")
    private ArrayList<Acteur> acteurs;
    public Film(String titre, String realisateur, Acteur acteur_principal, String date_sortie) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.acteur_principal = acteur_principal;
        this.date_sortie = date_sortie;
        this.acteurs = new ArrayList<>();
    }

    public void addActeur(Acteur acteur){
        this.acteurs.add(acteur);
    }
    public String getTitre() {
        return titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public Acteur getActeur_principal() {
        return acteur_principal;
    }

    public ArrayList<Acteur> getActeurs() {
        return acteurs;
    }

    public String getDate_sortie() {
        return date_sortie;
    }


    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", acteur_principal=" + acteur_principal +
                ", date_sortie='" + date_sortie + '\'' +
                '}';
    }
}
