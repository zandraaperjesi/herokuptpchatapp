package com.zandraa.perjesi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.nio.charset.Charset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = P2pchatApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class MessageRepositoryTests {

  private String requestString = "{\n"
          + "  \"message\": {\n"
          + "    \"id\": 7655482,\n"
          + "    \"username\": \"EggDice\",\n"
          + "    \"text\": \"How you doin'?\",\n"
          + "    \"timestamp\": 1322018752992\n"
          + "  },\n"
          + "  \"client\": {\n"
          + "    \"id\": \"EggDice\"\n"
          + "  }\n"
          + "}";

  private String requestIsOkString = "{\n"
          + "  \"status\": \"ok\"\n"
          + "}";

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
          MediaType.APPLICATION_JSON.getSubtype(),
          Charset.forName("utf8"));

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testSucsessfullReceiveMessage() throws Exception{
    mockMvc.perform(post("/api/message/receive")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestString))
            .andExpect(status().isOk())
            .andExpect(content().json(requestIsOkString));
  }
}
