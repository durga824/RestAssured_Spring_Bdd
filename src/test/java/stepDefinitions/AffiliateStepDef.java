package stepDefinitions;

/**
 * Author: Durga Rao
 * Initial Date: 06/13/2024
 * Description: Step definitions for the Affiliate API tests.
 * This class contains methods that implement the steps defined in the feature files.
 */
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class AffiliateStepDef {

    public Response response;

    @Given("the API is available")
    public void the_api_is_available() {
        RestAssured.baseURI = "https://qa-api.creditrepaircloud.com";
    }

    @When("I send a GET request")
    public void i_send_a_get_request() {
        response = RestAssured
                .given()
                .header("authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpZCI6ImU5YTUxZDRhZWRjMjUwMTViY2RkNzYyMWE4NTFkYTViYmFlNGVlNTc2NGY2MDA1OWFkOWU5ZDAxMjc2NDk3MDQ4MTRkNTAzNjVlYjFlNjNkIiwiY29tcGFueV9uYW1lIjoiQXV0b21hdGlvbiIsImZpcnN0X25hbWUiOiJwYXltZW50cyIsImxhc3RfbmFtZSI6InRlc3QiLCJhZG1pbl9lbWFpbCI6InBheW1lbnR0ZXN0OTBAeW9wbWFpbC5jb20iLCJ1c2VyX2lkIjo0MDA4ODUsInJlZ19pZCI6MjA0Nzg5LCJiaWxsaW5nX3JlZl9pZCI6IjA4MzdmMjIwLTYzNzItNDg3Yy05ZWM1LWVkYTIyNzlkMzIzYiIsInVzZXJfdHlwZSI6ImFkbWluIiwiYWNjb3VudF9zdGF0dXMiOiJhY3RpdmUiLCJyZWN1cmx5X3BheW1lbnRfc3RhdHVzIjoicGFpZCIsImNvdW50cnlfY29kZSI6MjI0LCJjb3VudHJ5X25hbWUiOiJVbml0ZWQgU3RhdGVzIiwidHdvX2RpZ2l0X2NvdW50cnlfY29kZSI6IlVTIiwiY3VycmVuY3lfY29kZSI6IlVTRCIsImN1cnJlbmN5X3N5bWJvbCI6IiQiLCJ0aW1lem9uZSI6IihHTVQtOTowMCkgIEFsYXNrYSBUaW1lIiwiaXNfZWFybHlfYWNjZXNzIjoxLCJpc19wcmVfbGF1bmNoIjpmYWxzZSwiY2hhcmdlYmVlX2Vucm9sbGVkIjp0cnVlLCJjaGFyZ2ViZWVfZW5hYmxlZCI6dHJ1ZSwiY3JjX2JpbGxpbmdfZW5hYmxlZCI6dHJ1ZSwiaWF0IjoxNzE4Mjc0ODk3LCJuYmYiOjE3MTgyNzQ4OTcsImV4cCI6MTcxODM2MTI5N30.QCADyUZRnWcbSlMQai7DxmOcpLdQkyDk2SB_Q8ns11Fw-OslD61Y_Jf0rrd0_NJCppovJ1yXbFAyyBoWwvPLnDtHG-m1z-D7veP5MfhufnhD6efQKhh-HlFndA7hMJFgG6z_-Uw9pfwsLu7NprIFQlZvZHcLVZ753UFYt2JmEDJcXywVvn58WNxS9D3blfBSPrA7VhyucGXtEN2RSpDIRU5wOGcuVjTck0nWPz0EvQXXg3OzK1Q21oGr93M5Oc43mldm1L-CBNTN6nqzlVj3ZCJ6xqrTLOGPYNa1mNDD-F8LP8EJIO-qGFmDHmQOSZwEAM_lU2uU4rtnc4OYHHmVKw")
                .header("content-type", "application/json")
                .when().get("/api/affiliates")
                .then().extract().response();
        System.out.println("Response received: " + response.asString());
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(Integer int1) {
        Assert.assertNotNull(response, "Response is null");
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Then("the response should contain a list of affiliates")
    public void the_response_should_contain_a_list_of_affiliates() {
        Assert.assertTrue(response.getBody().asString().contains("list"));
    }
}