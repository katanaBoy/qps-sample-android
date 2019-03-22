package com.solvd.carinademoapplication.test_screens;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.solvd.carinademoapplication.R;

public class FragmentMap extends Fragment {

    private static final String TAG = FragmentMap.class.getSimpleName();

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getFragmentManager() != null) {
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            if (mapFragment != null) {
                mapFragment.getMapAsync(googleMap -> {
                    try {
                        if (getContext() != null) {
                            googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getContext(), R.raw.mapstyle_night));
                        }
                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                    }

                    googleMap.getUiSettings().setZoomControlsEnabled(true);
                    googleMap.setBuildingsEnabled(true);

                    LatLng minskPosition = new LatLng(53.893009, 27.567444);
                    googleMap.addMarker(new MarkerOptions().position(minskPosition).title("Marker in Minsk"));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(minskPosition, 10.5f));
                });
            }
        }
    }
}