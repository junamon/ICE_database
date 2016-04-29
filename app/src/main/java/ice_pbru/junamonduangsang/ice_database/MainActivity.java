package ice_pbru.junamonduangsang.ice_database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;
    private MySQLite mySQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //เริ่ม bind Widget
        bindWidget();

        mySQLite = new MySQLite(this);




}//Main Method

    public void clickSinIn(View view) {
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();


        if (checkSpace()) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this,"มีช่องว่าง","กรุณาตรวจสอบข้อมูล");

        }
        else {

        }

    }

    private boolean checkSpace() {
        return
        userString.equals("")||
        passwordString.equals("");
    }


    public void clickRegis(View view) {
        startActivity(new Intent(MainActivity.this, SignUp.class));

    }

    public void testMyAlert(View view) {
        MyAlert myAlert = new MyAlert();
        myAlert.myDialog(this,"Alert","ทดสอบ");
    }

    private void bindWidget() {
        userEditText = (EditText) findViewById(R.id.editText6);
        passwordEditText = (EditText) findViewById(R.id.editText7);


    }// จบ bind Widget


}//Main class
