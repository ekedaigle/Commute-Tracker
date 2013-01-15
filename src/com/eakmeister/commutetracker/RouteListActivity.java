package com.eakmeister.commutetracker;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RouteListActivity extends Activity implements OnItemClickListener {
	public static Route activeRoute = null;
	
	private ListView listView;
	private ArrayList<Route> routes;
	private static LayoutInflater inflater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct);
        
        routes = new ArrayList<Route>();
        routes.add(new Route("TestRoute1", new Route.RoutePoint(0, 0, "Start"), new Route.RoutePoint(0, 1, "End")));
        
        listView = (ListView)findViewById(R.id.listView1);
        listView.setAdapter(new RouteListAdapter());
        listView.setOnItemClickListener(this);
        
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

	public void onItemClick(AdapterView<?> parent, View view, int position, long id ) {
		Route route = routes.get(position);
		Intent intent = new Intent(view.getContext(), MapDisplayActivity.class);
		activeRoute = route;
		startActivity(intent);
	}
}
