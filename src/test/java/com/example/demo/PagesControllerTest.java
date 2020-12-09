package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PagesController.class)

public class PagesControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void testingPages() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    public void testMathPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");

        this.mvc.perform(request).andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testMathCalculationsWithThreeParams() throws Exception {
        RequestBuilder addRequest = MockMvcRequestBuilders.get("/math/calculate?x=4&y=6&ops=add");
        this.mvc.perform(addRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));

        RequestBuilder multiplyRequest = MockMvcRequestBuilders.get("/math/calculate?x=4&y=6&ops=multiply");
        this.mvc.perform(multiplyRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));

        RequestBuilder subtractRequest = MockMvcRequestBuilders.get("/math/calculate?x=4&y=6&ops=subtract");
        this.mvc.perform(subtractRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));

        RequestBuilder divideRequest = MockMvcRequestBuilders.get("/math/calculate?x=30&y=5&ops=divide");
        this.mvc.perform(divideRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("30 / 5 = 6"));

        RequestBuilder defaultRequest = MockMvcRequestBuilders.get("/math/calculate?x=30&y=5");
        this.mvc.perform(defaultRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("30 + 5 = 35"));

    }

    @Test
    public void testSummation() throws Exception {
        RequestBuilder sumRequest = MockMvcRequestBuilders.post("/math/sum?n=4&n=5&n=6");
        this.mvc.perform(sumRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));
    }

    @Test
    public void testVolumePost() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/volume/3/4/5");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));
    }

    @Test
    public void testVolumePatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.patch("/math/volume/6/7/8");
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 6x7x8 rectangle is 336"));
    }


}
