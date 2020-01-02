package src;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.RepeatedTest;

public class TestAtendimentosClientesOnline {

    @RepeatedTest(40)
    public void simpleTest() {
        RestAssured.proxy("http://proxy.multicert.inet:8080");
        RestAssured.baseURI = "https://chat-api.meudroz.com/talk";
        ExtractableResponse<Response> extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header("Authorization", "Basic YzI4YzQwNDRkY2E2Y2ZkNmVlZDUwOGEwNDJlZDYyNzM4ZTY1YTMxMTpPRXJZc1hCS0xM").
                body("{}").post("/open").then().extract();
    }
}
