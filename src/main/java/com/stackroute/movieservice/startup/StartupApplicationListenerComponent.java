package com.stackroute.movieservice.startup;

import com.stackroute.movieservice.domain.MovieInfo;
import com.stackroute.movieservice.exceptions.MovieAlreadyExists;
import com.stackroute.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupApplicationListenerComponent implements ApplicationListener<ContextRefreshedEvent> {

    MovieService movieService;

    @Autowired
    public StartupApplicationListenerComponent(MovieService movieService)
    {
        this.movieService=movieService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        MovieInfo movieInfo= new MovieInfo();
        movieInfo.setMovieId(1);
        movieInfo.setMovieLanguage("telugu");
        movieInfo.setMovieName("test");
        movieInfo.setMovieOverview("good");


        try {
//            System.out.println(movieInfo);
            movieService.saveMovieInfo(movieInfo);

        } catch (MovieAlreadyExists movieAlreadyExists) {
            movieAlreadyExists.printStackTrace();
        }
    }
}
