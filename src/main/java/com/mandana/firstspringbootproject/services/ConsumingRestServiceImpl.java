package com.mandana.firstspringbootproject.services;

import com.mandana.firstspringbootproject.models.RepositoryDetails;
import com.mandana.firstspringbootproject.repositories.RepositoryDetailsRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ConsumingRestServiceImpl {

    private final RepositoryDetailsRepository repositoryDetailsRepository;
    private final RestTemplate restTemplate;

    public ConsumingRestServiceImpl(RestTemplateBuilder restTemplateBuilder, RepositoryDetailsRepository repositoryDetailsRepository) {
        this.restTemplate = restTemplateBuilder.build();
        this.repositoryDetailsRepository = repositoryDetailsRepository;
    }

    public List<Object> getObjectsByURL(String url) {
        ResponseEntity<Object[]> responseEntity =
                restTemplate.getForEntity(url, Object[].class);
        Object[] objectsOfUrl = responseEntity.getBody();
        return Arrays.asList(objectsOfUrl);
    }

    public List<RepositoryDetails> getRepository() {
        return repositoryDetailsRepository.findAll();
    }

    public List<RepositoryDetails> addRepository(RepositoryDetails repositoryDetails) {
        repositoryDetailsRepository.save(repositoryDetails);
        return getRepository();
    }
}
