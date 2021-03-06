package graphql.kickstart.graphiql.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ServletGraphiQLControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldBeAbleToAccessGraphiQL() throws Exception {
      mockMvc.perform(get("/graphiql"))
          .andExpect(status().is2xxSuccessful())
          .andExpect(content().contentType("text/html; charset=UTF-8"));
    }

    @SpringBootConfiguration
    @TestPropertySource(properties = "graphiql.enabled=true")
    @Import(GraphiQLAutoConfiguration.class)
    public static class ServletTestApplication {
    }
}
