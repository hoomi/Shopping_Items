package com.hoomi.lib.shoppingitem.network;

import com.hoomi.lib.shoppingitem.domain.model.Product;
import com.hoomi.lib.shoppingitem.sainsburys.model.SainsburysProductImp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class SainsburysConverter extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new SainsburysItemConverter();
    }

    private static class SainsburysItemConverter implements Converter<ResponseBody, Object> {

        @Override
        public List<Product> convert(ResponseBody value) throws IOException {
            List<Product> products = null;
            Document document = Jsoup.parse(value.byteStream(), "UTF-8", "");
            //Look for this section first as it seems to be unique within the document
            Element productLister = document.getElementById("productLister");
            Elements productListerInner = productLister.getElementsByClass("productlister");
            Elements productInfo = productListerInner.get(0).getElementsByClass("productInfo");
            if (productInfo != null && !productInfo.isEmpty()) {
                products = new ArrayList<>(productInfo.size());
                for (Element element : productInfo) {

                    Element a = element.getElementsByTag("h3").get(0).getElementsByTag("a").get(0);
                    String title = a.text();
                    String imageRef = a.getElementsByTag("img").get(0).attr("src");
                    products.add(new SainsburysProductImp(title,imageRef,""));
                }
            }

            return products;
        }

    }


}
