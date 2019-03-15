package com.satrio.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.satrio.myapplication.home.Rekomendasi;
import com.satrio.myapplication.home.Favorite;
import com.satrio.myapplication.home.New;
import com.satrio.myapplication.R;
import com.satrio.myapplication.home.Promo;

public class Fragment1 extends Fragment implements View.OnClickListener{
private CardView card1, card2, card3, card4;
    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View show = inflater.inflate(R.layout.activity_fragment1, container, false);

        card1 =  show.findViewById(R.id.card1);
        card1.setOnClickListener(this);
        card2 =  show.findViewById(R.id.card2);
        card2.setOnClickListener(this);
        card3 =  show.findViewById(R.id.card3);
        card3.setOnClickListener(this);
        card4 =  show.findViewById(R.id.card4);
        card4.setOnClickListener(this);
//
       return show;
    }




    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.card1:
                startActivity(new Intent(getActivity(), Favorite.class));
                getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
                break;
            case R.id.card2:
                startActivity(new Intent(getActivity(), New.class));
                getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
                break;
            case R.id.card3:
                startActivity(new Intent(getActivity(), Promo.class));
                getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
                break;
            case R.id.card4:
                startActivity(new Intent(getActivity(), Rekomendasi.class));
                getActivity().overridePendingTransition(R.anim.move_up, R.anim.exit_up);
                break;
        }}}
//    }}


