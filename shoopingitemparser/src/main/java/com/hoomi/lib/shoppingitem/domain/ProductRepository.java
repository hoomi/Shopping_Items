package com.hoomi.lib.shoppingitem.domain;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.domain.model.Product;

import java.util.List;

/**
 * Created by hoomanostovari on 01/05/2016.
 */
public interface ProductRepository {
    void getShoppingItems(CallbackReceiver callBackReceiver);
}
