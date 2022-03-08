package com.mandana.firstspringbootproject.servicesImpl;

import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.repositories.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OwnerServiceImpl extends ServiceImpl<Owner, Long> {
    public OwnerServiceImpl(OwnerRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    protected Owner save(Owner owner) {
        return super.save(owner);
    }
}
