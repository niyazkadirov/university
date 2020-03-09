package com.example.university.controller;

import com.example.university.entity.Student;
import com.example.university.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
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

//    @MockBean
//    StudentServiceImpl studentService;

    private Student student = new Student();


    @BeforeEach
    void setUp(){
        student.setFirstName("test");
        student.setId(1L);
    }


    @Test
    void TestGetStudentById() throws Exception {
       // when(studentService.getStudentById(anyLong())).thenReturn(java.util.Optional.ofNullable(student));

        mockMvc.perform(get("/students/id?id={id}", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }


    @Test
    void AddStudent_ShouldPassedHeaderCreated() throws Exception {

        String studentJson = "{\n" +
                "                \"firstName\": \"test\",\n" +
                "                \"lastName\": \"test\",\n" +
                "                \"gender\": \"FEMALE\",\n" +
                "                \"birthDate\": \"1998-01-16\"\n" +
                "            }";

        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentJson))
                .andExpect(status().isCreated()).andDo(print());
    }



}