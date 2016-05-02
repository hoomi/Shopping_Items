package com.hoomi.lib.shoppingitem.network;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class NetworkService {

    private final String host;
    private final ProductService productService;
    private Retrofit retrofit;

    public NetworkService() {
        this("http://www.sainsburys.co.uk/");
    }

    NetworkService(String host) {
        this.host = host;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(new SainsburysConverter())
                .build();
        this.productService = retrofit.create(ProductService.class);
    }


    public void getProducts(CallbackReceiver callbackReceiver) {
        this.productService.getListOfProducts().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    callbackReceiver.onSuccess(response.body());
                } else {
                    callbackReceiver.onError();
                }

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                callbackReceiver.onError();
            }
        });
    }
}
