package es.kr.applock;

import androidx.appcompat.app.AppCompatActivity;
import es.kr.applock.vo.AppLockItemVo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class AppLockActivity extends AppCompatActivity {

    ListView listView;
    AppLockAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_lock);
        listView = findViewById(R.id.appLockListView);

        ArrayList<AppLockItemVo> items = getAppList();

        adapter = new AppLockAdapter(this, R.layout.activity_app_lock_list, items);
        // 리스트뷰 참조 및 Adapter달기
        ListView listview = (ListView) findViewById(R.id.appLockListView);
        listview.setAdapter(adapter);
    }
    /*
     * Created by wind rider on 2020-01-09.
     * DB 저장된 LOCK APP 조회
     */
    public ArrayList<AppLockItemVo> getAppList() {
        AppLockItemVo item ;
        ArrayList<AppLockItemVo> list= new ArrayList<AppLockItemVo>() ;

        PackageManager packageManager = getApplicationContext().getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> AppInfos = packageManager.queryIntentActivities(intent, 0);

        for (ResolveInfo info : AppInfos) {
            ActivityInfo ai = info.activityInfo;
            try {
                Button toggleButton = new Button(this);
                item = new AppLockItemVo() ;
                item.setIconDrawable( getApplicationContext().getPackageManager().getApplicationIcon(ai.packageName)); ;
                item.setName(ai.loadLabel(packageManager).toString());
                item.setToggleButton(toggleButton);
                list.add(item) ;
            }
            catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return list ;
    }
}
