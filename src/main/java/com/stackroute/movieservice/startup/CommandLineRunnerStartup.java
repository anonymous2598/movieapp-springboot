package com.stackroute.movieservice.startup;

import com.stackroute.movieservice.domain.MovieInfo;
import com.stackroute.movieservice.exceptions.MovieAlreadyExists;
import com.stackroute.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerStartup implements CommandLineRunner {
    MovieService movieService;

    @Autowired
    public CommandLineRunnerStartup(MovieService movieService)
    {
        this.movieService=movieService;
    }
    @Override
    public void run(String... args) throws Exception {
        MovieInfo movieInfo1= new MovieInfo();
        movieInfo1.setMovieId(2);
        movieInfo1.setMovieLanguage("hindi");
        movieInfo1.setMovieName("test2");
        movieInfo1.setMovieOverview("okay");
        try {
            movieService.saveMovieInfo(movieInfo1);

        } catch (MovieAlreadyExists movieAlreadyExists) {
            movieAlreadyExists.printStackTrace();
        }
    }
}
