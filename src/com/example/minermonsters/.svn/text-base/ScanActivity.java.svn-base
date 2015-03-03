package com.example.minermonsters;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ScanActivity extends Activity {

	int location =0, mSlot;
	Scan scan = new Scan();
	Monster m;
	Inventory i = new Inventory();
	String mName;
	InputStream in;
	Writer out;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan);

		/* Use the LocationManager class to obtain GPS locations */
		//LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		//LocationListener mlocListener = new MyLocationListener();
		//mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);


		Button btn = (Button)findViewById(R.id.scanButton1);

		btn.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
				LocationListener mlocListener = new MyLocationListener();
				mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

				//				scan.setLocation(1);
				//				in = getBaseContext().getResources().openRawResource(R.raw.monster1);
				//				m=scan.scanMonster(in);
				//				m.stats();
				//				m.setSlot(1);
				//				out = getBaseContext().getResources().openRawResource(R.raw.test);
				m.testSave();

				if(location == 0)
				{
					if(i.findEmptySlot() != 0)
					{
						Toast.makeText( getApplicationContext(),"Invalid Location",Toast.LENGTH_SHORT ).show();
					}
					else
					{

						m = scan.scanMonster(location);
						m.setSlot(mSlot);
						//need input to set monster name
						m.setName(mName);
						m.save();
					}
				}

			}
		});

		//this activity needs more input/output
		//input - for setting the monster's name
		//output - showing the results of the scan

	}
	/* Class My Location Listener */
	public class MyLocationListener implements LocationListener
	{
		@Override
		public void onLocationChanged(Location loc)
		{
			/*
	loc.getLatitude();
	loc.getLongitude();
	String Text = "My current location is: " +
	"Latitud = " + loc.getLatitude() +
	"Longitud = " + loc.getLongitude();
	Toast.makeText( getApplicationContext(),
	Text,
	Toast.LENGTH_SHORT).show();
			 */
			double lat = loc.getLatitude();
			double lon = loc.getLongitude();
			Toast.makeText( getApplicationContext(),
					"Lat="+lat,
					Toast.LENGTH_SHORT ).show();
			Toast.makeText( getApplicationContext(),
					"Lon="+lon,
					Toast.LENGTH_SHORT ).show();

			if(lat < 35.3085 && lat > 35.3065)
			{
				if(lon > -80.737 && lon < -80.735)
				{
					location =1;
				}
				if(lon > -80.735 && lon< -80.732)
				{
					location =2;
				}
				if(lon > -80.732 && lon < -80.729)
				{
					location =3;
				}
			}
			if(lat < 35.307 && lat > 35.3055)
			{
				if(lon > -80.737 && lon < -80.735)
				{
					location =4;
				}
				if(lon > -80.735 && lon< -80.732)
				{
					location =5;
				}
				if(lon > -80.732 && lon < -80.729)
				{
					location =6;
				}
			}
			if(lat < 35.3055 && lat > 35.3036)
			{
				if(lon > -80.737 && lon < -80.735)
				{
					location =7;
				}
				if(lon > -80.735 && lon< -80.732)
				{
					location =8;
				}
				if(lon > -80.732 && lon < -80.729)
				{
					location =9;
				}
			}
			Toast.makeText( getApplicationContext(),
					"Location="+location,
					Toast.LENGTH_SHORT ).show();
		}

		@Override
		public void onProviderDisabled(String provider)
		{
			Toast.makeText( getApplicationContext(),
					"Gps Disabled",
					Toast.LENGTH_SHORT ).show();
		}

		@Override
		public void onProviderEnabled(String provider)
		{
			Toast.makeText( getApplicationContext(),
					"Gps Enabled",
					Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras)
		{

		}

	}
}
