package kr.co.fastcampus.eatgo.interfaces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
class ReviewControllerTests
{
    @Autowired
    private MockMvc mvc;

    @Test
    public void create() throws Exception
    {
        mvc.perform(post("/restaurants/1/reviews"))
                .andExpect(status().isCreated());
    }

}