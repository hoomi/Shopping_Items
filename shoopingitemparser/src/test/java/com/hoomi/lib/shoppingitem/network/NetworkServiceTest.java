package com.hoomi.lib.shoppingitem.network;

import com.hoomi.lib.shoppingitem.CallbackReceiver;
import com.hoomi.lib.shoppingitem.domain.model.Product;
import com.hoomi.lib.shoppingitem.utils.FileUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

/**
 * Created by hoomanostovari on 02/05/2016.
 */
public class NetworkServiceTest {

    @Mock
    private ProductService mockedService;
    @Mock
    private CallbackReceiver mockedCallback;
    private MockWebServer mockWebServer;
    private NetworkService networkService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockWebServer = new MockWebServer();
    }


    @Test
    public void test_getting_correct_data_actual_call() throws Exception {
        Class<List<Product>> listClass = (Class) List.class;
        ArgumentCaptor<List<Product>> listArgumentCaptor = ArgumentCaptor.forClass(listClass);
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        String value = FileUtils.readFile("test_data/proper_response.html");
        MockResponse mockResponse = new MockResponse();
        mockResponse.setBody(value);
        mockWebServer.enqueue(mockResponse);
        mockWebServer.start();
        HttpUrl httpUrl = mockWebServer.url("/webapp/wcs/stores/servlet/CategoryDisplay?msg=&langId=44&categoryId=185749&categoryId=185749&storeId=10151&storeId=10151&krypto=u3WbCCWXjqaLeQRSunKENI5Z14T0HrfXEPyGJXkTlVyTn3%2B2MCWIRaU9SCs9%2FmzHctVQUuADZPTDxrNO2rJJZhAv4X3UbeTtXwPhaMvC0YWAxQc0KvRRjbNhvO9h4m9FC%2Bo4C4N5%2Bkw8q8WTXnrdMTBn1M7Q%2BCcRT3Pck2EhnW2ijJkMEQmFIN5bxXqsgfOxuYf19viAi08QEagFWP18E2CEabFHv8pBo96wgQ0idFmmqyTZSsU7%2FUugvlucglKAjw6jaORjRfyDKWdpTGVsDOfhV6Og4AHWvrzjF6SUtUbmr1lUZbc2xTQqCsm5ojT9SwGxKD0q7QZJqjrib%2FyvDQjutTEuBjbtFrcFJP58MSQYc%2Bxu07261FPWOEIbxyzFpw2Yb7rBxps8jU%2F2GZ43CfFYRq4oXLBsz7j8rBuVCt8RjfMvlyu0efIcbM2kl6jP5tq2NKKfXykDRixEqO8xZSkL%2FHWuq53%2Fhi4yuv1Y%2FBTfkwSzIoK6EWZIAietC1ywpTuIH0h14G7C8bpjGebqAw%3D%3D#langId=44&storeId=10151&catalogId=10122&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0&hideFilters=true");
        networkService = new NetworkService("http://" + httpUrl.host() + ":" + httpUrl.port());
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                countDownLatch.countDown();
                return null;
            }
        }).when(mockedCallback).onSuccess(anyList());

        doAnswer(new Answer() {
                     @Override
                     public Object answer(InvocationOnMock invocation) throws Throwable {
                         assertFalse("There should not have been an error", true);
                         return null;
                     }
                 }
        ).when(mockedCallback).onError();

        networkService.getProducts(mockedCallback);

        countDownLatch.await();
        verify(mockedCallback).onSuccess(listArgumentCaptor.capture());

        List<Product> products = listArgumentCaptor.getValue();

        assertNotNull(products);
        assertEquals(9, products.size());

    }


    @Test
    public void test_actual_call_to_sainsburys_server() throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        networkService = new NetworkService();
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                countDownLatch.countDown();
                return null;
            }
        }).when(mockedCallback).onSuccess(anyList());
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                countDownLatch.countDown();
                return null;
            }
        }).when(mockedCallback).onError();

        networkService.getProducts(mockedCallback);
        countDownLatch.await();

        verify(mockedCallback).onSuccess(anyList());
    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();

    }
}