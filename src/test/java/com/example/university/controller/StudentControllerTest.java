package com.example.university.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void TestGetStudentById() throws Exception {
        mockMvc.perform(get("/student/id?id={id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("1"))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }


    @Test
    void addStudent() throws Exception {


        String studentJson = "{\n" +
                "                \"firstName\": \"test\",\n" +
                "                \"lastName\": \"test\",\n" +
                "                \"gender\": \"FEMALE\",\n" +
                "                \"birthDate\": \"1998-01-16\"\n" +
                "            }";

        mockMvc.perform(post("/student")
                .contentType(MediaType.APPLICATION_JSON).content(studentJson))
                .andExpect(status().isOk()).andDo(print());

    }
}