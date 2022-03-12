package com.mandana.firstspringbootproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandana.firstspringbootproject.controllers.ConsumingRestController;
import com.mandana.firstspringbootproject.models.GitHubRepositoryDetails;
import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.servicesImpl.ConsumingRestServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ConsumingRestController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class ConsumingRestControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    ConsumingRestServiceImpl consumingRestServiceImpl;

    GitHubRepositoryDetails RECORD_Repository_1 = new
            GitHubRepositoryDetails(1l, "nodeIdTest", "Mandana", "Mandana Khashayar", "public", "http://",
            "mock test record1", true, "http://2", "http://3", "http://4", "http://5", "http://6",
            "http://7", "http://8", "http://9", "http://10", "http://11", "http://12", "http://13",
            "http://14", "http://15", "http://16", "http://17", "http://18", "http://19", "http://20",
            "http://21", "http://22", "http://23", "http://24", "http://25", "http://26", "http://27",
            "http://28", "http://29", "http://30", "http://31", "http://32", "http://33", "http://34",
            "http://35", "http://36", "http://37", "http://38");

    GitHubRepositoryDetails RECORD_Repository_2 = new
            GitHubRepositoryDetails(2l, "nodeIdTest1", "Joe", "Joe Slow", "public", "http://",
            "mock test record1", true, "http://2", "http://3", "http://4", "http://5", "http://6",
            "http://7", "http://8", "http://9", "http://10", "http://11", "http://12", "http://13",
            "http://14", "http://15", "http://16", "http://17", "http://18", "http://19", "http://20",
            "http://21", "http://22", "http://23", "http://24", "http://25", "http://26", "http://27",
            "http://28", "http://29", "http://30", "http://31", "http://32", "http://33", "http://34",
            "http://35", "http://36", "http://37", "http://38");

    GitHubRepositoryDetails RECORD_Repository_3 = new
            GitHubRepositoryDetails(3l, "nodeIdTest2", "Fred", "Fred Bow", "public", "http://",
            "mock test record1", true, "http://2", "http://3", "http://4", "http://5", "http://6",
            "http://7", "http://8", "http://9", "http://10", "http://11", "http://12", "http://13",
            "http://14", "http://15", "http://16", "http://17", "http://18", "http://19", "http://20",
            "http://21", "http://22", "http://23", "http://24", "http://25", "http://26", "http://27",
            "http://28", "http://29", "http://30", "http://31", "http://32", "http://33", "http://34",
            "http://35", "http://36", "http://37", "http://38");

    Owner RECORD_Owner_1 = new Owner(1l, "login1", "nodeId1", "http://1", "gravatarId1", "http://11", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "User", true);
    Owner RECORD_Owner_2 = new Owner(2l, "login2", "nodeId2", "http://2", "gravatarId2", "http://22", "http://222", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "Admin", true);
    Owner RECORD_Owner_3 = new Owner(3l, "login3", "nodeId3", "http://3", "gravatarId3", "http://33", "http://333", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "http://111", "User", true);

    // this method test the method named getPublicRepository() to get GitHubrepositoryDetails
    @Test
    public void testGetPublicRepositories_success() throws Exception {
        RECORD_Owner_1.getGitHubrepositoryDetailsList().add(RECORD_Repository_3);
        RECORD_Owner_2.getGitHubrepositoryDetailsList().add(RECORD_Repository_1);
        RECORD_Owner_3.getGitHubrepositoryDetailsList().add(RECORD_Repository_2);
        List<Owner> records = new ArrayList<>(Arrays.asList(RECORD_Owner_1, RECORD_Owner_2, RECORD_Owner_3));

        Mockito.when(consumingRestServiceImpl.getOwners()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/owners")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].node_id", is("nodeId3")));
    }

    // this method test the method named getRepositoryByOwner() to get list of GitHubrepositoryDetails
// of one owner
    @Test
    public void testGetRepositoryByOwner_success() throws Exception {
        RECORD_Owner_1.getGitHubrepositoryDetailsList().add(RECORD_Repository_3);
        RECORD_Owner_2.getGitHubrepositoryDetailsList().add(RECORD_Repository_1);
        RECORD_Owner_2.getGitHubrepositoryDetailsList().add(RECORD_Repository_2);
        List<Owner> records = new ArrayList<>(Arrays.asList(RECORD_Owner_1, RECORD_Owner_2, RECORD_Owner_3));

        Mockito.when(consumingRestServiceImpl.getRepositoryByOwner(RECORD_Owner_2.getOwnerId())).thenReturn(RECORD_Owner_2.getGitHubrepositoryDetailsList());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/2/repositories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$[0].node_id", is("nodeIdTest")));
    }

}