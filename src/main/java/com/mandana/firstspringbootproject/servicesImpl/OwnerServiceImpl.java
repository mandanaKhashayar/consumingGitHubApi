package com.mandana.firstspringbootproject.servicesImpl;

import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.repositories.OwnerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    public List<Owner> getOwners() {
       return repository.findAll();
    }

    public Owner findByOwnerId(Long ownerId) {
      return ((OwnerRepository)repository).findByOwnerId(ownerId);
    }
}
