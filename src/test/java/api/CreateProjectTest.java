package api;

import baseEntities.BaseAPITest;
import com.google.gson.Gson;
import models.EndPoints;
import models.ProjectModel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CreateProjectTest extends BaseAPITest {
    private int projectId = 12;

    @Test (priority = 0)
    public void createProject() {
        ProjectModel projectModel = ProjectModel.builder()
                .name("WOW")
                .suite_mode(2)
                .build();

        Gson gson = new Gson();
        String json = gson.toJson(projectModel);
        System.out.println(json);

        int projectID =
                given()
                        .body(json)
                        .when()
                        .post(EndPoints.CREATE_PROJECT)
                        .then()
                        .log().body()
                        .statusCode(HttpStatus.SC_OK)
                        .extract().jsonPath().get("id");
    }

    @Test(priority = 1)
    public void updateProjectTest(){
        ProjectModel projectModel = ProjectModel.builder()
                .name("WOW_0")
                .announcement("announcement")
                .show_announcement(true)
                .build();

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", projectModel.getName());
        jsonMap.put("announcement", projectModel.getAnnouncement());
        jsonMap.put("show_announcement", projectModel.isShow_announcement());

        given()
                .body(jsonMap)
                .when()
                .post(EndPoints.UPDATE_PROJECT + projectId)
                .then()
                .log()
                .body()
                .body("announcement", is(equalTo("announcement")))
                .body("name", is(equalTo("WOW_0")))
                .body("show_announcement", is(true))
                .statusCode(HttpStatus.SC_OK);
    }

    }



