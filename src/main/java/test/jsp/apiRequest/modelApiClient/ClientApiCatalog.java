/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsp.apiRequest.modelApiClient;

import com.squareup.square.models.CatalogObject;
import java.util.List;
import retrofit2.Call;
//import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.GET;
//import test.jsp.apiRequest.modelApiRequestResponse.modelApiOrderRequest;
//import test.jsp.apiRequest.modelApiRequestResponse.modelApiOrderResponse;

/**
 *
 * @author danyr59
 */
public interface ClientApiCatalog {
    
    @GET("integrationSquarePOS/api/v1/items")
    Call<List<CatalogObject>> getCatalogApi();
}
