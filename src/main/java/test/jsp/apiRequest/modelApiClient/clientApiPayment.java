/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsp.apiRequest.modelApiClient;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

import test.jsp.apiRequest.modelApi.modelApiOrder;
import test.jsp.apiRequest.modelApi.modelApiOrderResponse;

/**
 *
 * @author danyr59
 */
public interface clientApiPayment {

    @Headers("Content-type: application/json")
    @POST("integrationSquarePOS/api/v1/payment")
    Call<modelApiOrderResponse> postModelApiPayment(@Body modelApiOrder.Order order);

}
