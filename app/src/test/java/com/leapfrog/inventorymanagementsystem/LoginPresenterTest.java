package com.leapfrog.inventorymanagementsystem;

import com.leapfrog.inventorymanagementsystem.presenters.LoginActivityPresenter;
import com.leapfrog.inventorymanagementsystem.contracts.LoginActivityContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    /**
     * loginActivityView is mocked because this is login presenter test and we do need to real instance
     * of loginActivityView. We can just mock the instance and use when().thenReturn() to get the
     * values dependent on the methods of loginActivityView
     */
    @Mock
    LoginActivityContract.Views loginActivityView;

    LoginActivityPresenter loginActivityPresenter;

    /**
     * initialise necessary variable and instances that are needed to run the test
     */
    @Before
    public void setUp(){
        loginActivityPresenter = new LoginActivityPresenter(loginActivityView);
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void userNameEmptyTest(){
        //this indicates test to return "" when loginActivityView is called
        when(loginActivityView.getUsername()).thenReturn("");
        when(loginActivityView.getPassword()).thenReturn("");

        loginActivityPresenter.login();

        //verify that setUserNameError is called at least once
        verify(loginActivityView).setUsernameError();
    }


    @Test
    public void passwordEmptyTest(){
        when(loginActivityView.getUsername()).thenReturn("Samsung");
        when(loginActivityView.getPassword()).thenReturn("");

        loginActivityPresenter.login();

        verify(loginActivityView).setPasswordError();
    }

    @Test
    public void credentialsInvalidTest(){
        when(loginActivityView.getUsername()).thenReturn("Samsung");
        when(loginActivityView.getPassword()).thenReturn("1234");

        loginActivityPresenter.login();

        verify(loginActivityView).loginFailure();
    }

    @Test
    public void loginSuccessTest(){
        when(loginActivityView.getUsername()).thenReturn("zeppelin");
        when(loginActivityView.getPassword()).thenReturn("asdf");

        loginActivityPresenter.login();

        verify(loginActivityView).loginSuccess();
    }

    @Test
    public void mockingSpy(){
        LoginActivityPresenter loginActivityPresenter1 = Mockito.spy(loginActivityPresenter);
        when(loginActivityPresenter1.checkConnection()).thenReturn(false);
        System.out.println(loginActivityPresenter1.checkConnection());
    }

}