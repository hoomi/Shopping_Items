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
    "Cache-Control: no-cache",
    "Cookie: Apache=10.173.138.15.1462193395900554; JSESSIONID=0000dV55JQIfRpM-WCFpKPX7-uU:17buglf5f; SESSION_COOKIEACCEPT=true; WC_SESSION_ESTABLISHED=true; WC_PERSISTENT=1L6vntDvoAqEYlvuUPUKaililIk%3D%0A%3B2016-05-02+13%3A49%3A55.908_1462193395903-110079_10151; WC_ACTIVEPOINTER=44%2C10151; WC_USERACTIVITY_-1002=-1002%2C10151%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2Cnull%2CqdmEdao7Tj5H2yuezg3lDGTIA9Fbr3sCyhTfQ3SnlhJWAvEXGR6tjRahNeDgJIjdjuzitzE0H6ULwOnkXzCP7dwdO9RlmFjsByKAS4GRQPnDPLeSe6flbKteB2avuxXL%2FrizFOl8pHraJOE%2Fa35Bgl9SiAVfDgEmbRU0Px2kAklNtKOxr3OUoblrh1c8v1JWTEU5u7pjUHC4vmJmlJz6fQ%3D%3D; WC_GENERIC_ACTIVITYDATA=[11380929987%3Atrue%3Afalse%3A0%3Atg4FWJrzCr%2FYl0ij0CayLOfl3XY%3D][com.ibm.commerce.context.audit.AuditContext|1462193395903-110079][com.ibm.commerce.store.facade.server.context.StoreGeoCodeContext|null%26null%26null%26null%26null%26null][CTXSETNAME|Store][com.sol.commerce.context.SolBusinessContext|null%26null%26null%26null%26null%26null%26null%26null%26false%26false%26false%26null%26false%26null%26false%26false%26null%26false%26false][com.ibm.commerce.context.globalization.GlobalizationContext|44%26GBP%2644%26GBP][com.ibm.commerce.catalog.businesscontext.CatalogContext|10122%26null%26false%26false%26false][com.ibm.commerce.context.preview.PreviewContext|null%26null%26false][com.ibm.commerce.context.base.BaseContext|10151%26-1002%26-1002%26-1][com.ibm.commerce.context.experiment.ExperimentContext|null][com.ibm.commerce.context.entitlement.EntitlementContext|10502%2610502%26null%26-2000%26null%26null%26null]; sbrycookie1=630263751; sbrycookie2=FdrHbjOczkHbHbkHbQKUC; TS017d4e39=01e0f702cfc4ce4ee616458a48bb3a45ca69f0d6e95f9f83a4aad60ed13d931aad98f45bf99733f6a232ed5c7e6f7c1b3207b0376370263d675aa93b122dd1a0b85eac8c8ec7c50f33fb07323a3e995b274e44950c88f2892c4bd38fbda7a31da474f17fae30c750f7f4292e2ce2fef71a5cebedf856673a4c4cbc0aa4b9d36f76053fc1b321944f73ca1d6025fb80dd3ccd3859916804783c91a0f6cb5bfb585a3efd81a31ccae584444f83d4c087b59ab492005a00b769b7abc17817906ca44c877135e0; TS01cd64fc=01e0f702cff8718e33c6b5582e1c2a1c64622a3eb470611f056f65a71ceebd20536deca470f6454f7fbcafae28c723a8795fdc302c"})
    Call<List<Product>> getListOfProducts();
}
