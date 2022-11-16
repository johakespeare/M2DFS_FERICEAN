package com.example.myfinder4.delegates;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class FilmServiceDelegate {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callStudentFilmAndGetData_Fallback")
    public String callActeursServiceAndGetData() {
        System.out.println("Getting Acteurs details");
        String response = restTemplate
                .exchange("http://localhost:9091/getActeurs"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }).getBody();


        return "NORMAL FLOW !!! " + response + " -  " + new Date();

    }


    @HystrixCommand(fallbackMethod = "callStudentFilmAndGetData_Fallback")
    public String callActeursByNomServiceAndGetData(String nom) {
        System.out.println("Getting Acteurs details for " + nom);
        String response = restTemplate
                .exchange("http://localhost:9091/getActeurByNom/{nom}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, nom).getBody();


        return "NORMAL FLOW !!! - Acteur Name -  " + nom + " :::  Acteur Details " + response + " -  " + new Date();

    }


    @HystrixCommand(fallbackMethod = "callStudentFilmAndGetData_Fallback")
    public String callActeursByFilmServiceAndGetData(String film) {
        System.out.println("Getting Acteurs details for " + film);
        String response = restTemplate
                .exchange("http://localhost:9091/getActeurByFilm/{film}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, film).getBody();


        return "NORMAL FLOW !!! - Film titre -  " + film + " :::  Acteur Details " + response + " -  " + new Date();

    }

    @HystrixCommand(fallbackMethod = "callStudentFilmAndGetData_Fallback")
    public String callFilmsServiceAndGetData() {
        System.out.println("Getting Films details");
        String response = restTemplate
                .exchange("http://localhost:9091/getFilms"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }).getBody();


        return "NORMAL FLOW !!! " + response + " -  " + new Date();

    }


    @HystrixCommand(fallbackMethod = "callStudentFilmAndGetData_Fallback")
    public String callFilmsByTitreServiceAndGetData(String titre) {
        System.out.println("Getting Films details for " + titre);
        String response = restTemplate
                .exchange("http://localhost:9091/getFilmByTitre/{titre}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, titre).getBody();


        return "NORMAL FLOW !!! - Film titre -  " + titre + " :::  Film Details " + response + " -  " + new Date();

    }


    @HystrixCommand(fallbackMethod = "callStudentFilmAndGetData_Fallback")
    public String callFilmsBySortieServiceAndGetData(String sortie) {
        System.out.println("Getting Films details for " + sortie);
        String response = restTemplate
                .exchange("http://localhost:9091/getFilmsBySortie/{sortie}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, sortie).getBody();


        return "NORMAL FLOW !!! - Film titre -  " + sortie + " :::  Film Details " + response + " -  " + new Date();

    }


    @SuppressWarnings("unused")
    private String callFilmServiceAndGetData_Fallback() {
        System.out.println("Film Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!!No Response From Film Service at this moment. Service will be back shortly - " + new Date();
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}