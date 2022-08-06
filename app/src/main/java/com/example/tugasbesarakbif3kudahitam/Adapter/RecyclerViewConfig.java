package com.example.tugasbesarakbif3kudahitam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tugasbesarakbif3kudahitam.BotNav.DetailFragment;
import com.example.tugasbesarakbif3kudahitam.Model.Tempat;
import com.example.tugasbesarakbif3kudahitam.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
//NIM     : 10119119
//NAMA    : MUHAMMAD HADYAN NUR ADABI
//KELAS   : IF-3


public class RecyclerViewConfig extends FirebaseRecyclerAdapter<Tempat, RecyclerViewConfig.PlaceAdapter>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */


    public RecyclerViewConfig(@NonNull FirebaseRecyclerOptions<Tempat> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PlaceAdapter holder, int position, @NonNull Tempat model) {
        holder.txtname.setText(model.getName());
        holder.txtaddress.setText(model.getAddress());
        Glide.with(holder.images.getContext()).load(model.getImage()).into(holder.images);

            holder.images.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity =(AppCompatActivity)view.getContext();
                    activity.getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.wrapper, new DetailFragment(
                                    model.getName(),
                                    model.getImage(),
                                    model.getAddress(),
                                    model.getLatitude(),
                                    model.getLongitude(),
                                    model.getDescription()))
                            .addToBackStack(null)
                            .commit();
                }
            });
    }

    @NonNull
    @Override
    public PlaceAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tempat, parent, false);

        return new PlaceAdapter(view);
    }


    public static class PlaceAdapter extends RecyclerView.ViewHolder
    {
        TextView txtname, txtaddress, txtscore;
        ImageView images;

        public PlaceAdapter(@NonNull View itemView) {
            super(itemView);
            txtname = itemView.findViewById(R.id.txtname);
            txtaddress = itemView.findViewById(R.id.txtaddress);
            images = itemView.findViewById(R.id.txtimage);
            txtscore = itemView.findViewById(R.id.txtrating);

        }


    }
}
