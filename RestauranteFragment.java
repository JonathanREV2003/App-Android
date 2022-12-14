package com.dotcont.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class RestauranteFragment extends Fragment {
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurantes;
    List<Restaurante> restauranteList;
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //Lista de elementos
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Pizzeria Carl'S","https://www.saborusa.com/wp-content/uploads/2019/10/Animate-a-disfrutar-una-deliciosa-pizza-de-salchicha-Foto-destacada.png",5.0f,"Jalapa, Guatemala"));
            restauranteList.add(new Restaurante("Asados los abuelos","https://colanta.com/aprende-de/wp-content/uploads/2019/03/Tipos-de-asados1.jpg",4.5f,"Guatemala, Guatemala"));
            restauranteList.add(new Restaurante("Los Pinchos","https://media-cdn.tripadvisor.com/media/photo-s/06/c3/d4/b8/delicioso-pinchos.jpg",5.0f,"Peten, Guatemala"));

            adapterRestaurantes = new MyRestauranteRecyclerViewAdapter(getActivity(),restauranteList);
            recyclerView.setAdapter( adapterRestaurantes);
        }
        return view;
    }

    public interface OnListFragmetInteractionListener {
    }
}