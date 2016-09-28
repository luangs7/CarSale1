package br.com.luan.carsale;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.luan.carsale.adapter.CarAdapter;
import br.com.luan.carsale.model.CarModel;

public class MasterView extends AppCompatActivity {

    ListView listViewCarros;
    CarAdapter adapter;
    ArrayList<CarModel> listaCarros = new ArrayList<CarModel>();
    CarModel cars;
    TextView btnrelatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("Master");
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

            setSupportActionBar(toolbar);
        }

        btnrelatorio = (TextView) findViewById(R.id.Btnrelatorio);
        listViewCarros = (ListView) findViewById(R.id.listCar);

//        (String modelo, String fabricante, String cor, String price, Integer imagem)
        listaCarros.add(new CarModel("Fiesta 2009", "Ford", "Vermelho vinho", 15000, R.drawable.fiesta));
        listaCarros.add(new CarModel("Fusca 1989", "Fiat", "Prata", 15000, R.drawable.fusca));
        listaCarros.add(new CarModel("Camaro 2015", "Ford","Amarelo",250000,R.drawable.camaro));
        listaCarros.add(new CarModel("Fiesta 2009", "Ford","Vermelho vinho",15000,R.drawable.fiesta));
        listaCarros.add(new CarModel("Punto 2009", "Fiat","Prata",25000,R.drawable.fanta));
        listaCarros.add(new CarModel("Camaro 2015", "Ford","Amarelo",250000,R.drawable.camaro));
        listaCarros.add(new CarModel("Fiesta 2009", "Ford","Vermelho vinho",15000,R.drawable.fiesta));
        listaCarros.add(new CarModel("Punto 2009", "Fiat","Prata",25000,R.drawable.fanta));
        listaCarros.add(new CarModel("Camaro 2015", "Ford","Amarelo",215000,R.drawable.camaro));

        adapter = new CarAdapter(this,listaCarros,1);
        listViewCarros.setAdapter(adapter);


        listViewCarros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cars = (CarModel) parent.getItemAtPosition(position);
                Intent intent = new Intent(MasterView.this, DescricaoActivity.class);
                intent.putExtra("model", cars);
                startActivity(intent);
            }
        });

        btnrelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MasterView.this, RelatorioActivity.class);
                startActivity(intent);
            }
        });
    }
}
