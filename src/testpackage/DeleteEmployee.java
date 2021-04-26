package testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
@Test
public class DeleteEmployee {

public void deleteEmployee() {
	
	RestAssured.baseURI = "http://dummy.restapiexample.com/";
    RequestSpecification httpRequest = RestAssured.given();
    // Set HTTP Headers
    httpRequest.header("Content-Type", "application/json");	    
    // Initialize EmpID with employeeID to be deleted
    int EmpId =8;
    
    Response response = httpRequest.delete("api/v1/delete/"+EmpId+"");
    
    // Get Response Body 
    ResponseBody body = response.getBody();
    int responsecode= response.getStatusCode();
    
    //Assert status code
    Assert.assertEquals(responsecode, 200, "Incorrect status code returned");
    //Assert success message
    Assert.assertEquals(body.asString().contains("Successfully! Record has been deleted"), true);

}
}
