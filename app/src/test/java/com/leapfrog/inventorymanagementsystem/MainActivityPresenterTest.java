package com.leapfrog.inventorymanagementsystem;

import com.leapfrog.inventorymanagementsystem.presenters.MainActivityPresenter;
import com.leapfrog.inventorymanagementsystem.views.MainActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Manas on 1/28/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    MainActivityView mainActivityView;

    MainActivityPresenter mainActivityPresenter;

    @Before
    public void setMainActivityView() {
        mainActivityPresenter = new MainActivityPresenter(mainActivityView);
    }

    @Test
    public void testPurchaseSuccess() throws Exception {
        when(mainActivityView.getItemCode()).thenReturn("MB13");
        when(mainActivityView.getQuantity()).thenReturn(50);

        mainActivityPresenter.buyItems();

        verify(mainActivityView, times(1)).purchaseSuccessful();
    }

    @Test
    public void testPurchaseFailure() throws Exception {
        when(mainActivityView.getItemCode()).thenReturn("MB13");
        when(mainActivityView.getQuantity()).thenReturn(300);

        mainActivityPresenter.buyItems();

        verify(mainActivityView, times(1)).purchaseFailure();
    }

}
