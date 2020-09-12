package com.practica.ui.home;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.practica.R;
import com.practica.data.model.User;
import com.practica.data.service.GetUsers;
import com.practica.ui.adapter.UsuariosAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Principal extends AppCompatActivity {

    private GridView gridView;
    private UsuariosAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_home);
        gridView = findViewById(R.id.gridViewHome);
        this.getListService(gridView);
    }

    private void getListService(final GridView gridView){

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetUsers getUsers = retrofit.create(GetUsers.class);
        Call<List<User>> call = getUsers.getServices();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> users = response.body();
                adapter = new UsuariosAdapter(Principal.this, users);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(Principal.this, "Fallo, verifica tu conexión a Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
