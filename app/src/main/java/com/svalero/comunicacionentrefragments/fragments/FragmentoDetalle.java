package com.svalero.comunicacionentrefragments.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.svalero.comunicacionentrefragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoDetalle.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoDetalle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoDetalle extends android.support.v4.app.Fragment {

    private TextView txtDetalle;

    public static FragmentoDetalle newInstance(Bundle argumentos) {
        FragmentoDetalle fragment = new FragmentoDetalle();
        if (argumentos != null) {
            fragment.setArguments(argumentos);
        }
        return fragment;
    }

    public FragmentoDetalle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_fragmento_detalle, container, false);
        if (vista != null) {
            txtDetalle = (TextView) vista.findViewById(R.id.txtdescripcion);
        }
        return vista;


    }

    public void cambiarTexto(String texto) {
        txtDetalle.setText(texto);
    }


}
