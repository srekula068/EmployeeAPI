package testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class GetEmployee {
	
	@Test()
	public void getEmployee() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/";
	    RequestSpecification httpRequest = RestAssured.given();
	    // Set HTTP Headers
	    httpRequest.header("Content-Type", "application/json");	    
	    Response response = httpRequest.get("api/v1/employees");
	    
	    // Get Response Body 
	    ResponseBody body = response.getBody();
	    int responsecode= response.getStatusCode();
	    Assert.assertEquals(responsecode /*actual value*/, 200 /*expected value*/, "Incorrect status code returned");

	  JsonPath jsonPathEvaluator = response.jsonPath();
	  String employee = jsonPathEvaluator.get("data[23]").toString();
	  System.out.println(employee);
	 String employeename= jsonPathEvaluator.get("data[23].employee_name");
	 Assert.assertEquals(employeename, "Doris Wilder", "Correct employee name received in the Response");
	}
}




  