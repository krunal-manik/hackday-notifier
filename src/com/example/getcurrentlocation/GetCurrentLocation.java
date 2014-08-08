package com.example.getcurrentlocation;


import java.util.List;

import models.LocationModel;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import api.GPSTracker;
import api.ServiceFactory;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GetCurrentLocation extends Activity {
 
	Button btnShowLocation;
	
	// GPSTracker class
	GPSTracker gps;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GoogleMap map = ((MapFragment) getFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        gps = new GPSTracker(this);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(gps.getLatitude(), gps.getLongitude()), 16));

        showType(map, "Police", gps.getLatitude(), gps.getLongitude());
        List<LocationModel> models = ServiceFactory.getApiService()
        		.getLocations(gps.getLatitude(), gps.getLongitude(), "Police");

        for(LocationModel model: models)
        	showType(map, model.getType(), model.getLatitude(), model.getLongitude());
    }
    
    private void showType(GoogleMap map, String type, double latitude, double longitude) {
        map.addMarker(new MarkerOptions()
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.policeman))
        .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
        .position(new LatLng(latitude, longitude)));
    }

}
