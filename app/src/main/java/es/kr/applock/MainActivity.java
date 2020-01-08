package es.kr.applock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAdminOnClick(View view) {
        Toast.makeText(getApplicationContext(),"btnAdminOnClick",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(),AdminMainActivity.class);
        startActivityForResult(intent,100);
    }

    public void btnUserOnClick(View view) {
        Toast.makeText(getApplicationContext(),"btnUserOnClick",Toast.LENGTH_LONG).show();

    }
}
