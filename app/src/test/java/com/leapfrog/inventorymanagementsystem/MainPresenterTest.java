package com.leapfrog.inventorymanagementsystem;

import com.leapfrog.inventorymanagementsystem.presenters.MainActivityPresenter;
import com.leapfrog.inventorymanagementsystem.views.MainActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Manas on 3/8/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {




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
