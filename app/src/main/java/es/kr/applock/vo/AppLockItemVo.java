package es.kr.applock.vo;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.ToggleButton;

public class AppLockItemVo {
    private Drawable icon;
    private String appName;
    private String packageName;
    private ToggleButton togBtn;

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Button getTogBtn() {
        return togBtn;
    }

    public void setTogBtn(ToggleButton togBtn) {
        this.togBtn = togBtn;
    }

}
