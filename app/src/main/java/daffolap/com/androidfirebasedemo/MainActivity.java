package daffolap.com.androidfirebasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements LoginPresenter {

    private  LoginPresenterClass loginPresenter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new  LoginPresenterClass(this);

        Button btn = (Button) findViewById(R.id.btnLogin);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loginPresenter.login("abc.efg@daffodilsw.com","123456");
                }
            });
        }

    }

    private  void  createUser(String email,String password){


    }

    private  void  signOut(){
        FirebaseAuth.getInstance().signOut();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void loginSucceded(FirebaseUser user) {
        Toast.makeText(getApplicationContext(),user.getEmail(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
