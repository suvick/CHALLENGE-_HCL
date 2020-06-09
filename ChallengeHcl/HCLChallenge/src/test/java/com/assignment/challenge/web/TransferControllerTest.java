package com.assignment.challenge.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransferControllerTest {

    @InjectMocks
    private TransferController transferController;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(transferController).build();

    }

    @Test
    public void testDoFundTransfer() throws Exception {
        //Arrange
//		mockMvc.perform(get("/v1/accounts/fundTransfer"))
//		.andExpect(status().isOk())
//		.andExpect(MockMvcResultMatchers.content().string("success"));

        this.mockMvc.perform(get("/v1/accounts/fundTransfer"))
                .andExpect(status()
                        .isOk());

    }

}
