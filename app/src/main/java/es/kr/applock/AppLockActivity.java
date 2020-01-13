package es.kr.applock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import es.kr.applock.adapter.AppLockAdaper;
import es.kr.applock.vo.AppLockItemVo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class AppLockActivity extends AppCompatActivity {
    private ToggleButton togBtn ;
    private AppLockAdaper adaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_lock);
        RecyclerView recyclerView = findViewById(R.id.appListView);
        togBtn = findViewById(R.id.tgBtnLockOnOff);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<AppLockItemVo> appLockList = loadItems();
        adaper = new AppLockAdaper(R.layout.app_list,appLockList);
        recyclerView.setAdapter(adaper);
    }

    public ArrayList<AppLockItemVo> loadItems(){

        ArrayList<AppLockItemVo> list = new ArrayList<AppLockItemVo>();
        AppLockItemVo item;
        PackageManager packageManager = getApplicationContext().getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> AppInfos = packageManager.queryIntentActivities(intent,0);
        for( ResolveInfo info : AppInfos){
            ActivityInfo ai = info.activityInfo;
            try {
                item = new AppLockItemVo();
                item.setIcon(getApplicationContext().getPackageManager().getApplicationIcon(ai.packageName));
                item.setAppName(ai.loadLabel(packageManager).toString());
                list.add(item);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
}
