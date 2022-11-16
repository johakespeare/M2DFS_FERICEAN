package com.example.myfinder4.controllers;

import com.example.myfinder4.delegates.FilmServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmServiceController {

    @Autowired
    FilmServiceDelegate filmServiceDelegate;

    @RequestMapping(value = "/getActeursDetails")
    public String getActeurs() {
        System.out.println("Going to call acteurs service to get data!");
        return filmServiceDelegate.callActeursServiceAndGetData();
    }

    @RequestMapping(value = "/getActeursDetailsByNom/{nom}", method = RequestMethod.GET)
    public String getActeursByNom(@PathVariable String nom) {
        System.out.println("Going to call acteurs service to get data!");
        return filmServiceDelegate.callActeursByNomServiceAndGetData(nom);
    }

    @RequestMapping(value = "/getActeursDetailsByFilm/{film}", method = RequestMethod.GET)
    public String getActeursByFilm(@PathVariable String film) {
        System.out.println("Going to call acteurs service to get data!");
        return filmServiceDelegate.callActeursByFilmServiceAndGetData(film);
    }

    @RequestMapping(value = "/getFilmsDetails")
    public String getFilms() {
        System.out.println("Going to call films service to get data!");
        return filmServiceDelegate.callFilmsServiceAndGetData();
    }


    @RequestMapping(value = "/getFilmDetailsByTitre/{titre}", method = RequestMethod.GET)
    public String getFilmsByTitre(@PathVariable String titre) {
        System.out.println("Going to call films service to get data!");
        return filmServiceDelegate.callFilmsByTitreServiceAndGetData(titre);
    }

    @RequestMapping(value = "/getFilmsDetailsBySortie/{sortie}", method = RequestMethod.GET)
    public String getFilmsBySortie(@PathVariable String sortie) {
        System.out.println("Going to call films service to get data!");
        return filmServiceDelegate.callFilmsBySortieServiceAndGetData(sortie);
    }


}
