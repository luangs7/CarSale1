package br.com.luan.carsale.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.luan.carsale.R;
import br.com.luan.carsale.model.CarModel;

/**
 * Created by Dev_Maker on 27/04/2016.
 */
public class CarAdapter extends BaseAdapter{

    private ArrayList<CarModel> objects;
    private Context context;
    int tipo;

    public CarAdapter(Context context, ArrayList<CarModel> objects,int tipo) {
        this.objects = objects;
        this.context = context;
        this.tipo = tipo;
    }




    public View getView(int position, View convertView, ViewGroup parent){

        // assign the view we are converting to a local variable
        View v = convertView;

        // first check to see if the view is null. if so, we have to inflate it.
        // to inflate it basically means to render, or show, the view.
        ViewHolder vh;
        if (v == null) {
            vh = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.adapter_car, null);

            vh.nome = (TextView) v.findViewById(R.id.txtName);
            vh.image = (ImageView) v.findViewById(R.id.imageCar);
            vh.price = (TextView) v.findViewById(R.id.txtPrice);

            v.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

		/*
		 * Recall that the variable position is sent in as an argument to this method.
		 * The variable simply refers to the position of the current object in the list. (The ArrayAdapter
		 * iterates through the list we sent it)
		 *
		 * Therefore, i refers to the current Item object.
		 */
        final CarModel carModel = objects.get(position);
        vh.nome.setText(carModel.getModelo());
        vh.price.setText("R$" + String.valueOf(carModel.getPrice()) + ",00");
        vh.image.setImageResource(carModel.getImagem());

        if(this.tipo == 2){
            vh.price.setVisibility(View.GONE);
            vh.image.setVisibility(View.GONE);
        }
        // the view must be returned to our activity
        return v;

    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public CarModel getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        public TextView nome;
        public ImageView image;
        public TextView price;
    }

}
