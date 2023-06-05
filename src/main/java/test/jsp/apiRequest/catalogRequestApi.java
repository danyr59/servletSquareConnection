/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.jsp.apiRequest;

import com.squareup.square.models.CatalogObject;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import test.jsp.apiRequest.modelApiClient.ClientApiCatalog;
import retrofit2.Call;
import retrofit2.Response;
import test.jsp.servletController.CreateOrderServlet;
import jakarta.inject.Named;

/**
 *
 * @author danyr59
 */
@Named
public class catalogRequestApi {

    public Retrofit retrofit = null;

    public catalogRequestApi() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public List<CatalogObject> runCallgetCatalog() throws InterruptedException {
        ClientApiCatalog orderClient = this.retrofit.create(ClientApiCatalog.class);

//        CatalogObject orderBody = new CatalogObject();
        //creation of order
        Call<List<CatalogObject>> call = orderClient.getCatalogApi();
        Response<List<CatalogObject>> catalogResponse = null;
        try {
            catalogResponse =  call.execute();
           
        } catch (IOException | RuntimeException ex) {
            System.err.println(ex);
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return catalogResponse.body();
    }

}
