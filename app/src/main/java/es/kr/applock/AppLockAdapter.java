package es.kr.applock;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import es.kr.applock.R;
import es.kr.applock.vo.AppLockItemView;
import es.kr.applock.vo.AppLockItemVo;

public class AppLockAdapter extends ArrayAdapter {

    ArrayList<AppLockItemVo> items = new ArrayList<AppLockItemVo>();
    int resourceId;

    AppLockAdapter(Context context, int resource, ArrayList<AppLockItemVo> list) {
        super(context, resource, list);
        this.resourceId = resource;
        this.items = list;
    }

    @Override
    public int getCount() {
        return items.size();
    }
    public void addItem( AppLockItemVo item){
        items.add(item);
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("====================== MainActivity.getView() 호출 position["+position+"]======================");
        AppLockItemView view = null;
        final Context context = parent.getContext();
        if( convertView == null ){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId, parent, false);
        }
        final ImageView imgAppIcon = convertView.findViewById(R.id.imgAppIcon);
        final TextView appName = convertView.findViewById(R.id.textViewAppName);
        final ToggleButton togBtn = convertView.findViewById(R.id.togBtn);
        final AppLockItemVo item = (AppLockItemVo) getItem(position);

        // 아이템 내 각 위젯에 데이터 반영
        imgAppIcon.setImageDrawable(item.getIconDrawable());
        appName.setText(item.getName());

        togBtn.setTag(position);
        togBtn.setOnClickListener(new ToggleButton.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (togBtn.getText().equals("OFF")) {
                    System.out.println("toggleButton Yes =>" + item.getName());
                    togBtn.setText("OFF");

                } else {
                    System.out.println("toggleButton No" + item.getName());
                    togBtn.setText("ON");
                } // end if

            } // end onClick()
        });
        return convertView;
    }
}
