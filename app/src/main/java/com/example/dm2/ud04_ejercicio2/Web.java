package com.example.dm2.ud04_ejercicio2;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.widget.ImageView;

public class Web {

    Drawable img;
    String nombre,url;


    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }

    public Drawable getImg() {
        return img;
    }

    Web( Drawable i,String n, String u){
        img=i;
        nombre=n;
        url=u;

    }
}
