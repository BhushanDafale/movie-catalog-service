package com.de.moviecatalogservice.resource;

import com.de.moviecatalogservice.resource.model.CatalogItem;
import com.de.moviecatalogservice.resource.model.Movie;
import com.de.moviecatalogservice.resource.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId) {
        List<Rating> ratings = Arrays.asList(
                new Rating(1234, 4),
                new Rating(9876, 3)
        );

        return ratings.stream().map(rating -> {
           Movie movie = restTemplate.getForObject("https://localhost:8082/movie/" + rating.getMovieId(), Movie.class);
           return new CatalogItem(movie.getMovieName(), "TestDesc", rating.getRating());
        }).collect(Collectors.toList());
    }

}
