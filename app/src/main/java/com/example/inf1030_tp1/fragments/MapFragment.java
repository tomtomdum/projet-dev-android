package com.example.inf1030_tp1.fragments;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.inf1030_tp1.Models.Pharmacy;
import com.example.inf1030_tp1.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private FusedLocationProviderClient mFusedLocationProviderClient;
    private GoogleMap mGoogleMap;
    private SupportMapFragment mapFrag;
    private ArrayList<Pharmacy> pharmacies;
    private ArrayList<MarkerOptions> markerOptionsList;
    private LocationRequest mLocationRequest;
    private Location mLastLocation;
    private Marker mCurrLocationMarker;


    // Register the permissions callback, which handles the user's response to the
    // system permissions dialog. Save the return value, an instance of
    // ActivityResultLauncher, as an instance variable.
    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // features requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                    Toast.makeText(getContext(), "Permission needed to display the map", Toast.LENGTH_SHORT).show();
                }
            });

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pharmacies = initPharmacies();
//        https://api.openweathermap.org/data/2.5/
//        Retrofit retrofit = RetrofitClient.getWeatherClient("https://api.openweathermap.org/data/2.5/");
//        APIWeatherService apiWeatherService = retrofit.create(APIWeatherService.class);
//        apiWeatherService.weather(46.3348999f, -72.5909f);
//        Request jsonObject = apiWeatherService.weather(46.3348999f, -72.5909f, "a2bc2057f54bd49705a6d941ef1c5685").request();
//        Log.i("info", "json response: "+ jsonObject);
//        Log.i("info", "THIS IS A TESTT "+ apiWeatherService.weather(46.3348999f, -72.5909f, "a2bc2057f54bd49705a6d941ef1c5685"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(requireContext());
        mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);
    }

    protected void retrieveLocation() {
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
            return;
        }
        mFusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener((Activity) requireContext(), location -> {
                    if (location != null) {
                        LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 12));
                        addPharmacyMarkers();
                    }
                });
    }

    private void addPharmacyMarkers() {
        // Creating a marker
        markerOptionsList = new ArrayList<>();
        for(int i = 0; i < pharmacies.size(); i++){
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptionsList.add(markerOptions);
            LatLng latLng = new LatLng(pharmacies.get(i).getLat(), pharmacies.get(i).getLon());
            markerOptions.position(latLng);
            markerOptions.title(pharmacies.get(i).getName());
//            markerOptions.snippet(pharmacies.get(i).getName());
            Marker marker = mGoogleMap.addMarker(markerOptions);
            marker.showInfoWindow();
        }
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        mGoogleMap = googleMap;

        /**
         * NOTE: ON PEUT AJOUTER OU REMPLACER LA LIGNE DE CODE EN DESSOUS POUR ALLER CHERCHER UNE LOCALISATION MOINS PRÉCISE.
         */
//         && ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
        if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION);
            return;
        }
        googleMap.setMyLocationEnabled(true);
        retrieveLocation();
    }

    // NE PAS EFFACER LES COORDONNÉES DE LAT ET LON,
    // ELLES REPRÉSENTENT DES COORDONNÉES DE VRAIES PHARMA
    private ArrayList<Pharmacy> initPharmacies() {
//        46.3348999, -72.5909
//        46.35225,-72.606962
//        46.3581683,-72.618929
//        46.3248125, -72.5659
//        46.3408,-72.54535
        ArrayList<Pharmacy> pharmacies = new ArrayList<>();
        Pharmacy pharma1 = new Pharmacy("Pharmaprix");
        pharma1.setLat(46.3348999f);
        pharma1.setLon(-72.5909f);
        Pharmacy pharma2 = new Pharmacy("Uniprix");
        pharma2.setLat(46.35225f);
        pharma2.setLon(-72.606962f);
        Pharmacy pharma3 = new Pharmacy("Proxim");
        pharma3.setLat(46.3581683f);
        pharma3.setLon(-72.618929f);
        Pharmacy pharma4 = new Pharmacy("Accès pharma");
        pharma4.setLat(46.3248125f);
        pharma4.setLon(-72.5659f);
        Pharmacy pharma5 = new Pharmacy("Jean Coutu");
        pharma5.setLat(46.3408f);
        pharma5.setLon(-72.54535f);
        pharmacies.add(pharma1);
        pharmacies.add(pharma2);
        pharmacies.add(pharma3);
        pharmacies.add(pharma4);
        pharmacies.add(pharma5);
        return pharmacies;
    }

}