package test.pivotal.pal.trackerapi;

import io.pivotal.pal.tracker.PalTrackerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(classes = PalTrackerApplication.class, webEnvironment = RANDOM_PORT)
public class WelcomeApiTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void exampleTest() {
        String body = this.testRestTemplate.getForObject("/", String.class);
        assertThat(body).isEqualTo("Hello from test");
    }
}
