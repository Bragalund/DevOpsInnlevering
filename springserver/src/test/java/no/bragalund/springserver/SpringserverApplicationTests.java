package no.bragalund.springserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD) // clean after each test
public class SpringserverApplicationTests extends TestConfig {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testHealthEndpoint() {
        String response = given().contentType("text/plain;charset=UTF-8")
                .get("/heartbeat")
                .then()
                .statusCode(200)
                .extract().asString();

        assertEquals("<3", response);
    }

}
