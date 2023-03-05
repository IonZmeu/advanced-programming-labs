package com.ionn;
/**
 * This class represents a map that contains a list of Locations
 */

import java.util.*;

public class MyMap {
    private final List<Location> locations = new ArrayList<>();

    /*
     public boolean toOther(Location loc1,Location loc2){
        HashSet<Road> visitedRoad = new HashSet<Road>();
        HashSet<Location> visitedLocation = new HashSet<Location>();
        visitedLocation.add(loc1);
        for (Road roadsFromLoc1 : loc1.getOutRoads()) {
            Collections.addAll(visitedRoad, roadsFromLoc1);
        }
        HashSet<Road> visitedRoadStergere = visitedRoad;
        for (Road it : visitedRoad){
            for (Location location : locations){
                for (Road out : location.getInRoads()){
                    System.out.println(it.toString() + " si " + out.toString());
                    if(it.equals(out)){
                        System.out.println("ceva");
                        visitedLocation.add(location);
                        for (Road fromOut : location.getOutRoads()){
                            visitedRoad.add(fromOut);
                            visitedRoadStergere.add(fromOut);
                            System.out.println(visitedRoad.toString());
                        }
                    }
                }
            }
            visitedRoadStergere.remove(it);
        }
        if(visitedLocation.contains(loc2)){
            return true;
        }
         System.out.println(visitedLocation.toString());
        return false;
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
