package com.mandana.firstspringbootproject;

import com.mandana.firstspringbootproject.TestData;
import com.mandana.firstspringbootproject.models.GitHubRepositoryDetails;
import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.repositories.GitHubRepositoryDetailsRepository;
import com.mandana.firstspringbootproject.repositories.OwnerRepository;
import com.mandana.firstspringbootproject.servicesImpl.ConsumingRestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

//Data JPA tests are transactional and rollback at the end of each test by default
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class repositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private GitHubRepositoryDetailsRepository repositoryDetailsRepository;


    @MockBean
    ConsumingRestServiceImpl consumingRestServiceImpl;


    @Test
    public void test_AddOwnerAndRepository() {
        TestData testData = new TestData();
        Owner owner = testData.getOwnerTestForAddRepository();
        GitHubRepositoryDetails repositoryDetails = owner.getGitHubrepositoryDetailsList().get(0);
        repositoryDetails.setOwner(owner);

        this.entityManager.persist(repositoryDetails);

        ownerRepository.save(owner);
        owner = this.ownerRepository.findByOwnerId(2l);
        assertThat(owner.getNodeId()).isEqualTo("nodeId2");
        assertThat(owner.getLogin()).isEqualTo("login2");

        repositoryDetails = this.repositoryDetailsRepository.findByOwner_ownerId(2l).get(0);
        assertThat(repositoryDetails.getOwner().getNodeId()).isEqualTo("nodeId2");

    }
    @Test
    public void test_AddRepository() {
        TestData testData = new TestData();
        Owner owner = testData.getOwnerTestForAddRepository();
        GitHubRepositoryDetails repositoryDetails = owner.getGitHubrepositoryDetailsList().get(0);
        repositoryDetails.setOwner(owner);

        this.entityManager.persist(repositoryDetails);

        repositoryDetails = this.repositoryDetailsRepository.findByOwner_ownerId(2l).get(0);
        assertThat(repositoryDetails.getOwner().getNodeId()).isEqualTo("nodeId2");

    }
}
