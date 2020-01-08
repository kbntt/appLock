package es.kr.applock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminSetActivity extends AppCompatActivity {

    public static final int PERMISSIONS_REQUEST_SEND_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_set);
        checkPermission();
    }

    public void sendOnClick(View view) {
        try{
            Toast.makeText(getApplicationContext(),"전송",Toast.LENGTH_LONG).show();
            EditText adminPhoneNumber = findViewById(R.id.EditTextAdminPhoneNumber) ;
            EditText adminUsePassword = findViewById(R.id.EditTextAdminUsePassword) ;
            SmsManager sms = SmsManager.getDefault();
            System.out.println("================>"+adminPhoneNumber.getText().toString());
            System.out.println("================>"+adminUsePassword.getText().toString());
            sms.sendTextMessage(adminPhoneNumber.getText().toString(),null,adminUsePassword.getText().toString(),null,null);
            Toast.makeText(getApplicationContext(),"전송하였습니다",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"전송 실패",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }

    private void checkPermission(){

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED){

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},PERMISSIONS_REQUEST_SEND_SMS);
            }
        }

    }
}
