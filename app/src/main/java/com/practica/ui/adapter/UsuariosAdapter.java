package com.practica.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.practica.R;
import com.practica.data.model.User;
import com.practica.ui.fragment.DetalleFragment;

import java.util.List;

public class UsuariosAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<User> users;
    public String name;
    public String details;

    static class ViewHolderUser{
        LinearLayout linearLayout;
        TextView textName;
        TextView textCity;
        TextView textCompany;
    }


    public UsuariosAdapter(Context context, List<User> users){
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
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
    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolderUser viewHolderUser;

        if(convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_users, parent, false);
            viewHolderUser = new ViewHolderUser();
            viewHolderUser.linearLayout = convertView.findViewById(R.id.linearLayoutHome);
            viewHolderUser.textName = convertView.findViewById(R.id.name);
            viewHolderUser.textCity = convertView.findViewById(R.id.city);
            viewHolderUser.textCompany = convertView.findViewById(R.id.company);
            convertView.setTag(viewHolderUser);
        } else {
            viewHolderUser = (ViewHolderUser) convertView.getTag();
        }

        User user = users.get(position);
        viewHolderUser.textName.setText("Nombre: "+user.getName());
        viewHolderUser.textCity.setText("Ciudad: "+user.getAddress().getCity());
        viewHolderUser.textCompany.setText("Compañia: "+user.getCompany().getName());

        viewHolderUser.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = (String) viewHolderUser.textName.getText();
                details = user.getStringUser();
                Toast.makeText(context, "Resultado: "+details, Toast.LENGTH_SHORT).show();
                Bundle arguments = new Bundle();
                arguments.putString("name", name);
                arguments.putString("details", details);
                DetalleFragment fragment = new DetalleFragment();
                fragment.setArguments(arguments);
                FragmentTransaction fm = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                fm.replace(android.R.id.content, fragment, DetalleFragment.TAG);
                fm.commit();


            }
        });

        return convertView;
    }
}
