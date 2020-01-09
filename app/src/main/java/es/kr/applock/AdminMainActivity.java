package es.kr.applock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AdminMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
    }

    public void btnAdminSetOnClick(View view) {
        Toast.makeText(getApplicationContext(),"btnAdminSetOnClick",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),AdminSetActivity.class);
        startActivityForResult(intent,100);
    }

    public void btnAppLockSetOnClick(View view) {
        Toast.makeText(getApplicationContext(),"btnAppLockSetOnClick",Toast.LENGTH_LONG).show();
    }

    public void btnAppLockOnOffOnClick(View view) {
        Toast.makeText(getApplicationContext(),"btnAppLockOnOffOnClick",Toast.LENGTH_LONG).show();
    }
}
