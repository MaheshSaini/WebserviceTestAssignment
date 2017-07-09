package mahesh.webservice.com.webservicetestassignment.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mahesh.webservice.com.webservicetestassignment.R;
import mahesh.webservice.com.webservicetestassignment.activity.network.model.CountryRestResponse;


public class CityRecyclerAdapter extends RecyclerView.Adapter<CityRecyclerAdapter.MyViewHolder> {

    private List<CountryRestResponse.Result> listItems, filterList;
    public Context mContext;
    private ItemClickListener clickListener;
    public CityRecyclerAdapter(Context context, List<CountryRestResponse.Result> listItems) {
        this.listItems = listItems;
        this.mContext = context;
        this.filterList = new ArrayList<CountryRestResponse.Result>();
        // we copy the original list to the filter list and use it for setting row values
        this.filterList.addAll(this.listItems);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_search_row, null);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder customViewHolder, int position) {
        CountryRestResponse.Result cityResult =filterList.get(position);
        customViewHolder.txtCityName.setText(cityResult.getName());
//        customViewHolder.imgThumb.setBackgroundResource(listItem.logo);

    }

    public void addData(List<CountryRestResponse.Result> popularSpecialtiyList){
        this.filterList.clear();
        this.filterList.addAll(popularSpecialtiyList);
    }
    @Override
    public int getItemCount() {
        return (null != filterList ? filterList.size() : 0);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    // initializes some private fields to be used by RecyclerView.
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView txtCityName;
        public MyViewHolder(View itemView) {
            super(itemView);
            txtCityName = (TextView) itemView.findViewById(R.id.txtCityName);
             itemView.setTag(itemView);
             itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
    public void filter(final String text) {

        // Searching could be complex..so we will dispatch it to a different thread...
        new Thread(new Runnable() {
            @Override
            public void run() {

                // Clear the filter list
                filterList.clear();

                // If there is no search value, then add all original list items to filter list
                if (TextUtils.isEmpty(text)) {
                    filterList.addAll(listItems);
                } else {
                    // Iterate in the original List and add it to filter list...
                    for (CountryRestResponse.Result item : listItems) {
                        if (item.getName().toLowerCase().contains(text.toLowerCase().trim())) {
                            // Adding Matched items
                            filterList.add(item);
                        }
                    }
                }

                // Set on UI Thread
                ((Activity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Notify the List that the DataSet has changed...
                        notifyDataSetChanged();
                    }
                });

            }
        }).start();

    }

}
