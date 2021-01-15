package api;

import baseEntities.BaseAPITest;
import models.EndPoints;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProjectTest extends BaseAPITest {

    @Test
    public void getProjects() {
        given()
                .when()
                .get(EndPoints.GET_PROJECTS)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void getUsers() {
        given()
                .when()
                .get(EndPoints.GET_USERS)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
    @Test
    public void getUserNotFound() {
        given()
                .when()
                .get(EndPoints.GET_USER88)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body();
    }

    @Test
    public void getProjectNotFound() {
        given()
                .when()
                .get(EndPoints.GET_PROJECT878)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body();
    }
}
