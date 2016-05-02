package com.hoomi.lib.shoppingitem;

import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.List;

/**
 * Created by hoomanostovari on 01/05/2016.
 */
public interface CallbackReceiver {
    void onSuccess(List<Product> productList);
    void onError();
}
