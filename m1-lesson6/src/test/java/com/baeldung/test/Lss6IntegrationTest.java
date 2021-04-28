package com.baeldung.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.lss.spring.LssApp6;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LssApp6.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class Lss6IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenLoadApplication_thenSuccess() {
    }

    @Test
    @WithMockUser(password = "pass")
    public void list() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/")).andDo(print())
                .andExpect(view().name("redirect:/user"));
    }
}
