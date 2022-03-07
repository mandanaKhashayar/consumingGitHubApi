package com.mandana.firstspringbootproject.repositories;

import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.models.RepositoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository  extends JpaRepository<Owner, Long> {
}
