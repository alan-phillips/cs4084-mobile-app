package ie.ul.googlemaps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentbyId(R.id.map);
        mapFragment.getMapAsync(onMapReadyCallback: this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng Limerick = new LatLng(v: 52.663157, v1: -8.619842);
        map.addMarker(new MarkerOptions().position(Limerick).title("Limerick"));
        map.moveCamera(CameraUpdateFactory.newLatLng(Limerick));
    }
}