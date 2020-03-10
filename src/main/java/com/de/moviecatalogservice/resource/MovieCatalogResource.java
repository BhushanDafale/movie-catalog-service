package com.de.moviecatalogservice.resource;

import com.de.moviecatalogservice.resource.model.CatalogItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalogs(@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new CatalogItem("Iron Man", "Best Movie", 5)
        );
    }

}
