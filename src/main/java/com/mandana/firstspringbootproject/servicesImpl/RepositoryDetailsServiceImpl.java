package com.mandana.firstspringbootproject.servicesImpl;

import com.mandana.firstspringbootproject.models.RepositoryDetails;
import com.mandana.firstspringbootproject.repositories.RepositoryDetailsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RepositoryDetailsServiceImpl extends ServiceImpl<RepositoryDetails, Long> {

    public RepositoryDetailsServiceImpl(RepositoryDetailsRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    protected RepositoryDetails save(RepositoryDetails repositoryDetails) {
       return super.save(repositoryDetails);
    }
}
