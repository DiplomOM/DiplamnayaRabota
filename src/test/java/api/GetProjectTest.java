package api;

import baseEntities.BaseAPITest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProjectTest extends BaseAPITest {

    @Test
    public void getProjects() {
        String endpoint = "index.php?/api/v2/get_projects";
        given()
                .when()
                .get(endpoint)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void getUsers() {
        String endpoint = "index.php?/api/v2/get_users";
        given()
                .when()
                .get(endpoint)
                .then()
                    .statusCode(HttpStatus.SC_OK)
                .log().body();
    }
    @Test
    public void getUserNotFound() {
        String endpoint = "index.php?/api/v2/get_user/88";
        given()
                .when()
                .get(endpoint)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body();
    }

    @Test
    public void getProjectNotFound() {
        String endpoint = "index.php?/api/v2/get_project/878";
        given()
                .when()
                .get(endpoint)
                .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)
                .log().body();
    }
}
