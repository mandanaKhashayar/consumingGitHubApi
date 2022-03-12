package com.mandana.firstspringbootproject.repositories;

import com.mandana.firstspringbootproject.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OwnerRepository  extends JpaRepository<Owner, Long> {
     @Query("SELECT owner FROM  Owner owner WHERE owner.ownerId = :ownerId")
    Owner findByOwnerId(long ownerId);
}
