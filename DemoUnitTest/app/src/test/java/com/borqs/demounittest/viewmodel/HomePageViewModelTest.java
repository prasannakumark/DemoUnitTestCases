package com.borqs.demounittest.viewmodel;

import com.borqs.demounittest.model.DataModelManager;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomePageViewModelTest {

    /** This is the class whose real code I want to test */
    @InjectMocks
    HomePageViewModel mHomePageViewModel;
    @Mock
    DataModelManager mDataModelManager;
    @Mock
    HomePageViewModel.CallBack mCallBack;

    @Captor
    ArgumentCaptor<String> captor;

    @Test
    public void shouldNotCallStartLoginActivityMethodWhenUserLoggedIn() {
        when(mDataModelManager.isUserLoggedIn()).thenReturn(true);
        mHomePageViewModel.isUserLogedIn();

        verify(mCallBack,atLeast(0)).startLoginActivity();
    }

    @Test
    public void shouldGotoLoginActivityWhenUserNotLoggedIn() {
        mHomePageViewModel.setCallBacks(mCallBack);
        mHomePageViewModel.isUserLogedIn();

        verify(mCallBack,atLeast(1)).startLoginActivity();
    }


    @Test(expected = IllegalStateException.class)
    public void shouldThrowAnExceptionWhencallBackIsNull() {
        mHomePageViewModel.isUserLogedIn();
    }
}