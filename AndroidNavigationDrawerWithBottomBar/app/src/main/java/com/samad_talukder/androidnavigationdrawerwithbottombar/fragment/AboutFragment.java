package com.samad_talukder.androidnavigationdrawerwithbottombar.fragment;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samad_talukder.androidnavigationdrawerwithbottombar.R;


public class AboutFragment extends Fragment {

    private static Fragment fragment;

    public static Fragment getFragment() {
        if (fragment == null) {
            fragment = new AboutFragment();
        }
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        setToolbarTitle();

        return view;
    }

    private void setToolbarTitle() {
        Toolbar toolbar=getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("About");
    }
}
