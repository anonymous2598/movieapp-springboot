package com.stackroute.movieservice.controller;


import com.stackroute.movieservice.domain.MovieInfo;
import com.stackroute.movieservice.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class MovieController {
    MovieService movieService;


    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovieInfo(@RequestBody MovieInfo movieInfo){

        ResponseEntity responseEntity;

            movieService.saveMovieInfo(movieInfo);
            responseEntity= new ResponseEntity<String>("Successfully created!", HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("movie")
    public ResponseEntity<?> getMovies()
    {
        return new ResponseEntity<List<MovieInfo>>(movieService.getMovies(), HttpStatus.OK);
    }

    @DeleteMapping("movie")
    public ResponseEntity<?> deleteMovieInfo(@RequestBody Long repoId)
    {
//        System.out.println("here");
        ResponseEntity responseEntity;
            movieService.deleteMovieInfo(repoId);
            responseEntity= new ResponseEntity<String>("Deleted Successfully", HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @PutMapping("movie")
    public ResponseEntity<?> updateMovie(@RequestBody MovieInfo movieInfo)
    {
//        System.out.println("here");
        ResponseEntity responseEntity;

            movieService.updateMovieInfo(movieInfo);
            responseEntity= new ResponseEntity<String>("Updated Successfully", HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("a")
    public ResponseEntity<?> getMovieByName(@RequestBody String movieName)
    {
        ResponseEntity responseEntity;
        List<MovieInfo> list = new ArrayList<>();
        list = movieService.getMovieInfoByName(movieName);
        responseEntity= new ResponseEntity<List<MovieInfo>>(list,HttpStatus.ACCEPTED);

        return responseEntity;
    }


}
