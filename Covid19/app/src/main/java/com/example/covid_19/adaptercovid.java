package com.example.covid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid_19.model.CountriesItem;
import com.example.covid_19.model.Response;

import java.util.ArrayList;
import java.util.List;

public class adaptercovid extends RecyclerView.Adapter<adaptercovid.MyVieHolder> {
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
    public void onBindViewHolder(@NonNull MyVieHolder holder, int position) {
    holder.txtcountry.setText(data.get(position).getCountry());
    holder.txtbarusembuh.setText(data.get(position).getNewRecovered());
    holder.txttotalsembuh.setText(data.get(position).getTotalRecovered());
    holder.txtkematianbaru.setText(data.get(position).getNewDeaths());
    holder.txttotalmeninggal.setText(data.get(position).getTotalDeaths());
    holder.txtkonfirmasiterbaru.setText(data.get(position).getNewConfirmed());
    holder.txttotalkonfirmasi.setText(data.get(position).getTotalConfirmed());
    holder.txtanggal.setText(data.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

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
