package com.mandana.firstspringbootproject.servicesImpl;

import com.mandana.firstspringbootproject.models.GitHubRepositoryDetails;
import com.mandana.firstspringbootproject.repositories.GitHubRepositoryDetailsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RepositoryDetailsServiceImpl extends ServiceImpl<GitHubRepositoryDetails, Long> {

    public RepositoryDetailsServiceImpl(GitHubRepositoryDetailsRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    protected GitHubRepositoryDetails save(GitHubRepositoryDetails repositoryDetails) {
       return super.save(repositoryDetails);
    }

    public List<GitHubRepositoryDetails> findRepositoryByOwner(Long ownerId){
        return ((GitHubRepositoryDetailsRepository)getRepository()).findByOwner_ownerId(ownerId);
    }
}
