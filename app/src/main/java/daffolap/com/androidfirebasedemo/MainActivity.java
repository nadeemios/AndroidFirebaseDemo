package daffolap.com.androidfirebasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONException;
import org.json.JSONObject;

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
                    //loginPresenter.login("abc.efg@daffodilsw.com","123456");
                    getApiRes();
                }
            });
        }

    }

    private  void  createUser(String email,String password){


    }
 public  void  getApiRes(){
     // Request a string response

     String url = "https://api.spacexdata.com/v3/dragons/dragon2";


     JsonObjectRequest jsonRequest = new JsonObjectRequest
             (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                 @Override
                 public void onResponse(JSONObject response) {
                     // the response is already constructed as a JSONObject!
                     try {


                          Log.i("23", (String) response.get("name"));

//                         String site = response.getString("site"),
//                                 network = response.getString("network");
//                         System.out.println("Site: "+site+"\nNetwork: "+network);
                     } catch (JSONException e) {
                         e.printStackTrace();
                     }
                 }
             }, new Response.ErrorListener() {

                 @Override
                 public void onErrorResponse(VolleyError error) {
                     error.printStackTrace();
                 }
             });

     Volley.newRequestQueue(this).add(jsonRequest);


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
