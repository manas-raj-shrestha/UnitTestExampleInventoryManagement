package com.leapfrog.inventorymanagementsystem;

import com.leapfrog.inventorymanagementsystem.presenters.LoginActivityPresenter;
import com.leapfrog.inventorymanagementsystem.views.LoginActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ManasShrestha on 2/2/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginActivityPresenterTest {

    /**
     * loginActivityView is mocked because this is login presenter test and we do need to real instance
     * of loginActivityView. We can just mock the instance and use when().thenReturn() to get the
     * values dependent on the methods of loginActivityView
     */
    @Mock
    LoginActivityView loginActivityView;

    LoginActivityPresenter loginActivityPresenter;

    /**
     * initialise necessary variable and instances that are needed to run the test
     */
    @Before
    public void setUp(){
        loginActivityPresenter = new LoginActivityPresenter(loginActivityView);
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
    public void correctUserNameTest(){
        when(loginActivityView.getUsername()).thenReturn("zeppelin");

//        verify(loginActivityView).getUsername(eq("zeppelin"));
    }


}
