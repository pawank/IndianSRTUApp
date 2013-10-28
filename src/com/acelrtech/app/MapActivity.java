package com.acelrtech.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity implements OnMarkerClickListener, OnInfoWindowClickListener{
	static final LatLng INDIA = new LatLng(21.7679, 78.8718);

	private List<NameValue> statesIndiaList;

	static final LatLng Ahmedabad = new LatLng(23.039568, 72.566004);
	static final LatLng AndhraPradesh = new LatLng(17.047762, 80.098187);
	static final LatLng Assam = new LatLng(26.200604, 92.937574);
	static final LatLng Mumbai = new LatLng(19.075984, 72.877656);
	static final LatLng Banglore = new LatLng(12.971599, 77.594563);
	static final LatLng Bihar = new LatLng(25.198009, 85.521896);
	static final LatLng Calcutta = new LatLng(22.572646, 88.363895);
	static final LatLng Chandigarh = new LatLng(30.733315, 76.779418);
	static final LatLng Delhi = new LatLng(28.635308, 77.224960);
	static final LatLng Gujarat = new LatLng(22.258652, 71.192381);
	static final LatLng Haryana = new LatLng(29.058776, 76.085601);
	static final LatLng Himachal = new LatLng(31.836085, 77.169855);
	static final LatLng JandK = new LatLng(34.149088, 76.825965);
	static final LatLng Kadamba = new LatLng(19.362425, 79.655824);
	static final LatLng Karnataka = new LatLng(15.317277, 75.713888);
	static final LatLng Kerala = new LatLng(10.850516, 76.271083);
	static final LatLng Kolhapur = new LatLng(16.691308, 74.244866);
	static final LatLng Maharashtra = new LatLng(19.751480, 75.713888);
	static final LatLng Meghalaya = new LatLng(25.467031, 91.366216);
	static final LatLng Chennai = new LatLng(13.052414, 80.250825);
	static final LatLng Mizoram = new LatLng(23.164543, 92.937574);
	static final LatLng NaviMumbai = new LatLng(19.033049, 73.029662);
	static final LatLng NorthBengal = new LatLng(22.986757, 87.854976);
	static final LatLng NorthEasternKarnataka = new LatLng(15.3300, 75.72);
	static final LatLng NorthWesternKarnataka = new LatLng(15.3300, 75.69);
	// static final LatLng Pepsu
	static final LatLng Pune = new LatLng(18.520430, 73.856744);
	static final LatLng Rajasthan = new LatLng(27.023804, 74.217933);
	static final LatLng SouthBengal = new LatLng(22.556757, 87.554976);
	static final LatLng TamilNadu = new LatLng(11.127123, 78.656894);
	static final LatLng Thane = new LatLng(19.218331, 72.978090);
	static final LatLng Coimbatore = new LatLng(11.016844, 76.955832);
	static final LatLng Kumbakonam = new LatLng(10.961695, 79.388113);
	static final LatLng Madurai = new LatLng(9.925201, 78.119775);
	static final LatLng Salem = new LatLng(42.519540, -70.896716);
	static final LatLng Villupuram = new LatLng(11.939481, 79.497647);
	static final LatLng Trupura = new LatLng(23.940848, 91.988153);
	static final LatLng UttarPradesh = new LatLng(27.570589, 80.098187);

	private GoogleMap map;
	private Marker myMarker; 
	private Hashtable<Object,String> markersTable = new Hashtable<Object,String>();

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);

		statesIndiaList = new ArrayList<NameValue>();
		statesIndiaList.add(new NameValue("Ahmedabad", "Ahmedabad", new LatLng(
				23.039568, 72.566004)));
		statesIndiaList.add(new NameValue("AndhraPradesh", "AndhraPradesh",
				new LatLng(17.047762, 80.098187)));
		statesIndiaList.add(new NameValue("Assam", "Assam", new LatLng(
				26.200604, 92.937574)));
		statesIndiaList.add(new NameValue("Mumbai", "Mumbai", new LatLng(
				19.075984, 72.877656)));
		statesIndiaList.add(new NameValue("Banglore", "Banglore", new LatLng(
				12.971599, 77.594563)));
		statesIndiaList.add(new NameValue("Bihar", "Bihar", new LatLng(
				25.198009, 85.521896)));
		statesIndiaList.add(new NameValue("Calcutta", "Calcutta", new LatLng(
				22.572646, 88.363895)));
		statesIndiaList.add(new NameValue("Chandigarh", "Chandigarh",
				new LatLng(30.733315, 76.779418)));
		statesIndiaList.add(new NameValue("Delhi", "Delhi", new LatLng(
				28.635308, 77.224960)));
		statesIndiaList.add(new NameValue("Gujarat", "Gujarat", new LatLng(
				22.258652, 71.192381)));
		statesIndiaList.add(new NameValue("Haryana", "Haryana", new LatLng(
				29.058776, 76.085601)));
		statesIndiaList.add(new NameValue("Himachal", "Himachal", new LatLng(
				31.836085, 77.169855)));
		statesIndiaList.add(new NameValue("JandK", "Jammu and Kashmir",
				new LatLng(34.149088, 76.825965)));
		statesIndiaList.add(new NameValue("Kadamba", "Kadamba", new LatLng(
				19.362425, 79.655824)));
		statesIndiaList.add(new NameValue("Karnataka", "Karnataka", new LatLng(
				15.317277, 75.713888)));
		statesIndiaList.add(new NameValue("Kerala", "Kerala", new LatLng(
				10.850516, 76.271083)));
		statesIndiaList.add(new NameValue("Kolhapur", "Kolhapur", new LatLng(
				16.691308, 74.244866)));
		statesIndiaList.add(new NameValue("Maharashtra", "Maharashtra",
				new LatLng(19.751480, 75.713888)));
		statesIndiaList.add(new NameValue("Meghalaya", "Meghalaya", new LatLng(
				25.467031, 91.366216)));
		statesIndiaList.add(new NameValue("Chennai", "Chennai", new LatLng(
				13.052414, 80.250825)));
		statesIndiaList.add(new NameValue("Mizoram", "Mizoram", new LatLng(
				23.164543, 92.937574)));
		statesIndiaList.add(new NameValue("NaviMumbai", "NaviMumbai",
				new LatLng(19.033049, 73.029662)));

		statesIndiaList.add(new NameValue("NorthBengal", "NorthBengal",
				new LatLng(22.986757, 87.854976)));
		statesIndiaList.add(new NameValue("NorthEasternKarnataka",
				"NorthEasternKarnataka", new LatLng(15.3300, 75.72)));
		statesIndiaList.add(new NameValue("NorthWesternKarnataka",
				"NorthWesternKarnataka", new LatLng(15.3300, 75.69)));
		statesIndiaList.add(new NameValue("Pune", "Pune", new LatLng(18.520430,
				73.856744)));
		statesIndiaList.add(new NameValue("Rajasthan", "Rajasthan", new LatLng(
				27.023804, 74.217933)));
		statesIndiaList.add(new NameValue("SouthBengal", "SouthBengal",
				new LatLng(22.556757, 87.554976)));
		statesIndiaList.add(new NameValue("TamilNadu", "TamilNadu", new LatLng(
				11.127123, 78.656894)));
		statesIndiaList.add(new NameValue("Thane", "Thane", new LatLng(
				19.218331, 72.978090)));
		statesIndiaList.add(new NameValue("Coimbatore", "Coimbatore",
				new LatLng(11.016844, 76.955832)));
		statesIndiaList.add(new NameValue("Kumbakonam", "Kumbakonam",
				new LatLng(10.961695, 79.388113)));
		statesIndiaList.add(new NameValue("Madurai", "Madurai", new LatLng(
				9.925201, 78.119775)));
		statesIndiaList.add(new NameValue("Salem", "Salem", new LatLng(
				42.519540, -70.896716)));
		statesIndiaList.add(new NameValue("Villupuram", "Villupuram",
				new LatLng(11.939481, 79.497647)));
		statesIndiaList.add(new NameValue("Trupura", "Trupura", new LatLng(
				23.940848, 91.988153)));
		statesIndiaList.add(new NameValue("UttarPradesh", "Uttar Pradesh",
				new LatLng(27.570589, 80.098187)));

		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();

		if (map != null) {
			map.setOnMarkerClickListener(this);
			map.setOnInfoWindowClickListener(this);
			
			Iterator<NameValue> itr = statesIndiaList.iterator();
			while (itr.hasNext()) {
				NameValue name = itr.next();
				if (name.name.equals("Bangalore")) {
					markersTable.put(map.addMarker(new MarkerOptions()
							.position(name.latlng)
							.title(name.value)
							.snippet(name.value)
							.icon(BitmapDescriptorFactory
									.fromResource(R.drawable.ic_launcher))),name.name);
				} else {
					markersTable.put(map.addMarker(new MarkerOptions().position(name.latlng)
							.title(name.value)),name.name);
				}

			}
		}

		// Move the camera instantly to INDIA with a zoom of 1.
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(INDIA, 1));

		// Zoom in, animating the camera.
		map.animateCamera(CameraUpdateFactory.zoomTo(4), 2000, null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onMarkerClick(Marker marker) {
		LatLng ll = marker.getPosition();
		if (markersTable.containsKey(marker)) {
			System.out.println("Marker found with LatLng - " + ll.toString());
			//Intent intent = new Intent(MapActivity.this, ChartActivity.class);
			//System.out.println("Starting Chart activity..");
            //startActivity(intent);
			return false;
		}
		else {
			System.out.println("Marker NOT found with LatLng - " + ll.toString());
			return false;
		}
		
	}

	@Override
	public void onInfoWindowClick(Marker marker) {
		LatLng ll = marker.getPosition();
		if (markersTable.containsKey(marker)) {
			System.out.println("Marker found with LatLng - " + ll.toString());
			Intent intent = new Intent(MapActivity.this, ChartActivity.class);
			System.out.println("Starting Chart activity..");
            startActivity(intent);
		}
		else {
			System.out.println("Marker NOT found with LatLng - " + ll.toString());
			
		}
	}
}
