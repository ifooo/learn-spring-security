package com.baeldung.test;

import com.baeldung.lss.spring.LssApp2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LssApp2.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class Lss2IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenLoadApplication_thenSuccess() {
    }

    @Test
    public void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(print())
                .andExpect(view().name("users/list"));
    }
}
