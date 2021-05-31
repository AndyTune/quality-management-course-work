import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.restassured.RestAssured.*;

import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;


class RestTest {
    @org.junit.jupiter.api.Test
    public void postGaussTest() {
        Gauss gauss = new Gauss();
        double[][] a = {{2, 4, 1},
                        {5, 2, 1},
                        {2, 3, 4}};
        double[] y   =  {36, 47, 37};
        //double[] x   =  {7, 5, 2};
        
        gauss.setA(a);
        gauss.setY(y);
        //gauss.setX(x);
        
        given()
        .contentType("application/json").body(gauss)
        .when().post("http://localhost:8080/public/rest/gauss")
        .then()
        .statusCode(HttpStatus.CREATED.value());
    }
    
    
    @org.junit.jupiter.api.Test
    public void deleteGaussTest() {
        given()
        .when().delete("http://localhost:8080/public/rest/gauss")
        .then()
        .statusCode(HttpStatus.OK.value());
    }
    
    
    @org.junit.jupiter.api.Test
    public void getGaussTest() {
        Gauss gauss = new Gauss();
        double[][] a = {{2, 4, 1},
                        {5, 2, 1},
                        {2, 3, 4}};
        double[] y   =  {36, 47, 37};
        
        gauss.setA(a);
        gauss.setY(y);
        
        given()
        .contentType("application/json").body(gauss)
        .post("http://localhost:8080/public/rest/gauss");
        
        given()
        .when().get("http://localhost:8080/public/rest/gauss")
        .then()
        .statusCode(HttpStatus.OK.value())
        .and().body("x[0]", equalTo(7f))
        .and().body("x[1]", equalTo(5f))
        .and().body("x[2]", equalTo(2f));
    }
}
