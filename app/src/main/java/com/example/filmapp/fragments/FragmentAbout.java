package com.example.filmapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.UserManagerCompat;
import androidx.fragment.app.Fragment;

import com.example.filmapp.FilmItem;
import com.example.filmapp.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class FragmentAbout extends Fragment {
    View rootView;
    TextView descriotion;
    ImageView imgAbout;

    String filmName;
    String filmDescription;
    int imgRes;
    CollapsingToolbarLayout collapsingToolbarLayout;
    CoordinatorLayout coordinatorLayout;

    String KEY_SELECTED_FILM = "KEY_SELECTED_FILM";
    String ACTION_KEY = "action_key";
    String KEY_IMG = "KEY_IMG";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.fragment_about,container,false);

       initUi();
        return rootView;
    }

    public static FragmentAbout newInstance(FilmItem filmItem){
        FragmentAbout fragmentAbout = new FragmentAbout();
        Bundle bundle = new Bundle();
        bundle.putString("KEY_SELECTED_FILM", filmItem.getTitle());
        bundle.putInt("KEY_IMG",filmItem.getImageRes());
        bundle.putString("KEY_DISCRIPTION",filmItem.getDescription());
        fragmentAbout.setArguments(bundle);
        return fragmentAbout;

        }




    private void initUi(){
        descriotion = rootView.findViewById(R.id.descriptionAbout);
        imgAbout = rootView.findViewById(R.id.imgAbout);
        collapsingToolbarLayout = rootView.findViewById(R.id.collapsing_toolbar);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getArguments() != null){
            Bundle bundle = getArguments();
            filmName = bundle.getString("KEY_SELECTED_FILM",String.valueOf(R.string.beg));
            imgRes = bundle.getInt("KEY_IMG",R.drawable.beg);
            filmDescription = bundle.getString("KEY_DISCRIPTION",String.valueOf(R.string.discr_one));

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        collapsingToolbarLayout.setTitle(filmName);
        imgAbout.setImageResource(imgRes);
        descriotion.setText(filmDescription);
    }
}
