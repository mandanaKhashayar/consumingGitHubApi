package com.mandana.firstspringbootproject.repositories;

import com.mandana.firstspringbootproject.models.GitHubRepositoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GitHubRepositoryDetailsRepository extends JpaRepository<GitHubRepositoryDetails, Long> {

    List<GitHubRepositoryDetails> findByOwner_ownerId(Long ownerId);
}
