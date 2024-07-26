package testAPI.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.File;
import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class APIHelper {

    private APIHelper() {
    }

    @Value
    public static class IdStatus {
        String id;
        String status;
    }

    @Value
    @AllArgsConstructor
    @Data
    public static class APIInfoPet {
        String id;
        APIInfoPetCategory category;
        String nameType;
        //String photoUrls;
        String status;
    }

    @Value
    @AllArgsConstructor
    @Data
    public static class APIInfoPetCategory {
        String id;
        String name;
    }


    static String baseUri = "https://petstore.swagger.io/v2/pet";

    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(baseUri)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static APIInfoPet sendRequestGetPet(String id, Integer statusCodeWait) {
        return given()
                .spec(requestSpec)
                .baseUri(baseUri + "/" + id)
                .get()
                .then()
                .statusCode(statusCodeWait)
                .extract()
                .body()
                .as(APIInfoPet.class);
    }

    public static APIInfoPet sendRequestPostPet(APIInfoPet infoPetBody, Integer statusCodeWait) {
        return given()
                .spec(requestSpec)
                .body(infoPetBody)
                .when()
                .post()
                .then()
                .statusCode(statusCodeWait)
                .extract()
                .body()
                .as(APIInfoPet.class);
    }


    public static APIInfoPet sendBadRequestPost(APIInfoPet infoPetBody, Integer statusCodeWait) {
        return given()
                .spec(requestSpec)
                .body(infoPetBody)
                .when()
                .post()
                .then()
                .statusCode(statusCodeWait)
                .extract()
                .body()
                .as(APIInfoPet.class);
    }

    public static APIInfoPet sendRequestPutPet(APIInfoPet infoPetBody, Integer statusCodeWait) {
        return given()
                .spec(requestSpec)
                .body(infoPetBody)
                .when()
                .put()
                .then()
                .statusCode(statusCodeWait)
                .extract()
                .body()
                .as(APIInfoPet.class);
    }

    public static APIInfoPet sendRequestDELETEPet(String id, Integer statusCodeWait) {
        return given()
                .spec(requestSpec)
                .baseUri(baseUri + "/" + id)
                .when()
                .delete()
                .then()
                .statusCode(statusCodeWait)
                .extract()
                .body()
                .as(APIInfoPet.class);
    }

}
