package com.stackroute.movieservice.repository;

import com.stackroute.movieservice.domain.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieInfo,Long> {
    @Query(value = "SELECT * FROM MOVIE_INFO WHERE MOVIE_NAME=:NAME",nativeQuery = true)
    List<MovieInfo> getMovieInfoByName(@Param("NAME") String s);
}
