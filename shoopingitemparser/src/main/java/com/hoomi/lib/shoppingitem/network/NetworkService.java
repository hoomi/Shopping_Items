package com.hoomi.lib.shoppingitem.network;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.domain.model.Product;
import com.hoomi.lib.shoppingitem.utils.FileReadingUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
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
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                chain.proceed(chain.request());
                ResponseBody responseBody = new ResponseBody() {
                    @Override
                    public MediaType contentType() {
                        return MediaType.parse("application/html");
                    }

                    @Override
                    public long contentLength() {
                        return 0;
                    }

                    @Override
                    public BufferedSource source() {
                        return Okio.buffer(Okio.source(new ByteArrayInputStream(FileReadingUtils.readFile("file:///android_asset/").getBytes())));
                    }
                };
                return new okhttp3.Response.Builder()
                        .request(chain.request())
                        .protocol(Protocol.HTTP_1_1)
                        .code(200)
                        .body(responseBody)
                        .build();
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(host)
                // I cannot use this factory as the page populates the list from javascript which needs me to be able to run the javascript code
                .addConverterFactory(new SainsburysConverter())
                .client(client)
                .build();
        this.productService = retrofit.create(ProductService.class);
    }


    public void getProducts(final CallbackReceiver callbackReceiver) {
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
