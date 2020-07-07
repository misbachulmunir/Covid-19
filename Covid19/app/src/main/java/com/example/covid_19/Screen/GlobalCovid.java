package com.example.covid_19.Screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_19.BerandaActivity;
import com.example.covid_19.MainActivity;
import com.example.covid_19.R;
import com.example.covid_19.adaptercovid;
import com.example.covid_19.model.CountriesItem;
import com.example.covid_19.model.Global;
import com.example.covid_19.model.Response;
import com.example.covid_19.retrofit.RetrofitCOnfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class GlobalCovid extends AppCompatActivity {
    Global dunia=new Global();
    List<CountriesItem>indo=new ArrayList<>();
    String id;
    String date;
CardView carddunia,cardindo;
TextView txtkonfbaru,txttotalkonf,txtbarusembh,txttotalsembuh,txttotalkematian,txtkematianbaru,datedunia,dateindo;
TextView indokonfbaru,indototkon,indototsembuh,indobarusembuh,indokematianbaru,indototalkematian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_covid);

        //inisaialisasi dunia
        carddunia=findViewById(R.id.id_card_dunia);
        txtkonfbaru=findViewById(R.id.id_konfirmasi_baru_dunia);
        txttotalkonf=findViewById(R.id.id_total_konfirmasi_dunia);
        txttotalkematian=findViewById(R.id.id_total_kematian_dunia);
        txtbarusembh=findViewById(R.id.id_baru_Sembuuh_dunia);
        txttotalsembuh=findViewById(R.id.id_total_sembuh_dunia);
        txtkematianbaru=findViewById(R.id.id_kematian_baru_dunia);
        datedunia=findViewById(R.id.id_tanggal);
        dateindo=findViewById(R.id.id_tanggal_dunia);

        //inisialisasi indo
        indokonfbaru=findViewById(R.id.id_konfirmasi_baru_indo);
        indototkon=findViewById(R.id.id_total_konfirmasi_indo);
        indototsembuh=findViewById(R.id.id_total_sembuh_indo);
        indobarusembuh=findViewById(R.id.id_baru_Sembuuh_indo);
        indokematianbaru=findViewById(R.id.id_kematian_baru_indo);
        indototalkematian=findViewById(R.id.id_total_kematian_indo);


        //txtkonfbaru.setText(String.valueOf(dataglobal.get(3)));
        carddunia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GlobalCovid.this, MainActivity.class));
            }
        });

        getDataOnline();
        getIDindo();



        }

        private  void getIDindo(){



        }
    private void getDataOnline(){
        final ProgressDialog progress=new ProgressDialog(GlobalCovid.this);
        progress.setMessage("Tunggu Sebentar...");
        progress.show();
        Call<Response> request= RetrofitCOnfig.getApiservice().ambildata("");
        request.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()){
                    dunia= response.body().getGlobal();
                    date=response.body().getDate();
                    indo=response.body().getCountries();

                    //ini untuk dunia
                    String konfirmasibarudunia= String.valueOf(dunia.getNewConfirmed());
                    String totkonfirmasidunia= String.valueOf(dunia.getTotalConfirmed());
                    String totkematiandunia= String.valueOf(dunia.getTotalDeaths());
                    String barusembuhdunia= String.valueOf(dunia.getNewRecovered());
                    String totalsembuhdunia= String.valueOf(dunia.getTotalRecovered());
                    String kematianbaruduna= String.valueOf(dunia.getNewDeaths());

                    //ini untuk indonesia
                    String konfbaruindo= String.valueOf(indo.get(77).getNewConfirmed());
                    String totalkonindo= String.valueOf(indo.get(77).getTotalConfirmed());
                    String totsembuhindo= String.valueOf(indo.get(77).getTotalRecovered());
                    String barusembuhindo= String.valueOf(indo.get(77).getNewRecovered());
                    String barumatiindo= String.valueOf(indo.get(77).getNewDeaths());
                    String totalkematianindo= String.valueOf(indo.get(77).getTotalDeaths());
                    String dateindonya= String.valueOf(indo.get(77).getDate());

                    //set untuk dunia
                    txtkonfbaru.setText(konfirmasibarudunia);
                    txttotalkonf.setText(totkonfirmasidunia);
                    txttotalkematian.setText(totkematiandunia);
                    txtbarusembh.setText(barusembuhdunia);
                    txttotalsembuh.setText(totalsembuhdunia);
                    txtkematianbaru.setText(kematianbaruduna);
                    datedunia.setText(date.toLowerCase());


                    //set untuk indonesia
                    indokonfbaru.setText(konfbaruindo);
                    indototkon.setText(totalkonindo);
                    indototsembuh.setText(totsembuhindo);
                    indobarusembuh.setText(barusembuhindo);
                    indokematianbaru.setText(barumatiindo);
                    indototalkematian.setText(totalkematianindo);
                    dateindo.setText(dateindonya.toLowerCase());
                    progress.dismiss();
                }else {
                    Toast.makeText(GlobalCovid.this, "Gagal Memuat", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(GlobalCovid.this, "Ada kesalahan "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });





    }
}