package com.dotcont.myapplication;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dotcont.myapplication.databinding.FragmentItemBinding;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<Restaurante> mValues;

    public MyRestauranteRecyclerViewAdapter(Context context, List<Restaurante> items) {
        ctx = context;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.textViewNombreRestaurante.setText(mValues.get(position).getNombre());
        holder.textViewDireccionRestaurante.setText(mValues.get(position).getDireccion());
        holder.ratingBarRestaurante.setRating(mValues.get(position).getValoracion());

        Glide.with(ctx)
                .load(holder.mItem.getUrlPhoto())
                .centerCrop()
                .into(holder.imageViewPhotoRestaurante);


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
//aqui modificacion
    public class ViewHolder extends RecyclerView.ViewHolder {



        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewPhotoRestaurante;
        public final RatingBar ratingBarRestaurante;

        public Restaurante mItem;

        public ViewHolder(FragmentItemBinding binding) {
            super(binding.getRoot());

            textViewNombreRestaurante = binding.textViewNombre;
            textViewDireccionRestaurante = binding.textViewDireccion;
            imageViewPhotoRestaurante = binding.imageViewPhoto;
            ratingBarRestaurante = binding.ratingBar;

        }

        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreRestaurante.getText() + "'";
        }
    }
}