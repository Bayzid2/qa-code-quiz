package meldCX_API_testing.apiTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class mockedAPI_Test {

	 private static final String BASE_URL = "http://localhost:9999";

	    @Test
	    public void testCreateUser() {
	        RestAssured.baseURI = BASE_URL;

	        given()
	            .contentType(ContentType.JSON)
	            .body("{\n" +
	                  "  \"username\": \"bayzid12\",\n" +
	                  "  \"name\": \"Bayzid\",\n" +
	                  "  \"password\": \"bayzid123\",\n" +
	                  "  \"favouriteFruit\": \"Mango\",\n" +
	                  "  \"favouriteMovie\": \"Titanic\",\n" +
	                  "  \"favouriteNumber\": 98\n" +
	                  "}")
	        .when()
	            .post("/user")
	        .then()
				.assertThat()
	            .statusCode(200)
	            .body(equalTo("Account Created"));
	    }
	    
	    @Test
	    public void testCreateDuplicateUser() {
	        RestAssured.baseURI = BASE_URL;

	        // Step 1: Create the user for the first time
	        given()
	            .contentType(ContentType.JSON)
	            .body("{\n" +
	                  "  \"username\": \"bayzid123\",\n" +
	                  "  \"name\": \"Bayzid\",\n" +
	                  "  \"password\": \"bayzid123\",\n" +
	                  "  \"favouriteFruit\": \"Apple\",\n" +
	                  "  \"favouriteMovie\": \"Triangle\",\n" +
	                  "  \"favouriteNumber\": 9\n" +
	                  "}")
	        .when()
	            .post("/user")
	        .then()
				.assertThat()
	            .statusCode(200)
	            .body(equalTo("Account Created"));

	        // Step 2: Try creating the same user again
	        given()
	            .contentType(ContentType.JSON)
	            .body"{\n" +
	                  "  \"username\": \"bayzid123\",\n" +
	                  "  \"name\": \"Bayzid\",\n" +
	                  "  \"password\": \"bayzid123\",\n" +
	                  "  \"favouriteFruit\": \"Apple\",\n" +
	                  "  \"favouriteMovie\": \"Triangle\",\n" +
	                  "  \"favouriteNumber\": 9\n" +
	                  "}"
	        .when()
	            .post("/user")
	        .then()
	            .statusCode(409)
	            .body(equalTo("Account Already Exists"));
	    }
	    
	   

    @Test
	    public void testUpdateUserData() {
	        RestAssured.baseURI = BASE_URL;

	        given()
	            .contentType(ContentType.JSON)
	            .queryParam("username", "bayzid12")  // ✅ this is important
	            .body("{\n" +
	                  "  \"name\": \"Bayzid Bostami\",\n" +
	                  "  \"password\": \"bayzid123\",\n" +
	                  "  \"favouriteFruit\": \"Banana\",\n" +
	                  "  \"favouriteMovie\": \"Inception\",\n" +
	                  "  \"favouriteNumber\": 9\n" +
	                  "}")
	        .when()
	            .put("/user")
	        .then()
	        	.assertThat()
	            .statusCode(200)
	            .body(equalTo("Account Updated"));
	    }


	    @Test
	    public void testDeleteUser() {
	        RestAssured.baseURI = BASE_URL;

	        given()
	            .queryParam("username", "bayzid12")
	        .when()
	            .delete("/user")
	        .then()
				.assertThat()
	            .statusCode(200)
	            .body(equalTo("Account Deleted"));
	    }
	
}
