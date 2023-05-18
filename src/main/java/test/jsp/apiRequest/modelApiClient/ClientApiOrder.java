package test.jsp.apiRequest.modelApiClient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import test.jsp.apiRequest.modelApi.modelApiOrder;
import com.squareup.square.models.Order;
import java.util.List;
import retrofit2.http.Headers;
import test.jsp.apiRequest.modelApi.modelApiOrderResponse;

/**
 *
 * @author danyr59
 */
public interface ClientApiOrder {

    @Headers("Content-type: application/json")
    @POST("integrationSquarePOS/api/v1/orders")
    Call<modelApiOrderResponse> postModelApiOrder(@Body modelApiOrder order);

}
