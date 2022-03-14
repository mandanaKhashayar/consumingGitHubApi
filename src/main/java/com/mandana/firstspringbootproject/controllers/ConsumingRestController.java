package com.mandana.firstspringbootproject.controllers;


import com.mandana.firstspringbootproject.models.GitHubRepositoryDetails;
import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.servicesImpl.ConsumingRestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ConsumingRestController {

    private final ConsumingRestServiceImpl consumingRestServiceImpl;
    public static String url="https://api.github.com/repositories";

    @GetMapping("/{ownerId}/repositories")
    public ResponseEntity<List<GitHubRepositoryDetails>> getRepositoryByOwner(@PathVariable("ownerId") long ownerId){
       return ResponseEntity.ok(consumingRestServiceImpl.getRepositoryByOwner(ownerId));
    }
    @GetMapping("/owners")
    public ResponseEntity<List<Owner>> getRepositoryByOwner(){
        return ResponseEntity.ok(consumingRestServiceImpl.getOwners());
    }

    @GetMapping("/repositories")
    public List<Object> getPublicRepositories(){

        return consumingRestServiceImpl.getObjectsByURL(url);
    }
}
