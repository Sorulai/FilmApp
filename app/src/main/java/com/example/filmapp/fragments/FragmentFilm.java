package com.example.filmapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.filmapp.FilmAdapter;
import com.example.filmapp.FilmItem;
import com.example.filmapp.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentFilm extends Fragment {
    View rootView;
    private RecyclerView recyclerView;
    static List<FilmItem> filmItemList;

    Button btnAbout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
rootView = inflater.inflate(R.layout.fragment_main,container,false);
recyclerView = rootView.findViewById(R.id.recyclerViewFilm);
        FilmAdapter filmAdapter = new FilmAdapter(getActivity(),filmItemList, (FilmAdapter.FilmAdapterEvents) getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(filmAdapter);


        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        filmItemList = new ArrayList<>();
        filmItemList.add(new FilmItem( getResources().getString(R.string.beg),getResources().getString(R.string.discr_one),"0","0",R.drawable.beg));
        filmItemList.add(new FilmItem( getResources().getString(R.string.alice),getResources().getString(R.string.discr_two),"1","0",R.drawable.alice));
        filmItemList.add(new FilmItem( getResources().getString(R.string.iron),getResources().getString(R.string.discr_three),"2","0",R.drawable.iron));



    }

}
