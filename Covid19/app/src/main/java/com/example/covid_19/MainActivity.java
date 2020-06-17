package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.covid_19.model.CountriesItem;
import com.example.covid_19.model.Response;
import com.example.covid_19.retrofit.RetrofitCOnfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    List<CountriesItem> datacovid=new ArrayList<>();
    RecyclerView recicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recicle=findViewById(R.id.recyclerView);

//        Model contoh=new Model();
//        contoh.setCountry("Indonesia");
//        contoh.setBaruSembuh("100");
//        contoh.setTotalSembuh("8900");
//        contoh.setKematianBaru("10");
//        contoh.setTotalMennggal("19800");
//        contoh.setKonfirmasiTebaru("10");
//        contoh.setTotalKonfirmasi("1889900");
//        contoh.setTanggal("22-11-2020");
//
//
//        for (int i = 0; i < 20; i++) {
//            datacovid.add(contoh);
//        }
        getDataOnline();

        recicle.setAdapter(new adaptercovid(MainActivity.this,datacovid));
        recicle.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }

    private void getDataOnline() {
        final ProgressDialog progress=new ProgressDialog(MainActivity.this);
        progress.setMessage("Tunggu Sebentar...");
        progress.show();
        Call<Response>request= RetrofitCOnfig.getApiservice().ambildata();
        request.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                    datacovid=response.body().getCountries();
                    recicle.setAdapter(new adaptercovid(MainActivity.this,datacovid));
                }else {
                    Toast.makeText(MainActivity.this, "Gagal Memuat", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ada kesalahan "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}