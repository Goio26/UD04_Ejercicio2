package com.example.dm2.ud04_ejercicio2;

import android.content.Context;
import android.content.Intent;
import android.drm.DrmStore;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Web[] webs=new Web[]{
                new Web(getDrawable(R.mipmap.ic_launcher_youtube2),"YouTube","https://www.youtube.com/"),
                new Web(getDrawable(R.mipmap.ic_launcher_face),"FaceBook","https://es-es.facebook.com/"),
                new Web(getDrawable(R.mipmap.ic_launcher_xataka),"Xataka","https://www.xataka.com/"),
                new Web(getDrawable(R.mipmap.ic_launcher_sensacine),"SensaCine","http://www.sensacine.com/")

        };


        AdaptadorWeb aw=new AdaptadorWeb(this,webs);
        lista=findViewById(R.id.listaWebs);
        lista.setAdapter(aw);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Web w= (Web)parent.getItemAtPosition(position);
               Uri uri=null;

                   uri=Uri.parse(webs[position].getUrl());


                Intent intento=new Intent(Intent.ACTION_VIEW,uri);
               startActivity(intento);
            }

        });






    }
}

    class AdaptadorWeb extends ArrayAdapter<Web> {

    private Web[] webs;

    AdaptadorWeb(Context contexto, Web[] webs) {
        super(contexto, R.layout.list_item, webs);
        this.webs = webs;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View vista = inflater.inflate(R.layout.list_item, null);

        ImageView img=vista.findViewById(R.id.imgWeb);
        img.setImageDrawable(webs[position].getImg());

        TextView nombre=vista.findViewById(R.id.NomWeb);
        nombre.setText(webs[position].getNombre());

        TextView url=vista.findViewById(R.id.UrlWeb);
        url.setText(webs[position].getUrl());



        return vista;
    }
}