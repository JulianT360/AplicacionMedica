package com.fime.lidm.aplicacionmedica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    List<String> nombres;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, List<String> nombres) {
        this.context = context;
        this.nombres = nombres;
    }

    @Override
    public int getCount() {
        return nombres.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView txtNombre;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_item_medical_app, parent, false);

        txtNombre = (TextView) itemView.findViewById(R.id.txt_name_item);

        txtNombre.setText(nombres.get(position));

        return itemView;
    }
}
