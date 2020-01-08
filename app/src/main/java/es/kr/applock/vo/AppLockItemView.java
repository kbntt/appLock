package es.kr.applock.vo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import es.kr.applock.R;

public class AppLockItemView extends LinearLayout {

    ImageView imgAppIcon;
    TextView appName;
    ToggleButton isUse;


    public AppLockItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_app_lock_list, this,true);

        appName  = findViewById(R.id.textViewAppName);
        imgAppIcon = (ImageView) findViewById(R.id.imgAppIcon);
    }

    public ImageView getImgAppIcon() {
        return imgAppIcon;
    }

    public void setImgAppIcon(ImageView imgAppIcon) {
        this.imgAppIcon = imgAppIcon;
    }

    public TextView getAppName() {
        return appName;
    }

    public void setAppName(TextView appName) {
        this.appName = appName;
    }

    public ToggleButton getIsUse() {
        return isUse;
    }

    public void setIsUse(ToggleButton isUse) {
        this.isUse = isUse;
    }

    public AppLockItemView(Context context) {
        super(context);
        init(context);
    }
}
