package com.example.servicosautonomos.gui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.AparelhosEletronicos;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<AparelhosEletronicos> aparelhosLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        FirebaseApp.initializeApp(MapsActivity.this);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = database.getReference();
        FirebaseDatabase.getInstance().getReference("aparelhosEletronicos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                aparelhosLista.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot key : dataSnapshot.getChildren()) {
                    keys.add(key.getKey());
                    AparelhosEletronicos aparelhosEletronicos = key.getValue(AparelhosEletronicos.class);
                    aparelhosLista.add(aparelhosEletronicos);
                }
                int size = aparelhosLista.size();
                int cont = 0;

                do {
                    AparelhosEletronicos ap = aparelhosLista.get(cont);
                    Double lat = ap.latitude;
                    Double lon = ap.longitude;

                    LatLng latLng = new LatLng(lat,lon);

                    MarkerOptions options = new MarkerOptions().position(latLng).title("test" + cont);
                    mMap.addMarker(options);

                    cont++;
                }while (cont < size);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });
    }


}
