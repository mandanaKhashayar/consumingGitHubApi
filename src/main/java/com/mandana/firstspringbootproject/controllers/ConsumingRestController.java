package com.mandana.firstspringbootproject.controllers;


import com.mandana.firstspringbootproject.models.RepositoryDetails;
import com.mandana.firstspringbootproject.servicesImpl.ConsumingRestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConsumingRestController {

    private final ConsumingRestServiceImpl consumingRestServiceImpl;
    private static String url="https://api.github.com/repositories";

    @GetMapping("/repository")
    public ResponseEntity<List<RepositoryDetails>> getRepository(){
        return ResponseEntity.ok(consumingRestServiceImpl.getRepository());
    }


    @GetMapping("/repositories")
    public List<Object> getPublicRepositories(){
         return consumingRestServiceImpl.getObjectsByURL(url);
    }
}
