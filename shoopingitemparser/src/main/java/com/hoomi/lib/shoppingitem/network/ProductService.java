package com.hoomi.lib.shoppingitem.network;

import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public interface ProductService {

    @GET("/webapp/wcs/stores/servlet/CategoryDisplay?msg=&langId=44&categoryId=185749&categoryId=185749&storeId=10151&storeId=10151&krypto=u3WbCCWXjqaLeQRSunKENI5Z14T0HrfXEPyGJXkTlVyTn3%2B2MCWIRaU9SCs9%2FmzHctVQUuADZPTDxrNO2rJJZhAv4X3UbeTtXwPhaMvC0YWAxQc0KvRRjbNhvO9h4m9FC%2Bo4C4N5%2Bkw8q8WTXnrdMTBn1M7Q%2BCcRT3Pck2EhnW2ijJkMEQmFIN5bxXqsgfOxuYf19viAi08QEagFWP18E2CEabFHv8pBo96wgQ0idFmmqyTZSsU7%2FUugvlucglKAjw6jaORjRfyDKWdpTGVsDOfhV6Og4AHWvrzjF6SUtUbmr1lUZbc2xTQqCsm5ojT9SwGxKD0q7QZJqjrib%2FyvDQjutTEuBjbtFrcFJP58MSQYc%2Bxu07261FPWOEIbxyzFpw2Yb7rBxps8jU%2F2GZ43CfFYRq4oXLBsz7j8rBuVCt8RjfMvlyu0efIcbM2kl6jP5tq2NKKfXykDRixEqO8xZSkL%2FHWuq53%2Fhi4yuv1Y%2FBTfkwSzIoK6EWZIAietC1ywpTuIH0h14G7C8bpjGebqAw%3D%3D#langId=44&storeId=10151&catalogId=10122&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true")
    Call<List<Product>> getListOfProducts();
}
