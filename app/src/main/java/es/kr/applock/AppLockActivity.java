package es.kr.applock;

import androidx.appcompat.app.AppCompatActivity;
import es.kr.applock.vo.AppLockItemVo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class AppLockActivity extends AppCompatActivity {

    ListView listView;
    AppLockAdapter adapter;
    ArrayList<AppLockItemVo> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_lock);
        listView = findViewById(R.id.appLockListView);

        AppLockItemVo item = new AppLockItemVo() ;
        item.setName("name1");
        Drawable drawable = getResources().getDrawable(R.drawable.if_little_girl_pink);
        item.setIconDrawable(drawable);
        items.add(item) ;

        AppLockItemVo item1 = new AppLockItemVo() ;
        item1.setName("name2");
        item1.setIconDrawable(drawable);
        items.add(item1) ;

        adapter = new AppLockAdapter(this, R.layout.activity_app_lock_list, items);
        // 리스트뷰 참조 및 Adapter달기
        ListView listview = (ListView) findViewById(R.id.appLockListView);
        listview.setAdapter(adapter);
    }
}
