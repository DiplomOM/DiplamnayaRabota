package api;

import baseEntities.BaseAPITest;
import models.EndPoints;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestGetUsers extends BaseAPITest {

    @Test
    public void getUsers(){

        given()
                .when()
                .get(EndPoints.GET_USERS)
                .then()
                .log().body()
                .body("id", hasItems(1, 2, 3))
                .body("name", hasItem("winnie-the-pooh"))
                .body("email[2]", equalTo("yuks23@yandex.ru"))
                .statusCode(HttpStatus.SC_OK)
                .statusCode(200);
    }
}
