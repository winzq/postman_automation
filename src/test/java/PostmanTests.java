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
                .then().statusCode(200);
    }

    @Test
    public void Check404Status()
    {
        given()
                .baseUri("https://postman-echo.com")
                .basePath("ge")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(404);
    }

    @Test
    public void GetMethodURLCheck()
    {
        given()
                .baseUri("https://postman-echo.com")
                .basePath("/get")
                .contentType(ContentType.JSON)
                .when().get()
                .then().body("url",equalTo("https://postman-echo.com/get"));
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



