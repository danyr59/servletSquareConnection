package test.jsp.apiRequest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import test.jsp.apiRequest.modelApi.modelApiOrder;
import test.jsp.apiRequest.modelApiClient.ClientApiOrder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//modelo para la respuesta
import com.squareup.square.models.Order;
import lombok.NonNull;

import test.jsp.apiRequest.modelApi.modelApiOrderResponse;

/**
 *
 * @author danyr59
 */
public class orderRequestApi {

    public Retrofit retrofit = null;

    public orderRequestApi() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public modelApiOrderResponse runPromise(@NonNull modelApiOrder order) throws InterruptedException {
        ClientApiOrder orderClient = this.retrofit.create(ClientApiOrder.class);
        //modelApiOrder order_ = new modelApiOrder(order);

        modelApiOrderResponse orderBody = new modelApiOrderResponse();

        Call<modelApiOrderResponse> call = orderClient.postModelApiOrder(order);
        //synchronous
        try {
            Response<modelApiOrderResponse> response = call.execute();
            orderBody.setModelApiOrderResponse(response.body());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //asynchronous
        /*
        call.enqueue(new Callback<modelApiOrderResponse>() {
            @Override
            public void onResponse(Call<modelApiOrderResponse> call, Response<modelApiOrderResponse> response) {
                //modelApiOrder order1 = response.body();
                orderBody.setModelApiOrderResponse(response.body());
                System.out.println(orderBody);
                System.out.println("En runPromise");
                //System.out.println(response.body());
                
            }

            @Override
            public void onFailure(Call<modelApiOrderResponse> call, Throwable t) {
                System.err.println(t.toString());

            }
        });
         */
        return orderBody;
    }

}
