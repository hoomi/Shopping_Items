package com.hoomi.lib.shoppingitem.network;

import com.hoomi.lib.shoppingitem.domain.model.Product;
import com.hoomi.lib.shoppingitem.utils.FileUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.util.List;

import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Converter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class SainsburysConverterTest {

    @Mock
    private ResponseBody mockedResponseBody;
    @Mock
    private BufferedSource mockedBufferedSource;
    private SainsburysConverter sainsburysConverter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        sainsburysConverter = new SainsburysConverter();

    }

    @Test
    public void test_proper_conversion() throws Exception {
        String value = FileUtils.readFile("test_data/proper_response.html");
        Converter<ResponseBody, ?> converter = sainsburysConverter.responseBodyConverter(null, null, null);

        when(mockedResponseBody.source()).thenReturn(mockedBufferedSource);
        when(mockedBufferedSource.inputStream()).thenReturn(new ByteArrayInputStream(value.getBytes()));

        List<Product> products = (List<Product>) converter.convert(mockedResponseBody);

        assertNotNull(products);
        assertEquals(9, products.size());

    }

    //TODO add the tests for bad conditions. As time is limited I only the positive scenario
}