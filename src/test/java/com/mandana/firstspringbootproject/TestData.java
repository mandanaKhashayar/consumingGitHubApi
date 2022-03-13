package com.mandana.firstspringbootproject;

import com.mandana.firstspringbootproject.models.GitHubRepositoryDetails;
import com.mandana.firstspringbootproject.models.Owner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {
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
  public List<Owner> getOwnerTestListForGetPublicRepositories()
    {
        RECORD_Owner_1.getGitHubrepositoryDetailsList().add(RECORD_Repository_3);
        RECORD_Owner_2.getGitHubrepositoryDetailsList().add(RECORD_Repository_1);
        RECORD_Owner_3.getGitHubrepositoryDetailsList().add(RECORD_Repository_2);
        List<Owner> records = new ArrayList<>(Arrays.asList(RECORD_Owner_1, RECORD_Owner_2, RECORD_Owner_3));
        return records;
    }
    public Owner getOwnerTestForRepositoryByOwnerList(){

     //   RECORD_Owner_1.getGitHubrepositoryDetailsList().add(RECORD_Repository_3);
        RECORD_Owner_2.getGitHubrepositoryDetailsList().add(RECORD_Repository_1);
        RECORD_Owner_2.getGitHubrepositoryDetailsList().add(RECORD_Repository_2);
        return RECORD_Owner_2;

    }
}
