package es.kr.applock.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import es.kr.applock.R;
import es.kr.applock.vo.AppLockItemVo;

public class AppLockAdaper extends RecyclerView.Adapter<AppLockAdaper.AppLockViewHolder> {

    int resource;
    private ArrayList<AppLockItemVo> voList;
    public class AppLockViewHolder extends RecyclerView.ViewHolder{
        protected ImageView imagAppIcon;
        protected TextView appName;
        protected ToggleButton togBtn;
        public AppLockViewHolder(View view){
            super(view);
            this.imagAppIcon = view.findViewById(R.id.imgAppIcon);
            this.appName = view.findViewById(R.id.txtViewAppName);
            this.togBtn = view.findViewById(R.id.tgBtnLockOnOff);
        }
    }

    public AppLockAdaper(int resource, ArrayList<AppLockItemVo> list){
        this.resource = resource;
        this.voList = list;
    }

    @NonNull
    @Override
    public AppLockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_list,parent,false);
        AppLockViewHolder viewHolder = new AppLockViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppLockViewHolder holder, int position) {
        AppLockItemVo vo = voList.get(position);
        holder.appName.setText(vo.getAppName());
        holder.imagAppIcon.setImageDrawable(vo.getIcon());
    }

    @Override
    public int getItemCount() {
        return voList.size();
    }


}
