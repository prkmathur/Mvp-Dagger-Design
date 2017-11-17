package com.nh.themvpdesign.adapters;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nh.themvpdesign.BR;
import com.nh.themvpdesign.databinding.AdapterItemWeatherInfoBinding;
import com.nh.themvpdesign.models.ConsolidatedWeather;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by dell pc on 17-11-2017.
 */
public class WeatherInfoAdapter extends RecyclerView.Adapter<WeatherInfoAdapter.ViewHolder> {

    private final Context context;

    private ArrayList<ConsolidatedWeather> consolidatedWeathers;

    @Inject
    public WeatherInfoAdapter(Context context) {
        this.context = context;
        consolidatedWeathers = new ArrayList<>();
    }

    public void setData(ArrayList<ConsolidatedWeather> data){
        consolidatedWeathers = data;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        AdapterItemWeatherInfoBinding itemBinding =
                AdapterItemWeatherInfoBinding.inflate(layoutInflater, parent, false);

        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ConsolidatedWeather item = consolidatedWeathers.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return consolidatedWeathers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(ConsolidatedWeather consolidatedWeather){
            binding.setVariable(BR.weather, consolidatedWeather);
            binding.executePendingBindings();
        }
    }

}
