package com.eakmeister.commutetracker;

import android.app.Activity;
import android.os.Bundle;

public class MapDisplayActivity extends Activity {
	private Route route;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		
	}
	
	@Override
	public void onStart() {
		route = RouteListActivity.activeRoute;
	}
}
