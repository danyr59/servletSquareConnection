package test.jsp.apiRequest.modelApiClient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import test.jsp.apiRequest.modelApiRequestResponse.modelApiOrderRequest;
import retrofit2.http.Headers;
import test.jsp.apiRequest.modelApiRequestResponse.modelApiOrderResponse;

/**
 *
 * @author danyr59
 */
public interface ClientApiOrder {

    @Headers("Content-type: application/json")
    @POST("integrationSquarePOS/api/v1/orders")
    Call<modelApiOrderResponse> postModelApiOrder(@Body modelApiOrderRequest order);

}
