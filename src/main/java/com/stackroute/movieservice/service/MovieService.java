package com.stackroute.movieservice.service;


import com.stackroute.movieservice.domain.MovieInfo;

import java.util.List;

public interface MovieService {
     List<MovieInfo> getMovies();
     MovieInfo saveMovieInfo(MovieInfo movieInfo) ;
     boolean deleteMovieInfo(Long repoId);
//     Optional<MovieInfo> getRepoInfoById (Long repoId);
     MovieInfo updateMovieInfo(MovieInfo movieInfo);

}
