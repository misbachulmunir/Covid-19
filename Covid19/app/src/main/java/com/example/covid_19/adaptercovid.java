package com.example.covid_19;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.model.CountriesItem;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class adaptercovid extends RecyclerView.Adapter<adaptercovid.MyVieHolder>  {
    private static final String TAG = "adaptercovid";
    public static final String DATA_CORONA = "data_corona_country";
    public static final String DATA_EXTRA = "data_extra_country";
    public Context context;

    public adaptercovid(Context context, List<CountriesItem> data) {
        this.context = context;
        this.data = data;
    }

    public List<CountriesItem>data=new ArrayList<>();

    @NonNull
    @Override
    public MyVieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.item_country,parent,false);
        return new MyVieHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVieHolder holder, final int position) {
    holder.txtcountry.setText(data.get(position).getCountry());
    holder.txtbarusembuh.setText(String.valueOf(data.get(position).getNewRecovered()));
    holder.txttotalsembuh.setText(String.valueOf(data.get(position).getTotalRecovered()));
    holder.txtkematianbaru.setText(String.valueOf(data.get(position).getNewDeaths()));
    holder.txttotalmeninggal.setText(String.valueOf(data.get(position).getTotalDeaths()));
    holder.txtkonfirmasiterbaru.setText(String.valueOf(data.get(position).getNewConfirmed()));
    holder.txttotalkonfirmasi.setText(String.valueOf(data.get(position).getTotalConfirmed()));
    holder.txtanggal.setText(data.get(position).getDate());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent pindah=new Intent(context, DetailActifity.class);
            Bundle bundle=new Bundle();
            bundle.putParcelable(DATA_CORONA, Parcels.wrap(data.get(position)));
            pindah.putExtra(DATA_EXTRA,bundle);
            context.startActivity(pindah);

            Log.d(TAG, "Posisi"+position);

        }
    });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
//    //untuk pencarian
//    @Override
//    public Filter getFilter() {
//        return filter;
//    }
//    Filter filter =new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//             List<CountriesItem> filteredlist=new ArrayList<>();
//             if(constraint.toString().isEmpty()){
//                 filteredlist.addAll(data);
//             }else {
//                 for (String covid:data){
//
//                 }
//             }
//
//             return null;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//
//        }
//    };




    public class MyVieHolder extends RecyclerView.ViewHolder {
           TextView txtcountry;
           TextView txtkonfirmasiterbaru;
           TextView txttotalkonfirmasi;
           TextView txtkematianbaru;
           TextView txttotalmeninggal;
           TextView txtbarusembuh;
           TextView txttotalsembuh;
           TextView txtanggal;

            public MyVieHolder(@NonNull View itemView) {
            super(itemView);
            txtcountry=itemView.findViewById(R.id.id_country);
            txtbarusembuh=itemView.findViewById(R.id.id_baru_sembuh);
            txttotalsembuh=itemView.findViewById(R.id.id_total_sembuh);
            txtkematianbaru=itemView.findViewById(R.id.id_kematian_terbaru);
            txttotalmeninggal=itemView.findViewById(R.id.id_total_meninggal);
            txtkonfirmasiterbaru=itemView.findViewById(R.id.id_konfirmasi_terbaru);
            txttotalkonfirmasi=itemView.findViewById(R.id.id_total_konfirmasi);
            txtanggal=itemView.findViewById(R.id.id_tanggal);

        }
    }
}
