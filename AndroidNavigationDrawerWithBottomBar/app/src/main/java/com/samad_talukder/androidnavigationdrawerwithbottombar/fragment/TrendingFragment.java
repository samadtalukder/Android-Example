package com.samad_talukder.androidnavigationdrawerwithbottombar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.samad_talukder.androidnavigationdrawerwithbottombar.R;


public class TrendingFragment extends Fragment {
    private static Fragment fragment;

    public static Fragment getFragment() {
        if (fragment == null) {
            fragment = new TrendingFragment();
        }
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_trending, container, false);

        setToolbarTitle();

        return view;
    }

    private void setToolbarTitle() {
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Trending");
    }
}
