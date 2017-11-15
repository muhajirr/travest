package com.mobile.travest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by haimax on 11/16/17.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.appViewHolder> {

    private ArrayList<App> appArrayList;
    private int numberOfItems;

    public AppAdapter(ArrayList<App> appArrayList) {
        this.appArrayList = appArrayList;
        numberOfItems = appArrayList.size();
    }

    @Override
    public appViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_app_list_view, parent, false);
        appViewHolder viewHolder = new appViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(appViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class appViewHolder extends RecyclerView.ViewHolder {

        ImageView imgApp;
        TextView tvAppName;

        public appViewHolder(View itemView) {
            super(itemView);

            imgApp = (ImageView) itemView.findViewById(R.id.imgApp);
            tvAppName = (TextView) itemView.findViewById(R.id.nameApp);
        }

        void bind(int pos) {
            App app = appArrayList.get(pos);
            imgApp.setImageResource(app.getImgID());
            tvAppName.setText(app.getName());
        }
    }
}
