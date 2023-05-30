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
import java.util.HashMap;
import java.util.Map;
import lombok.NonNull;
import retrofit2.http.Body;

import test.jsp.apiRequest.modelApi.modelApiOrderResponse;
import test.jsp.apiRequest.modelApiClient.clientApiOrderUpdate;
import test.jsp.apiRequest.modelApiClient.clientApiPayment;

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

    public modelApiOrderResponse runPromise(modelApiOrder order) throws InterruptedException {
        ClientApiOrder orderClient = this.retrofit.create(ClientApiOrder.class);
        //modelApiOrder order_ = new modelApiOrder(order);

        modelApiOrderResponse orderBody = new modelApiOrderResponse();

        //creation of order
        Call<modelApiOrderResponse> call = orderClient.postModelApiOrder(order);

        //synchronous
        try {

            Response<modelApiOrderResponse> response = call.execute();
            orderBody.setOrderId(response.body().getOrderId());
            orderBody.setTitle(response.body().getTitle());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //update order
        if (!orderBody.getTitle().equals("SUCCESS")) {
            throw new RuntimeException("Error en crear orden");
        }

        clientApiOrderUpdate orderClientUpdate = this.retrofit.create(clientApiOrderUpdate.class);

        //update
        Map<String, String> params = new HashMap<String, String>();
        var locationId = order.getOrder().getLocation_id();
        params.put("order_id", orderBody.getOrderId());
        params.put("location_id", locationId);
        Call<modelApiOrderResponse> callUpdate = orderClientUpdate.postModelApiOrder(params, order);

        try {
            Response<modelApiOrderResponse> response = callUpdate.execute();
            orderBody.setOrderId(response.body().getOrderId());
            orderBody.setTitle(response.body().getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!orderBody.getTitle().equals("SUCCESS")) {
            throw new RuntimeException("Error al actualizar orden");
        }

        clientApiPayment orderClientPayment = this.retrofit.create(clientApiPayment.class);
        //payment

        modelApiOrder.Order o = new modelApiOrder.Order();
        o.setLine_items(order.getOrder().getLine_items());
        o.setCustomer_id(order.getOrder().getCustomer_id());
        o.setLocation_id(order.getOrder().getLocation_id());
        o.setState(order.getOrder().getState());
        o.setTicket_name(order.getOrder().getTicket_name());
        o.setTaxes(order.getOrder().getTaxes());
        o.setFulfillments(order.getOrder().getFulfillments());
        o.setSource_id(order.getOrder().getSource_id());
        o.setReference_id(order.getOrder().getReference_id());
        o.setExternal_details(order.getOrder().getExternal_details());
        o.setOrder_id(orderBody.getOrderId());

        Call<modelApiOrderResponse> callPayment = orderClientPayment.postModelApiPayment(o);

        try {
            Response<modelApiOrderResponse> response = callPayment.execute();
            orderBody.setTitle(response.body().getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderBody;
    }

}
