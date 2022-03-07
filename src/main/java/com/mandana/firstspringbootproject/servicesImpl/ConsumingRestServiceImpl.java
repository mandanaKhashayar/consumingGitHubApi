package com.mandana.firstspringbootproject.servicesImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.models.RepositoryDetails;
import com.mandana.firstspringbootproject.repositories.RepositoryDetailsRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsumingRestServiceImpl {

    private final RepositoryDetailsServiceImpl repositoryDetailsService;
    private final OwnerServiceImpl ownerService;
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    public ConsumingRestServiceImpl(RestTemplateBuilder restTemplateBuilder,
                                    RepositoryDetailsServiceImpl repositoryDetailsService,
                                    OwnerServiceImpl ownerService) {
        this.restTemplate = restTemplateBuilder.build();
        this.repositoryDetailsService = repositoryDetailsService;
        this.ownerService=ownerService;
        this.mapper = new ObjectMapper();
    }

    public List<Object> getObjectsByURL(String url) {
        ResponseEntity<Object[]> responseEntity =
                restTemplate.getForEntity(url, Object[].class);
        Object[] objectsOfUrl = responseEntity.getBody();
        List<Object> listOfObjects = Arrays.asList(objectsOfUrl);
        addRepositories(objectsOfUrl);
        return listOfObjects;
    }

    public List<RepositoryDetails> getRepository() {
       //TO-DO
        return repositoryDetailsService.findAll();
       //return new ArrayList<RepositoryDetails>();
    }

    public List<RepositoryDetails> addRepositories(Object[] repositories) {

        List<RepositoryDetails> repositoryDetailsList = Arrays.stream(repositories)
                .map(object -> mapper.convertValue(object, RepositoryDetails.class))
                .collect(Collectors.toList());
        for (RepositoryDetails repositoryDetails : repositoryDetailsList)
            addRepository(repositoryDetails);
        return repositoryDetailsList;
    }

    public List<RepositoryDetails> addRepository(RepositoryDetails repositoryDetails) {
        Owner owner=repositoryDetails.getOwner();
        owner.getRepositoryDetailsList().add(repositoryDetails);

        repositoryDetailsService.save(repositoryDetails);
        ownerService.save(owner);
        return getRepository();
    }
}
