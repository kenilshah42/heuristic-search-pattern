package com.example.test.klevu.controllers;

import com.example.test.klevu.Application;
import com.example.test.klevu.services.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class SearchController {

    @Autowired
    Search searchService;

    @PostMapping(value = "/search", consumes = "application/json")
    public Set<String> findFullSearchTerms(@RequestBody List<String> partialSearchTerms){
        return searchService.findTerms(partialSearchTerms);
    }

}
