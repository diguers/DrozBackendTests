package src;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Locale;
import java.util.Random;

public class TestAtendimentoAbreTicket {

    @RepeatedTest(80)
    public void simpleTest() {
        Faker faker = new Faker(new Locale("pt-br"));
        Random random = new Random();
        RequestTalkNext requestTalkNext = new RequestTalkNext();
        ExtractableResponse<Response> extract;
        Header header = new Header("Authorization", "Basic YzI4YzQwNDRkY2E2Y2ZkNmVlZDUwOGEwNDJlZDYyNzM4ZTY1YTMxMTpPRXJZc1hCS0xM");

       // RestAssured.proxy("http://proxy.multicert.inet:8080");
        RestAssured.baseURI = "https://chat-api.meudroz.com/talk";
        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body("{}").post("/open").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer("");

        RestAssured.baseURI = "https://chat-api.meudroz.com/talk";

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer("");

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer(faker.name().fullName());

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer("");

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer(faker.internet().emailAddress());

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer("");

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        //clica em opções
        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        Integer buttons = extract.jsonPath().get("buttons[" + random.nextInt(2) + "].buttonId");
        requestTalkNext.setAnswer(buttons.toString());

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer(buttons.toString());

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer("");

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer(extract.jsonPath().get("buttons[0].buttonId").toString());

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer(faker.name().fullName());

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer("");

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer(faker.internet().emailAddress());

        extract = RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next").then().extract();

        requestTalkNext = this.atualizarReferencias(extract, requestTalkNext);
        requestTalkNext.setAnswer("");

        RestAssured.
                given().
                contentType(ContentType.JSON).
                header(header).
                body(requestTalkNext).post("/next");

    }

    public RequestTalkNext atualizarReferencias(ExtractableResponse<Response> extract, RequestTalkNext requestTalkNext) {
        requestTalkNext.setSessionId(extract.jsonPath().get("sessionId"));
        requestTalkNext.setTalkId(extract.jsonPath().get("talkId"));
        requestTalkNext.setQuestionId(extract.jsonPath().get("questionId"));
        return requestTalkNext;
    }
}
