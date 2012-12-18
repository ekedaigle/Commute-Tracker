package com.eakmeister.commutetracker;

import java.util.ArrayList;

import android.location.Location;

public class Route {
	public RoutePoint start;
	public RoutePoint stop;
	public ArrayList<Trip> trips;
	public String name;
	
	public class Trip {
		public Route route;
		public ArrayList<Section> sections;
		public ArrayList<RoutePoint> deviationPoints;
		
		private Section currentSection;
		
		public Trip(RoutePoint start) {
			Section section = new Section(start);
			currentSection = section;
			
			sections = new ArrayList<Section>();
			sections.add(currentSection);
		}
		
		public void addPoint(Location l) {
			
		}
	}
	
	public class Section {
		public RoutePoint start;
		public RoutePoint stop;
		public ArrayList<Location> points;
		
		public Section(RoutePoint start) {
			this.start = start;
			points = new ArrayList<Location>();
		}
	}
	
	public class RoutePoint {
		public double lat;
		public double lon;
		public String name;
	}
	
	public Route(String name, RoutePoint start, RoutePoint stop) {
		this.name = name;
		this.start = start;
		this.stop = stop;
		trips = new ArrayList<Trip>();
	}
	
	public Trip createNewTrip() {
		Trip trip = new Trip(start);
		trips.add(trip);
		return trip;
	}
}
