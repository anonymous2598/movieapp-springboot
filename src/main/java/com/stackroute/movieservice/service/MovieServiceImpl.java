package com.stackroute.movieservice.service;


import com.stackroute.movieservice.domain.MovieInfo;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieInfo> getMovies() {

        return movieRepository.findAll();

    }

    @Override
    public MovieInfo saveMovieInfo(MovieInfo movieInfo){
        MovieInfo movieInfo1 = movieRepository.save(movieInfo);
        return movieInfo1;
    }

    @Override
    public boolean deleteMovieInfo(Long repoId)
    {
        if(movieRepository.existsById(repoId))
        {
            movieRepository.deleteById(repoId);
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public MovieInfo updateMovieInfo(MovieInfo movieInfo)  {
        if(movieRepository.existsById(movieInfo.getMovieId()))
        {
            return movieRepository.save(movieInfo);
        }
        return null;
    }

    @Override
    public List<MovieInfo> getMovieInfoByName(String movieName)
    {
        List<MovieInfo> list = new ArrayList<>();

        list= movieRepository.getMovieInfoByName(movieName);
        return list;
    }

}
