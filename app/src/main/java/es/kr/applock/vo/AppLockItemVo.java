package es.kr.applock.vo;

import android.graphics.drawable.Drawable;
import android.widget.Switch;

public class AppLockItemVo {
    private Drawable icon;
    private String appName;
    private String packageName;
    private Switch switchBtn;

    public Switch getSwitchBtn() {
        return switchBtn;
    }

    public void setSwitchBtn(Switch switchBtn) {
        this.switchBtn = switchBtn;
    }

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


}
