package com.mandana.firstspringbootproject.service;

import com.mandana.firstspringbootproject.models.GitHubRepositoryDetails;
import com.mandana.firstspringbootproject.models.Owner;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsumingRestServiceTest {

//    public List<Object> getObjectsByURL(String url) {
//        List<Object> Objects = fetch();
//        if (Objects.size() != 0)
//            return Objects;
//        ResponseEntity<Object[]> responseEntity =
//                restTemplate.getForEntity(url, Object[].class);
//        Object[] objectsOfUrl = responseEntity.getBody();
//        List<Object> listOfObjects = Arrays.asList(objectsOfUrl);
//        addRepositories(objectsOfUrl);
//        return listOfObjects;
//    }
//
//    private List<Object> fetch() {
//        return repositoryDetailsService.findAll().stream().map(object -> (Object) object).collect(Collectors.toList());
//
//    }
//
//    public List<GitHubRepositoryDetails> getRepositoryByOwner(long ownerId) {
//        //TO-DO
//        //return repositoryDetailsService.findRepositoryByOwner(Long.getLong(ownerName));
//        return ownerService.findByOwnerId(ownerId).getGitHubrepositoryDetailsList();
//        //return new ArrayList<RepositoryDetails>();
//    }
//
//    public List<GitHubRepositoryDetails> addRepositories(Object[] repositories) {
//
//        List<GitHubRepositoryDetails> repositoryDetailsList = Arrays.stream(repositories)
//                .map(object -> mapper.convertValue(object, GitHubRepositoryDetails.class))
//                .collect(Collectors.toList());
//        for (GitHubRepositoryDetails repositoryDetails : repositoryDetailsList)
//            addRepository(repositoryDetails);
//        return repositoryDetailsList;
//    }
//
//
//    public List<GitHubRepositoryDetails> addRepository(GitHubRepositoryDetails repositoryDetails) {
//        Owner owner = repositoryDetails.getOwner();
//        if (ownerService.findByOwnerId(owner.getOwnerId())!=null)
//            owner=ownerService.findByOwnerId(owner.getOwnerId());
//        owner.getGitHubrepositoryDetailsList().add(repositoryDetails);
//        entityManager.persist(repositoryDetails);
//        ownerService.save(owner);
//        repositoryDetailsService.save(repositoryDetails);
//        return getRepository();
//    }
//
//    public List<GitHubRepositoryDetails> getRepository() {
//        //TO-DO
//        return repositoryDetailsService.findAll();
//        //return new ArrayList<RepositoryDetails>();
//    }
//
//    public List<Owner> getOwners() {
//        return ownerService.getOwners();
//    }
}
