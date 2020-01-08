package es.kr.applock.vo;

import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.Switch;

public class AppLockItemVo {

    private Drawable iconDrawable ;
    private String name ;
    private String packageName ;
    private boolean isUse ;
    private Button toggleButton;

    public Drawable getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    public Button getToggleButton() {
        return toggleButton;
    }

    public void setToggleButton(Button toggleButton) {
        this.toggleButton = toggleButton;
    }

}
