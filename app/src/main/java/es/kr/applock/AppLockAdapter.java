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
        ImageView imgAppIcon = convertView.findViewById(R.id.imgAppIcon);
        TextView appName = (TextView) convertView.findViewById(R.id.textViewAppName);
        AppLockItemVo listViewItem = (AppLockItemVo) getItem(position);

        // 아이템 내 각 위젯에 데이터 반영
        imgAppIcon.setImageDrawable(listViewItem.getIconDrawable());
        appName.setText(listViewItem.getName());

        return convertView;
    }
}
