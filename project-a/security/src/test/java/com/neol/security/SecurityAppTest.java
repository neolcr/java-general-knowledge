package com.neol.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityAppTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("When calling the /hello endpoint authenticated we should get 'hello' in the request body")
    @WithMockUser
    void helloAuthenticatedTest() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello"));
    }


    @Test
    @DisplayName("When calling the /hello endpoint unauthenticated we should get 401")
    void helloUnauthenticatedTest() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().is4xxClientError());
    }
}
