package com.example.filmapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmapp.fragments.FragmentAbout;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {
    private Context context;
    private List<FilmItem> filmItems;
    private FilmAdapterEvents filmAdapterEvents;
    private SharedPreferences sharedPreferences;
    public static final String PREFS_NAME = "GIFT_APP";
    public static final String FAVORITES_Title  = "TITLE";
    public static final String FAVORITES_IMG  = "IMG";
    private List<FilmItem> filmItemsFav = new ArrayList<>();


    public FilmAdapter(Context context, List<FilmItem> filmItems,FilmAdapterEvents filmAdapterEvents) {
        this.context = context;
        this.filmItems = filmItems;
        this.filmAdapterEvents = filmAdapterEvents;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_film,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
      holder.textView.setText(filmItems.get(position).getTitle());
      holder.imageView.setImageResource(filmItems.get(position).getImageRes());
      holder.btnAbout.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             filmAdapterEvents.onFilmClicked(filmItems.get(position));
          }
      });

      holder.btnFav.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(filmItems.get(position).getFav_status().equals("0")){
                  filmItems.get(position).setFav_status("1");
                  holder.btnFav.setBackgroundResource(R.drawable.ic_favorite_red_24dp);
                  filmItemsFav.add(new FilmItem(filmItems.get(position).getTitle(),filmItems.get(position).getDescription(),
                          filmItems.get(position).getId(),filmItems.get(position).getFav_status(),filmItems.get(position).getImageRes()));
                  Toast.makeText(context,filmItems.get(position).getTitle() + filmItems.get(position).getDescription() +
                          filmItems.get(position).getId() + filmItems.get(position).getFav_status() + filmItems.get(position).getImageRes(),Toast.LENGTH_SHORT).show();









              } else {
                  filmItems.get(position).setFav_status("0");
                  holder.btnFav.setBackgroundResource(R.drawable.ic_favorite_grey_24dp);
              }
          }
      });




    }

    @Override
    public int getItemCount() {
        return filmItems.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private Button btnAbout;
        private Button btnFav;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.filmImg);
            textView = itemView.findViewById(R.id.titleFilm);
            btnAbout = itemView.findViewById(R.id.btnAbout);
            btnFav = itemView.findViewById(R.id.favBtn);

        }

    }
    public interface FilmAdapterEvents{
        void onFilmClicked(FilmItem filmItem);
    }


}
