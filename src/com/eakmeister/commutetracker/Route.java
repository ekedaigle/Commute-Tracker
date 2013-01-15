package com.eakmeister.commutetracker;

import java.util.ArrayList;

import android.location.Location;

public class Route {
	public RoutePoint start;
	public RoutePoint stop;
	public ArrayList<RoutePoint> deviationPoints;
	public ArrayList<Section> sections;
	public ArrayList<Trip> trips;
	public String name;
	
	public static class Section {
		public RoutePoint start;
		public RoutePoint stop;
		public ArrayList<Location> points;
		public boolean open;
		
		public Section(RoutePoint start) {
			this.start = start;
			points = new ArrayList<Location>();
		}
		
		public boolean containsPoint(Location l) {
			return false;
		}
	}
	
	public static class Trip {
		public ArrayList<Section> sections;
		
		public Trip() {
			sections = new ArrayList<Section>();
		}
	}
	
	public static class RoutePoint {
		public double lat;
		public double lon;
		public String name;
		
		public RoutePoint(double lat, double lon, String name) {
			this.lat = lat;
			this.lon = lon;
			this.name = name;
		}
	}
	
	public Route(String name, RoutePoint start, RoutePoint stop) {
		this.name = name;
		this.start = start;
		this.stop = stop;
		sections = new ArrayList<Section>();
	}
	
	public Trip createNewTrip() {
		Trip trip = new Trip();
		trips.add(trip);
		return trip;
	}
}
