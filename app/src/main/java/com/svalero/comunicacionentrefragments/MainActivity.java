package com.svalero.comunicacionentrefragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.svalero.comunicacionentrefragments.beans.Persona;
import com.svalero.comunicacionentrefragments.fragments.FragmentoDetalle;
import com.svalero.comunicacionentrefragments.fragments.FragmentoFoto;
import com.svalero.comunicacionentrefragments.fragments.FragmentoLista;


public class MainActivity extends FragmentActivity implements FragmentoLista.OnPersonaSeleccionada {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Recibe el objeto persona que ha sido seleccionado en la lista
     *
     * @param persona Los datos de la persona en concreto
     */
    @Override
    public void OnPersonaSelect(Persona persona) {
        FragmentoFoto fFoto = (FragmentoFoto) getSupportFragmentManager().findFragmentById(R.id.fragmentoFoto);
        fFoto.cambiarFoto(asignarFoto(persona));
        FragmentoDetalle fDetalles = (FragmentoDetalle) getSupportFragmentManager().findFragmentById(R.id.fragmentoFoto);
        fDetalles.cambiarTexto(persona.getDescripcion());

    }

    private Drawable asignarFoto(Persona persona) {
        Drawable fotoSeleccionada = null;

        /*
        Las imágenes se solicitarán al servidor
        AsyncTask y demás.
         */
        if (persona.getNombre().equals("LUIS")) {
            fotoSeleccionada = getResources().getDrawable(R.drawable.iconoperfilazul);
        } else if (persona.getNombre().equals("ANA")) {
            fotoSeleccionada = getResources().getDrawable(R.drawable.perfil);


        } else if (persona.getNombre().equals("SARA")) {
            fotoSeleccionada = getResources().getDrawable(R.drawable.perfil2);
        } else if (persona.getNombre().equals("PEPE")) {
            fotoSeleccionada = getResources().getDrawable(R.drawable.perfil3);
        }

        return fotoSeleccionada;
    }
}
