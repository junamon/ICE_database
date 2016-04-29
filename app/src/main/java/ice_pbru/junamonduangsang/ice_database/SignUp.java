package ice_pbru.junamonduangsang.ice_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SignUp extends AppCompatActivity {
    
    //Explicit
    private EditText nameEditText,surnameEditText,userEditText,passwordEditText, emailEditText;
    private String nameString,surnameString,userString,passwordString, emailString;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        
        //เริ่ม BindWidget
        bindWidget();
        
        
        
        
    }//Main method

    public void clickSignUp(View view) {
        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        emailString = emailEditText.getText().toString().trim();

        if (checkSpace()) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this,"มีช่องว่าง","กรุณาตรวจสอบข้อมูลและกรอกให้ครบถ้วน");

        }
        else {
            //No Space
            updateValueToServer();
        }


    }//clicksignup

    private void updateValueToServer() {

        String strURL = "http://ice.pbru.ac.th/ICE56/Junamon002/addData.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd","true")
                .add("Name",nameString)
                .add("Surname",surnameString)
                .add("User",userString)
                .add("Password",passwordString)
                .add("Email",emailString)
                .build();

        Request.Builder builder = new Request.Builder();
        Request request = builder.url(strURL).post(requestBody).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    finish();
                } catch (Exception e) {
                    Log.d("Junamon -->", "error" + e.toString());
                }

            }
        });


    }//updateValueToServer

    private boolean checkSpace() {
        return nameString.equals("")||
                surnameString.equals("")||
                userString.equals("")||
                passwordString.equals("")||
                emailString.equals("");
    }

    private void bindWidget() {
        
        nameEditText = (EditText) findViewById(R.id.editText);
        surnameEditText = (EditText) findViewById(R.id.editText2);
        userEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);
        emailEditText = (EditText) findViewById(R.id.editText5);
        
    }//จบ BindWidget 


}// Main Class
