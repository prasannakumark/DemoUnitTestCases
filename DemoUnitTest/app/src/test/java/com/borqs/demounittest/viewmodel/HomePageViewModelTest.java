package com.borqs.demounittest.viewmodel;

import com.borqs.demounittest.model.DataModelManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HomePageViewModelTest {

    @InjectMocks
    HomePageViewModel mHomePageViewModel;
    @Mock
    DataModelManager mDataModelManager;
    @Mock
    HomePageViewModel.CallBack mCallBack;

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