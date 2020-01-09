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
    public static final int PERMISSION_REQUEST_SEND_SMS = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_set);
        checkPermission();
    }

    private void checkPermission() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED){
            if(!ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},PERMISSION_REQUEST_SEND_SMS);
            }
        }
    }

    public void btnSendOnClick(View view) {
        try {
            Toast.makeText(getApplicationContext(),"btnSendOnClick",Toast.LENGTH_LONG).show();
            EditText adminPhoneNumber = findViewById(R.id.edTxtAdminPhoneNumber);
            EditText adminPassWord = findViewById(R.id.edTxtAdminPassWord);
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(adminPhoneNumber.getText().toString(),null,adminPassWord.getText().toString(),null,null);
            Toast.makeText(getApplicationContext(),"전송 성공",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"전송 실패",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
