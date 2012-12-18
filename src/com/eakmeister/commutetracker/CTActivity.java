package com.eakmeister.commutetracker;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.os.Bundle;
import android.app.Activity;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CTActivity extends Activity {
	
	private ListView listView;
	private ArrayList<Route> routes;
	private static LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct);
        
        listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(new RouteListAdapter());
        
        routes = new ArrayList<Route>();
        inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
    }
    
    private class RouteListAdapter extends BaseAdapter {
    	public View getView(int position, View convertView, ViewGroup parent) {
    		View vi = convertView;
    		
    		if (convertView == null) {
    			vi = inflater.inflate(R.layout.route_row, null);
    		}
    		
    		TextView routeName = (TextView)vi.findViewById(R.id.routeName);
    		Route route = routes.get(position);
    		routeName.setText(route.name);
    		
    		return vi;
    	}

		public int getCount() {
			return routes.size();
		}

		public Object getItem(int position) {
			return routes.get(position);
		}

		public long getItemId(int position) {
			return position;
		}
    }
}
