package Navi.StepDefs;

import com.Navi.Model.CreateUser;
import com.Navi.Services.ApiComponent;
import com.Navi.Services.RestClient;
import com.Navi.Utilites.ReadProperty;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class MyStepdefs {
    public static RestClient restClient;
    public static ApiComponent apiComponent;

    static {
        try {
            restClient= new RestClient(ReadProperty.getValueForGivenKey("baseUrl"));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        apiComponent = new ApiComponent();
    }

    @Given("endPoint is set to {string}")
    public void end_point_is_set_to(String endPoint) {
        apiComponent.setEndPoint(endPoint);
    }

    @Given("headers are set to")
    public void headers_are_set_to(DataTable dataTable) {
        Map<String, Object> headers = new HashMap<>();
        if (dataTable != null) {
            Map<String, String> header = dataTable.asMap(String.class, String.class);
            headers.putAll(header);
        }
        apiComponent.setHeaders(headers);
    }

    @When("the {string} call is made to the request")
    public void the_call_is_made_to_the_request(String HttpType) throws Throwable {
        Response response = restClient.whenRequestIsInvoked(HttpType, apiComponent.getHeaders(), apiComponent.getEndPoint(), null,
                null, null);
        apiComponent.setResponse(response);
    }

    @Then("the response of the status should be {int}")
    public void theResponseOfTheStatusShouldBe(int responseCode) {
        Response response = apiComponent.getResponse();
        Assert.assertEquals(response.getStatusCode(),responseCode);
        String responseAsString = response.getBody().asString();
    }

    @And("payload is created to create a user")
    public void payloadIsCreatedToCreateAUser() {
        CreateUser createUser = new CreateUser("Saleem", "QAE-1");
        String payload = new Gson().toJson(createUser);
        apiComponent.setPayload(payload);
    }
}
