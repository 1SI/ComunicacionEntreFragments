package com.svalero.comunicacionentrefragments.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.svalero.comunicacionentrefragments.R;

public class FragmentoFoto extends Fragment {

    private ImageView imgFoto;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentoFoto.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoFoto newInstance(Bundle argumentos) {
        FragmentoFoto fragment = new FragmentoFoto();
        if (argumentos != null) {
            fragment.setArguments(argumentos);
        }

        return fragment;
    }

    public FragmentoFoto() {
        // Required empty public constructor
    }

    public void cambiarFoto(Drawable foto) {
        imgFoto.setImageDrawable(foto);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_fragmento_foto, container, false);
        if (vista != null) {
            ImageView imgFoto = (ImageView) vista.findViewById(R.id.imgFoto);
        }

        return imgFoto;
    }


}
