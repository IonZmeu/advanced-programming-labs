package com.ionn;
/**
 * This class represents a map that contains a list of Locations
 */

import java.util.*;

public class MyMap {
    private final List<Location> locations = new ArrayList<>();

    public boolean toOther(Location loc1,Location loc2){
        HashSet<Road> visitedRoad = new HashSet<Road>();
        for (Road roadsFromLoc1 : loc1.getOutRoads()) {
            Collections.addAll(visitedRoad, roadsFromLoc1);
        }
        int numElem = 0;
        List<Road> temporary = new ArrayList<Road>();
        while (numElem != visitedRoad.size()){
          for (Road road : visitedRoad){
              for (Location loc : locations){
                  for (Road road2 : loc.getInRoads()){
                      if(road.equals(road2)){
                          for (Road road3 : loc.getOutRoads()){
                              //temporary.add(road3);
                              visitedRoad.add(road3);
                          }
                      }
                  }
              }
          }
            /*for (Road road4 : temporary) {
                Collections.addAll(visitedRoad, road4);
            }*/
        }
        for(Road road1 : visitedRoad){
            for(Road road2 : loc1.getInRoads()){
                if (road1.equals(road2)){
                    return true;
                }
            }
        }
        return false;
    }


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
