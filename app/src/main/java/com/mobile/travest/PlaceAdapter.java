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
 * Created by haimax on 11/12/17.
 */

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.placeViewHolder> {

    private ArrayList<Place> placeArrayList;
    private int numberOfItems;

    public PlaceAdapter(ArrayList<Place> placeArrayList) {
        this.placeArrayList = placeArrayList;
        numberOfItems = placeArrayList.size();
    }

    @Override
    public placeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_place_list_view, parent, false);
        placeViewHolder viewHolder = new placeViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(placeViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return numberOfItems;
    }

    class placeViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPlace;
        TextView tvPlaceName, tvPlaceLocation, tvPlacePrice;

        public placeViewHolder(View itemView) {
            super(itemView);

            imgPlace = (ImageView) itemView.findViewById(R.id.imgPlace);
            tvPlaceName = (TextView) itemView.findViewById(R.id.tvPlaceName);
            tvPlaceLocation = (TextView) itemView.findViewById(R.id.tvPlaceLocation);
            tvPlacePrice = (TextView) itemView.findViewById(R.id.tvPlacePrice);
        }

        void bind(int pos) {
            Place place = placeArrayList.get(pos);
            imgPlace.setImageResource(place.getImageID());
            tvPlaceName.setText(place.getName());
            tvPlaceLocation.setText(place.getLocation());
            String price = place.getPrice() + " points";
            tvPlacePrice.setText(price);
        }
    }
}
