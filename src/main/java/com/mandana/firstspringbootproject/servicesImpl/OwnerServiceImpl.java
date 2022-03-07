package com.mandana.firstspringbootproject.servicesImpl;

import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.repositories.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl extends ServiceImpl<Owner, Long> {
    public OwnerServiceImpl(OwnerRepository repository) {
        super(repository);
    }
}
