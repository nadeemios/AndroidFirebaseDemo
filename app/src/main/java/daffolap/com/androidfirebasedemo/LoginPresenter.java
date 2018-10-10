package daffolap.com.androidfirebasedemo;

import com.google.firebase.auth.FirebaseUser;

public interface LoginPresenter {
    void  showLoading();
    void  hideLoading();
    void  loginSucceded(FirebaseUser user);
    void  loginFailed(String message);
}

