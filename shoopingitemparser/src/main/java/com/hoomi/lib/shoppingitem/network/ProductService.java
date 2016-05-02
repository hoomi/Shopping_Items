package com.hoomi.lib.shoppingitem.network;

import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public interface ProductService {

    // As I need to run some javascript on the page I need to change the url so I get back a json with items
    //    @GET("/webapp/wcs/stores/servlet/CategoryDisplay?langId=44&storeId=10151&catalogId=10122&categoryId=185749&orderBy=PRICE_ASC&beginIndex=0&promotionId=&listId=&searchTerm=&hasPreviousOrder=%5BLjava.lang.String%3B%406850685&previousOrderId=&categoryFacetId1=&categoryFacetId2=&bundleId=&parent_category_rn=12518&top_category=12518&pageSize=20")
    @GET("webapp/wcs/stores/servlet/AjaxApplyFilterBrowseView?langId=44&storeId=10151&catalogId=10122&categoryId=185749&parent_category_rn=&top_category=&pageSize=20&orderBy=PRICE_ASC&searchTerm=&beginIndex=0&hideFilters=true")
    @Headers({"Accept: application/json,charset=utf-8",
            "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36",
    "Accept-Language: en-US,en;q=0.8,fr;q=0.6,fa;q=0.4",
    "Cache-Control: no-cache"})
    Call<List<Product>> getListOfProducts();
}
