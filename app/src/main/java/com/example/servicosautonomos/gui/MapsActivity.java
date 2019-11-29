package com.example.servicosautonomos.gui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;
import com.example.servicosautonomos.classesbasicas.ReferenciaBotao;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
    private boolean mLocationPermissionsGranted = true;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    ArrayList<Profissional> profissionalLista = new ArrayList<>();
    private static final float DEFAULT_ZOOM = 14f;
    private static final String TAG = "MapsActivity";
    Button button;

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

        if (mLocationPermissionsGranted) {
            getDeviceLocation();

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(false);

        }

        FirebaseApp.initializeApp(MapsActivity.this);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = database.getReference();
        FirebaseDatabase.getInstance().getReference("profissional").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Lista de todos profissionais
                profissionalLista.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot key : dataSnapshot.getChildren()) {
                    keys.add(key.getKey());
                    Profissional profissional = key.getValue(Profissional.class);
                    profissionalLista.add(profissional);
                }

                final int size = profissionalLista.size();
                int cont = 0;

                //while que passa por cada profissional e confere se ele foi do serviço escolhido na activity anterior.
                do {
                    final ReferenciaBotao referenciaBotao = getIntent().getExtras().getParcelable("Referencia");

                    if(referenciaBotao.aparelhosEletronicos){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("aparelhosEletronicos")){
                            //função que coloca os marcadores
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.eletrodomensticos){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("eletrodomesticos")){
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.informaticaTelefonia){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("Informática e Telefonia")){
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.funilariaPintura){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("Funilária e Pintura")){
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.vidracariaAutomotiva){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("Vidraçaria Automotiva")){
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.construcao){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("Construção")){
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.servicosGerais){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("Serviços Gerais")){
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.tecnologia){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("Tecnologia")){
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.grafica){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("Gráfica")){
                            putMarker(profissa);
                        }
                    }
                    if(referenciaBotao.audioVisual){
                        final Profissional profissa = (Profissional) profissionalLista.get(cont);
                        if (profissa.categoria.equals("Áudio/Visual")){
                            putMarker(profissa);
                        }
                    }

                    cont++;
                }while (cont < size);

                //setOnClick que manda os dados do marker escolhido para a activity do perfil
                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        int cont2 = 0;
                        int size1 = profissionalLista.size();
                        do {
                            Profissional profissa =  profissionalLista.get(cont2);

                            if (marker.getTitle().equals(profissa.nome)){
                                Toast.makeText(MapsActivity.this, marker.getTitle(), Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MapsActivity.this, PerfilProfissional.class);
                                intent.putExtra("dados", profissa);
                                startActivity(intent);
                            }
                            cont2++;
                        }while (cont2 < size1);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void putMarker(final Profissional profissional){
        Double lat = profissional.latitude;
        Double lon = profissional.longitude;

        LatLng latLng = new LatLng(lat,lon);

        final MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title(profissional.nome)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pin));
        mMap.addMarker(options);

    }

    private void getDeviceLocation(){
        Log.d(TAG, "getDeviceLocation: getting the devices current location");

       mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        try{
            if(mLocationPermissionsGranted){

                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "onComplete: found location!");
                            final Location currentLocation = (Location) task.getResult();

                            moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                    DEFAULT_ZOOM);

                            button = findViewById(R.id.buttonCentralizar);

                            button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    moveCamera(new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude()),
                                            DEFAULT_ZOOM);
                                }
                            });

                        }else{
                            Log.d(TAG, "onComplete: current location is null");
                            Toast.makeText(MapsActivity.this, "unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }catch (SecurityException e){
            Log.e(TAG, "getDeviceLocation: SecurityException: " + e.getMessage() );
        }
    }
    private void moveCamera(LatLng latLng, float zoom){
        Log.d(TAG, "moveCamera: moving the camera to: lat: " + latLng.latitude + ", lng: " + latLng.longitude );
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom));
    }
}
