package test.jsp.apiRequest.modelApiClient;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import test.jsp.apiRequest.modelApi.modelApiOrder;

/**
 *
 * @author danyr59
 */
public interface ClientApiOrder {
    @POST("integrationSquarePOS/api/v1/orders")
    Call<modelApiOrder> postModelApiOrder(@Body modelApiOrder order);
    
}
