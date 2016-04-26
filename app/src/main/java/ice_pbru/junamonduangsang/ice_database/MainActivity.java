package ice_pbru.junamonduangsang.ice_database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //Explicit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //เริ่ม bind Widget
        bindWidget();


}//Main Method

    public void clickRegis(View view) {
        startActivity(new Intent(MainActivity.this, SignUp.class));

    }

    public void testMyAlert(View view) {
        MyAlert myAlert = new MyAlert();
        myAlert.myDialog(this,"Alert","ทดสอบ");
    }

    private void bindWidget() {



    }// จบ bind Widget


}//Main class
