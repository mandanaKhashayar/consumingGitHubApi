package com.mandana.firstspringbootproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandana.firstspringbootproject.TestData;
import com.mandana.firstspringbootproject.controllers.ConsumingRestController;
import com.mandana.firstspringbootproject.models.Owner;
import com.mandana.firstspringbootproject.servicesImpl.ConsumingRestServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ConsumingRestController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ConsumingRestControllerTest {
    private static String url = "https://api.github.com/repositories";
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    ConsumingRestServiceImpl consumingRestServiceImpl;


    // this method test the method named getPublicRepository() to get GitHubrepositoryDetails
    @Test
    public void test_GetPublicRepositories_success() throws Exception {
        TestData testData = new TestData();
        List<Owner> records = testData.getOwnerTestListForGetPublicRepositories();
        Mockito.when(consumingRestServiceImpl.getOwners()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/owners")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].node_id", is("nodeId")));
    }

    // this method test the method named getRepositoryByOwner() to get list of GitHubrepositoryDetails
// of one owner
    @Test
    public void test_GetRepositoryByOwner_success() throws Exception {
        TestData testData = new TestData();
        Owner record = testData.getOwnerTestForRepositoryByOwnerList();

        Mockito.when(consumingRestServiceImpl.getRepositoryByOwner(record.getOwnerId())).thenReturn(record.getGitHubrepositoryDetailsList());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/2/repositories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$[0].node_id", is("nodeIdTest")));
    }

    @Test
    void ensureThatGitHubAPICallReturnStatusCode200() throws Exception {

        //HttpRequest represents the request to be sent via the HttpClient.
        //HttpClient behaves as a container for configuration information common to multiple requests.
        //HttpResponse represents the result of an HttpRequest call.

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        assertEquals(200, response.statusCode());

    }



}