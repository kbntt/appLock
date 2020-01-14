package es.kr.applock;

import androidx.appcompat.app.AppCompatActivity;
import es.kr.applock.com.DBOpenHelper;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DataBaseTestActivity extends AppCompatActivity {

    String selectTableName;
    DBOpenHelper mDbOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_test);

        Spinner spinnerTable = findViewById(R.id.spinnerTable);
        final String[] table = {"app_lock"};
        mDbOpenHelper = new DBOpenHelper(this);
        try {
            mDbOpenHelper.open();
        }catch (SQLException e){
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,table);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTable.setAdapter(adapter);
        spinnerTable.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectTableName = table[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void btnSelectTableOnClick(View view) {
        Toast.makeText(getApplicationContext(),"btnSelectTableOnClick",Toast.LENGTH_LONG).show();
    }

    public void btnCreateTableOnClick(View view) {
        Toast.makeText(getApplicationContext(),"btnCreateTableOnClick",Toast.LENGTH_LONG).show();
        boolean checkTable = mDbOpenHelper.selectTable(selectTableName);
        if(checkTable){
            Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_LONG).show();
        }
    }
}
