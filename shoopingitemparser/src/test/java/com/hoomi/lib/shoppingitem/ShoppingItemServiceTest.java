package com.hoomi.lib.shoppingitem;

import com.hoomi.lib.shoppingitem.domain.ProductRepository;
import com.hoomi.lib.shoppingitem.domain.model.Product;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by hoomanostovari on 01/05/2016.
 */
public class ShoppingItemServiceTest {

    @Mock
    private ProductRepository mockedProductRepository;
    @Mock
    private CallbackReceiver mockedCallBackReceiver;
    private List<Product> testProducts;

    @Before
    public void setUp() throws Exception {
        testProducts = new ArrayList<>();
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void test_instance_not_null() throws Exception {
        assertNotNull(ShoppingItemService.getInstance());
    }

    @Test
    public void test_singleton() throws Exception {
        ShoppingItemService shoppingItemService = ShoppingItemService.getInstance();
        ShoppingItemService shoppingItemService1 = ShoppingItemService.getInstance();
        assertSame(shoppingItemService, shoppingItemService1);
    }

    @Test
    public void test_singleton_multi_thread() throws Exception {
        int numberOfThreads = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(numberOfThreads);
        final ShoppingItemService[] shoppingItemServices = new ShoppingItemService[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    shoppingItemServices[finalI] = ShoppingItemService.getInstance();
                    countDownLatch.countDown();

                }
            }).start();
        }
        countDownLatch.await(10, TimeUnit.SECONDS);
        for (int i = 1; i < numberOfThreads; i++) {
            assertSame(shoppingItemServices[0], shoppingItemServices[i]);
        }
    }

    @Test
    public void test_get_list_of_items() throws Exception {
        ShoppingItemService shoppingItemService = new ShoppingItemService(mockedProductRepository);

        shoppingItemService.getItems(mockedCallBackReceiver);

        verify(mockedProductRepository).getShoppingItems(mockedCallBackReceiver);
    }
}