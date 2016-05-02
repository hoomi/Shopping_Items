package com.hoomi.lib.shoppingitem.sainsburys.model;

import com.hoomi.lib.shoppingitem.domain.model.Product;

/**
 * Created by hoomanostovari on 01/05/2016.
 */
public class SainsburysProductImp implements Product {

    private final String title;
    private final String imageRef;
    private final String unitPrice;

    public SainsburysProductImp(String title, String imageRef, String unitPrice) {
        this.title = title;
        this.imageRef = imageRef;
        this.unitPrice = unitPrice;
    }

    @Override
    public String getImageRef() {
        return this.imageRef;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getUnitPrice() {
        return null;
    }
}
