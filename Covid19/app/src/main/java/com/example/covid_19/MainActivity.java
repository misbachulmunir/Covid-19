package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.SearchView;
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

    private static final String TAG = "MainActivity";
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
        Log.d(TAG, "data"+ R.id.id_baru_sembuh);
       getDataOnline();

        recicle.setAdapter(new adaptercovid(MainActivity.this,datacovid));
        recicle.setLayoutManager(new LinearLayoutManager(MainActivity.this));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_beranda,menu);
        MenuItem item=menu.findItem(R.id.id_cari);
//        SearchView searchView=(SearchView) item.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });


        return super.onCreateOptionsMenu(menu);
    }

    private void getDataOnline() {
        final ProgressDialog progress=new ProgressDialog(MainActivity.this);
        progress.setMessage("Tunggu Sebentar...");
        progress.show();
        Call<Response>request= RetrofitCOnfig.getApiservice().ambildata("");
        request.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                progress.dismiss();
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