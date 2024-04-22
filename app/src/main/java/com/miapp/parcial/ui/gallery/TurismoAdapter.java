package com.miapp.parcial.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.ImageSwitcher;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.cardview.widget.CardView;
    import androidx.fragment.app.FragmentActivity;
    import androidx.fragment.app.FragmentManager;
    import androidx.fragment.app.FragmentTransaction;
    import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

    import com.miapp.parcial.R;
    import com.miapp.parcial.modelo.Turismo;

    import java.util.List;

    public class TurismoAdapter extends RecyclerView.Adapter {
        private List<Turismo> listaTurismo;
        private Context context;
        private LayoutInflater li;

        public TurismoAdapter(List<Turismo> listaTurismo, Context context, LayoutInflater li) {
            this.listaTurismo = listaTurismo;
            this.context = context;
            this.li = li;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view=li.inflate(R.layout.item,parent,false);
            return new ViewHolderTurismo(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            Turismo turismo = listaTurismo.get(position);
            ViewHolderTurismo viewHolderturismo = (ViewHolderTurismo) holder;
            viewHolderturismo.tvnombre.setText(turismo.getNombre());
            viewHolderturismo.tvdescripcion.setText(turismo.getDescripcion());
            int[] fotos = turismo.getFotos();
            /*
            if (fotos != null && fotos.length > 0) {
                viewHolderturismo.foto1.setImageResource(fotos[0]);
                if (fotos.length > 1) {
                    viewHolderturismo.foto2.setImageResource(fotos[1]);
                } else {
                    // Si solo hay una imagen en el arreglo, puedes ocultar la segunda ImageView
                    viewHolderturismo.foto2.setVisibility(View.GONE);
                }
            } else {
                // Si no hay imágenes en el arreglo, puedes ocultar ambas ImageViews
                viewHolderturismo.foto1.setVisibility(View.GONE);
                viewHolderturismo.foto2.setVisibility(View.GONE);
            }

            */

            ((ViewHolderTurismo) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
/*
                   int clickedPosition = holder.getAdapterPosition();
                    Turismo turismo = listaTurismo.get(clickedPosition);
                    FragmentActivity fragmentActivity = (FragmentActivity) context;
                    SegundoViewModel viewModel = new ViewModelProvider(fragmentActivity).get(SegundoViewModel.class);
                    viewModel.recuperarTurismo(turismo);
*/


                    Bundle bundle=new Bundle();
                    bundle.putSerializable("turismo",turismo);
                    Navigation.findNavController((Activity) v.getContext(), R.id.nav_host_fragment_content_main).navigate(R.id.segundoFragment,bundle);




                }
            });
        }

    @Override
    public int getItemCount() {
        return listaTurismo.size();
    }
    public class ViewHolderTurismo extends RecyclerView.ViewHolder{
        public TextView tvnombre;
        public TextView tvdescripcion;
        public ImageView foto1;
        public ImageView foto2;

         public CardView cardView;


        public ViewHolderTurismo(@NonNull View itemView) {
            super(itemView);
            tvnombre=itemView.findViewById(R.id.tvnombre);
            tvdescripcion=itemView.findViewById(R.id.tvdescripcion);
            foto1=itemView.findViewById(R.id.foto1);
            foto2=itemView.findViewById(R.id.foto2);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
