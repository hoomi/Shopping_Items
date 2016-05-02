package com.hoomi.lib.shoppingitem.domain;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.domain.model.Product;
import com.hoomi.lib.shoppingitem.network.NetworkService;

import java.util.List;

/**
 * Created by hoomanostovari on 01/05/2016.
 */
public class SainsburysRepository implements ProductRepository {

    private final NetworkService networkService;

    public SainsburysRepository() {
        this(new NetworkService());
    }

    SainsburysRepository(NetworkService networkService) {
        this.networkService = networkService;
    }

    @Override
    public void getShoppingItems(CallbackReceiver callBackReceiver) {
        networkService.getProducts(callBackReceiver);
    }
}
