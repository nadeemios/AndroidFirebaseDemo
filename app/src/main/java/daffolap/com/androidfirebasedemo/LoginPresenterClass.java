package daffolap.com.androidfirebasedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class LoginPresenterClass {
    private LoginPresenter view;
    private FirebaseAuth mAuth;
    public  LoginPresenterClass(LoginPresenter tview){
        view = tview;
    }

    public  void  login(String email,String password){

        mAuth = FirebaseAuth.getInstance();
        if(mAuth == null){
            view.loginFailed("Auth does not found!");
            return;
        }
mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()) {
            // Sign in success, update UI with the signed-in user's information
            FirebaseUser user = mAuth.getCurrentUser();
            view.loginSucceded(user);

        } else {
            // If sign in fails, display a message to the user.
           view.loginFailed("Login has failed?");
        }
    }
});
    }
}
