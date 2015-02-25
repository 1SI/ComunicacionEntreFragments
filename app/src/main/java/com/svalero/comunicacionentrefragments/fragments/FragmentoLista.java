package com.svalero.comunicacionentrefragments.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.svalero.comunicacionentrefragments.R;
import com.svalero.comunicacionentrefragments.beans.Persona;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentoLista.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentoLista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoLista extends Fragment {

    private OnPersonaSeleccionada mListener;
    private ListView lista;

    /*
     * Singleton
     */
    public static FragmentoLista newInstance(Bundle arguments) {
        FragmentoLista fragment = new FragmentoLista();
        if (arguments != null) {
            fragment.setArguments(arguments);
        }
        return fragment;
    }

    public FragmentoLista() {
        // Required empty public constructor
    }

    /*
    2º método: recuperar los argumentos
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Persona persona = getArguments().getSerializable("PERSONA");
        }
    }

    /*
    3º método: construcción del Layout.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_fragmento_lista, container, false);
        if (vista != null) {
            // Recuperar la lista
            lista = (ListView) vista.findViewById(R.id.listaFragment);
        }
        return vista;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Si los datos vinieran de fuera, esto iría en un AsyncTask!
        lista.setAdapter(new AdaptadorLista(this, listaDatosPersona));


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*
    1º método del ciclo de vida
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnPersonaSeleccionada) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnPersonaSeleccionada {
        public void OnPersonaSelect(Persona persona);
    }

    class AdaptadorLista extends ArrayAdapter<Persona> {
        Persona[] listaElementos;
        Activity myContext;

        public AdaptadorLista(Fragment context, Persona[] objects) {
            super(context.getActivity(), R.layout.list_item, objects);
            this.listaElementos = objects;
            this.myContext = context.getActivity();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = myContext.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item, null);

            // Toca hacer referencia a las dos cajas de texto
            TextView txtNombre = (TextView) item.findViewById(R.id.txtNombre);
            txtNombre.setText(listaElementos[position].getNombre());

            TextView txtApellido = (TextView) item.findViewById(R.id.txtApellido);
            txtNombre.setText(listaElementos[position].getApellidos());
            return super.getView(position, convertView, parent);
        }
    }

}
