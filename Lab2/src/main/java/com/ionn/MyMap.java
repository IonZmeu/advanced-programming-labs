package com.ionn;
/**
 * This class represents a map that contains a list of Locations
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MyMap {
    private final List<Location> locations = new ArrayList<>();

/*
     public boolean toOther(Location loc1,Location loc2){
        HashSet<Road> visited = new HashSet<Road>();
        List<Road> list = new ArrayList<>();
        for (Road road : loc1.getOutRoads()){
            visited.add(road);
            for (Location l : locations){
                List<Road> v = l.getInRoads();
                for (Road vs : v){
                    if
                }
            }

        }
        return true;
    }
*/

    /**
     * adds this location to MyMap's list of locations
     * @param location object of type Location
     */
    public void addLocation(Location location) {
        for (Location l : this.locations){
            if (l.equals(location)){
                System.out.println("This location already exists");
                return ;
            }
        }
        this.locations.add(location);
    }

    /**
     * checks if the length of a road is more than the euclidian distance between the location coordinates.
     * @return returns true or false
     */
    public boolean isValid(){
        for (Location l : this.locations){
            for (Location m : this.locations){
                double ecuation = (m.getY() - l.getY()) * (m.getY() - l.getY()) + (m.getX() - l.getX()) * (m.getX() - l.getX());
                double distance = Math.sqrt(ecuation);

                List<Road> lRoads = l.getOutRoads();
                List<Road> mRoads = m.getInRoads();

                for(Road r : lRoads){
                    for(Road t : mRoads){
                        if(r.getName().equals(t.getName())){
                            if(distance > r.getLength()){
                                return false;
                            };
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     *  getter for the list of Locations
     * @return returns a list of type Location
     */
    public List<Location> getLocations() {
        return locations;
    }

}
