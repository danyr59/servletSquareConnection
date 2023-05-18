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


/**
 *
 * @author danyr59
 */
public class orderRequestApi {

    Retrofit retrofit = null;

    public orderRequestApi() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public void runPromise(modelApiOrder order) throws InterruptedException {
        ClientApiOrder orderClient = this.retrofit.create(ClientApiOrder.class);
        modelApiOrder order_ = new modelApiOrder("", "", "1", "jdfalksdjksla", "fkdajskasjdkf");

        Call<modelApiOrder> call = orderClient.postModelApiOrder(order_);
        call.enqueue(new Callback<modelApiOrder>() {
            @Override
            public void onResponse(Call<modelApiOrder> call, Response<modelApiOrder> response) {
                //modelApiOrder order1 = response.body();
                System.out.println(response.body());
            }
            @Override
            public void onFailure(Call<modelApiOrder> call, Throwable t){
                System.err.println(t.toString());
                
            }
        });

    }

}
