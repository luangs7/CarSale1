package br.com.luan.carsale;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.luan.carsale.R;
import br.com.luan.carsale.model.CarModel;

/**
 * Created by Dev_Maker on 28/04/2016.
 */
public class DescricaoActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView btnComprar;
    TextView txtModelo;
    TextView txtfabricante;
    TextView txtpreco;
    TextView txtcor;
    ImageView image;
    CarModel car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);
        btnComprar = (TextView) findViewById(R.id.precoButton);
        txtModelo = (TextView) findViewById(R.id.txtProduto);
        txtfabricante = (TextView) findViewById(R.id.txtfabricante);
        txtpreco = (TextView) findViewById(R.id.txtPreco);
        txtcor = (TextView) findViewById(R.id.txtCor);
        image = (ImageView) findViewById(R.id.imageView3);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle("Descrição");
            toolbar.setTitleTextColor(Color.parseColor("#ffffff"));

            setSupportActionBar(toolbar);
        }


        Intent it = getIntent();
        if (it != null) {
            Bundle bundle = it.getExtras();
            if (bundle != null) {
                car = (CarModel) it.getSerializableExtra("model");
                txtModelo.setText("Modelo: " + car.getModelo());
                image.setImageResource(car.getImagem());
                txtcor.setText("Cor: " + car.getCor());
                txtpreco.setText("Preço: R$" + car.getPrice());
                txtfabricante.setText("Fabricante: " + car.getFabricante());
            }
        }

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RelatorioActivity relatorioActivity = new RelatorioActivity();
                RelatorioActivity.comprados.add(car);
                Toast.makeText(DescricaoActivity.this,"Carro comprado com sucesso!",Toast.LENGTH_LONG).show();
            }
        });

    }
}