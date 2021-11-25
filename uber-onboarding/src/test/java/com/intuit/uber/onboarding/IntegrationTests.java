/*-Author------------------------------------
*- bibhas.abhishek@gmail.com
*- uber-onboarding: IntegrationTests
*- 26 Nov 2021 1:09 AM
---Made with <3 in Delhi,India---------------
---Details-----------------------------------
*- Links:
-------------------------------------------*/

package com.intuit.uber.onboarding;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void successSignup() throws Exception {
        this.mockMvc.perform(post("/api/signupUser").contentType(MediaType.APPLICATION_JSON)
            .content(
                "{\"userType\":\"DRIVER\",\"name\":\"test_name\",\"age\":32,\"address\":\"test_address\",\"identityType\":\"DRIVING_LICENCE\","
                     + "\"identityNumber\":\"123456\"}"))
            .andDo(print()).andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value(HttpStatus.CREATED.getReasonPhrase()));
    }

    @Test
    void successSignupVerify() throws Exception {
        this.mockMvc.perform(get("/api/getUser/{id}", "1")).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.message").value(HttpStatus.OK.getReasonPhrase()));
    }

    @Test
    void failedSignupValidate() throws Exception {
        this.mockMvc.perform(post("/api/signupUser").contentType(MediaType.APPLICATION_JSON)
            .content(
                "{\"userType\":\"DRIVER\",\"name\":\"test_name\",\"age\":32,\"address\":\"test_address\",\"identityType\":\"AADHAR\","
                     + "\"identityNumber\":\"123456\"}"))
            .andDo(print())
            .andExpect(jsonPath("$.message").value("Driver needs a driving licence as id proof"));
    }
}
