package com.example.mymovie2.controllers;


import com.example.mymovie2.models.Acteur;
import com.example.mymovie2.models.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "FilmController", description = "REST Apis related to Film and Acteur")
@RestController
public class FilmController {

    Acteur acteur_1 = new Acteur("Depp","Johnny","17/06/1964");
    Acteur acteur_2 = new Acteur("Pratt","Chris","30/09/1980");
    Acteur acteur_3 = new Acteur("Craig","David","23/01/1956");

    Film film_1 = new Film("Film_1", "Spielberg", acteur_1,"20/06/1989");
    Film film_2 = new Film("Film_2", "Tarantino", acteur_2,"20/1979");
    Film film_3 = new Film("Film_1", "Nolan", acteur_3,"28/05/2012");

    {
        acteur_1.addFilm(film_1);
        acteur_2.addFilm(film_1);
        acteur_2.addFilm(film_2);
        acteur_3.addFilm(film_3);
        film_1.addActeur(acteur_1);
        film_1.addActeur(acteur_2);
        film_2.addActeur(acteur_2);
        film_3.addActeur(acteur_3);
    }

    List<Film> films = new ArrayList<Film>();
    {
        films.add(film_1);
        films.add(film_2);
        films.add(film_3);
    }
    List<Acteur> acteurs = new ArrayList<Acteur>();
    {
        acteurs.add(acteur_1);
        acteurs.add(acteur_2);
        acteurs.add(acteur_3);

    }





    @ApiOperation(value = "Get list of Acteurs in the System ", response = Iterable.class, tags = "getActeurs")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })


    @RequestMapping(value = "/getActeurs")
    public List<Acteur> getActeurs(){
        return acteurs;
    }

    @ApiOperation(value = "Get specific Acteurs in the System ", response = Acteur.class, tags = "getActeurByNom")
    @RequestMapping(value = "/getActeurByNom/{nom}")
    public Acteur getActeurByNom(@PathVariable(value = "nom") String nom){
        return acteurs.stream().filter(x -> x.getNom().equalsIgnoreCase(nom)).collect(Collectors.toList()).get(0);
    }

    @ApiOperation(value = "Get specific Acteurs in the System ", response = Acteur.class, tags = "getActeursByFilm")
    @RequestMapping(value = "/getActeursByFilm/{film}")
    public List<Acteur> getActeursByFilm(@PathVariable(value = "film") Film film){
        return film.getActeurs();
    }

    @ApiOperation(value = "Get list of Films in the System ", response = Iterable.class, tags = "getFilms")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @RequestMapping(value = "/getFilms")
    public List<Film> getFilms(){
        return films;
    }

    @ApiOperation(value = "Get specific Films in the System ", response = Acteur.class, tags = "getFilmByTitre")
    @RequestMapping(value = "/getFilmByTitre/{titre}")
    public Film getFilmByTitre(@PathVariable(value = "titre") String titre){
        return films.stream().filter(x -> x.getTitre().equalsIgnoreCase(titre)).collect(Collectors.toList()).get(0);

    }

    @ApiOperation(value = "Get specific Films in the System ", response = Acteur.class, tags = "getFilmsBySortie")
    @RequestMapping(value = "/getFilmsbySortie/{sortie}")
    public List<Film> getFilmBySortie(@PathVariable(value = "sortie") String sortie)
    {

        return films.stream().filter(x -> x.getDate_sortie().equalsIgnoreCase(sortie)).collect(Collectors.toList());

    }










}

