package utilities;
import io.restassured.*;
import io.restassured.response.*;
import org.testng.*;
public class APIUtil_ReusableMethod {
    public static void assertStatusCodeIsOk(Response response) {
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    public static void assertStatusCodeNotFound(Response response) {
        Assert.assertEquals(response.getStatusCode(), 404);
    }
    public static void assertStatusCodeCreated(Response response) {
        Assert.assertEquals(response.getStatusCode(), 201);
    }
    public static void assertStatusCode(Response response, int expected) {
        Assert.assertEquals(response.getStatusCode(), expected);
    }
    public static Response sendGetRequest(String endpoint) {
        return RestAssured.given().
                // templated request
                        when().get(endpoint);
    }
    public static Response sendGetPostRequest(Object body, String endpoint) {
        return RestAssured.given().
                body(body).
                // templated request
                        when().get(endpoint);
    }
 public static Response sendGetPostRequest(Object body, String endpoint,String token) {
        return RestAssured.given().
                auth().oauth2(token).
                body(body).
                // templated request
                        when().get(endpoint);
    }
}