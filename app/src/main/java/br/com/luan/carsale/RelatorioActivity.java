package br.com.luan.carsale;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

import br.com.luan.carsale.adapter.CarAdapter;
import br.com.luan.carsale.model.CarModel;

/**
 * Created by Dev_Maker on 28/04/2016.
 */
public class RelatorioActivity extends AppCompatActivity {

    public static ArrayList<CarModel> comprados = new ArrayList<CarModel>();
    CarAdapter adapter;
    ListView listViewComprados;
    int total;

    TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtTotal = (TextView) findViewById(R.id.txtTotal);

        if (toolbar != null) {
            toolbar.setTitle("Relatório");
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
            setSupportActionBar(toolbar);
        }

        listViewComprados = (ListView) findViewById(R.id.listCompras);
        adapter = new CarAdapter(this, comprados,2);
        listViewComprados.setAdapter(adapter);

        if (comprados.size() > 0) {
            for (CarModel car : comprados) {
                total += car.getPrice();
            }
            txtTotal.setText("R$ " + String.valueOf(total) + ",00");
        } else {
            Toast.makeText(this,"Nenhuma compra foi realizada até o momento",Toast.LENGTH_LONG).show();
            txtTotal.setText("R$ 00,00");
        }
    }
}
