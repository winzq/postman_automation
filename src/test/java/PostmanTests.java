import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostmanTests extends Pojo {


    @Test
    public void GetMethod() {
        given()
                .baseUri("https://postman-echo.com")
                .basePath("/get")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .body("headers[0].host",equalTo("postman-echo.com"));
    }

    @Test
    public void GetSchemaValidate () {
        given()
                .baseUri("https://postman-echo.com")
                .basePath("/get")
                .contentType(ContentType.JSON)
                .when().get()
                .then().assertThat().body(matchesJsonSchemaInClasspath("GetMethodSchema.json"));

    }

}



