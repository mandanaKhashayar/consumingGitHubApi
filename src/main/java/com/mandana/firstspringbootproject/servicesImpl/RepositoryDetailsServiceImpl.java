package com.mandana.firstspringbootproject.servicesImpl;

import com.mandana.firstspringbootproject.models.RepositoryDetails;
import com.mandana.firstspringbootproject.repositories.RepositoryDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class RepositoryDetailsServiceImpl extends ServiceImpl<RepositoryDetails, Long> {

    public RepositoryDetailsServiceImpl(RepositoryDetailsRepository repository) {
        super(repository);
    }
}
