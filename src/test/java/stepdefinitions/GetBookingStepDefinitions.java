package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import pojo.restful.Booking;

public class GetBookingStepDefinitions {

    String baseURI = "https://restful-booker.herokuapp.com";
    RequestSpecBuilder request = new RequestSpecBuilder().setBaseUri(baseURI);
    Response response;


    @Given("User sets the {string} path as {int}")
    public void userSetsThePathAs(String pathParam, int pathValue) {

        request.addPathParam(pathParam, pathValue);

    }

    @When("User sends a request to {string}")
    public void userSendsARequestTo(String endpoint) {

        RequestSpecification spec = request.build();
        response = RestAssured.given().spec(spec).log().all().when().get(endpoint);

        response.then().statusCode(200);

    }

    @Then("User should see expected booking record")
    public void userShouldSeeExpectedBookingRecord() {

        Booking booking = response.as(Booking.class);

        System.out.println(booking);

        Assert.assertEquals(booking.getFirstname(), "Mary");
        Assert.assertEquals(booking.getLastname(), "Smith");

        // expected data normal sartlarda bazi queryler veya baz alinan datalardan olusturulur.
        // Dersimizde Fake API lar kullandigimiz icin baz aldigimiz datalar degisiklik gostermekte.
        // Bu yuzden bu test her zaman pass olmayabilir
        // Pass olmadigi durumda lutfen requesti manuel atip expected datayi hard coded olarak degistiriniz

    }
}