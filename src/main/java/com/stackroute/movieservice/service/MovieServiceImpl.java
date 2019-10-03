package com.stackroute.movieservice.service;


import com.stackroute.movieservice.domain.MovieInfo;
import com.stackroute.movieservice.exceptions.MovieAlreadyExists;
import com.stackroute.movieservice.exceptions.MovieDoesNotExist;
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
    public MovieInfo saveMovieInfo(MovieInfo movieInfo) throws MovieAlreadyExists {
        if(movieRepository.existsById(movieInfo.getMovieId()))
        {
            throw new MovieAlreadyExists("Movie already exists!");
        }

        MovieInfo movieInfo1 = movieRepository.save(movieInfo);
        if(movieInfo1==null)
        {
            throw new MovieAlreadyExists("Movie already exists!");
        }
        return movieInfo1;
    }

    @Override
    public boolean deleteMovieInfo(Long repoId) throws MovieDoesNotExist {
        if(movieRepository.existsById(repoId))
        {
            movieRepository.deleteById(repoId);
            return true;
        }
        else
        {
            throw new MovieDoesNotExist("Movie Does Not Exist!");
        }

    }

    @Override
    public MovieInfo updateMovieInfo(MovieInfo movieInfo) throws MovieDoesNotExist {
        if(movieRepository.existsById(movieInfo.getMovieId()))
        {
            return movieRepository.save(movieInfo);
        }
        else
        {
            throw  new MovieDoesNotExist("Movie Does Not Exist!");
        }
    }

    @Override
    public List<MovieInfo> getMovieInfoByName(String movieName) throws MovieDoesNotExist {
        List<MovieInfo> list = new ArrayList<>();

        list= movieRepository.getMovieInfoByName(movieName);
        if(list==null)
        {
            throw new MovieDoesNotExist("No Movies Found By Given Name");
        }
        return list;
    }

}
