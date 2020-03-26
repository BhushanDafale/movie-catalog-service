package com.de.moviecatalogservice.resource;

import com.de.moviecatalogservice.resource.model.CatalogItem;
import com.de.moviecatalogservice.resource.model.Movie;
import com.de.moviecatalogservice.resource.model.Rating;
import com.de.moviecatalogservice.resource.model.UserRating;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId) {

        // created UserRating(extra class) to avoid to pass List<Rating> as 2nd parameter to the following call
        UserRating userRating = restTemplate.getForObject("localhost:8083/rating/user/" + userId, UserRating.class);

        return userRating.getRatings().stream().map(rating -> {
            // Using RestTemplate
            Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" + rating.getMovieId(), Movie.class);

            // Using Webclient
           /* Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movie/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();
            */
            return new CatalogItem(movie.getMovieName(), "TestDesc", rating.getRating());
        }).collect(Collectors.toList());
    }

}
