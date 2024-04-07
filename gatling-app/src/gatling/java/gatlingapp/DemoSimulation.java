package gatlingapp;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class DemoSimulation extends Simulation {

    HttpProtocolBuilder httpProtocol = http.baseUrl("http://localhost:8080");

    ScenarioBuilder scn = scenario("Demo Server")
            .exec(http("demo")
                    .get("/api/users").requestTimeout(Duration.ofSeconds(30)).check(status().is(200)));

    {
        setUp(scn.injectOpen(constantUsersPerSec(240).during(Duration.ofMinutes(5))).protocols(httpProtocol));
    }

}
