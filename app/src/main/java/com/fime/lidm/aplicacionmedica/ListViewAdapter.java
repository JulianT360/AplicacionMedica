package com.fime.lidm.aplicacionmedica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fime.lidm.aplicacionmedica.domain.entity.Patient;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    Context context;
    List<Patient> lstPatient;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, List<Patient> lstPatient) {
        this.context = context;
        this.lstPatient = lstPatient;
    }

    @Override
    public int getCount() {
        return lstPatient.size();
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

        //Se obtiene el layout del recurso.
        View itemView = inflater.inflate(R.layout.list_item_medical_app, parent, false);

        //Se actualiza el nombre del texto
        txtNombre = itemView.findViewById(R.id.txt_name_item);
        txtNombre.setText(lstPatient.get(position).getAllName());

        return itemView;
    }
}
