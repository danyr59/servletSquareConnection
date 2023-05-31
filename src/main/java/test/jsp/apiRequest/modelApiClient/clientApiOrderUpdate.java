/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsp.apiRequest.modelApiClient;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;

import retrofit2.http.PUT;
import retrofit2.http.QueryMap;
import test.jsp.apiRequest.modelApiRequestResponse.modelApiOrderRequest;
import test.jsp.apiRequest.modelApiRequestResponse.modelApiOrderResponse;

/**
 *
 * @author danyr59
 */
public interface clientApiOrderUpdate {
    @Headers("Content-type: application/json")
    @PUT("integrationSquarePOS/api/v1/orders")

    Call<modelApiOrderResponse> postModelApiOrder(@QueryMap Map<String, String> params, @Body modelApiOrderRequest order);

}
