package com.ionn;


import java.util.ArrayList;
import java.util.List;

public class MyMap {
    private final List<Location> locations = new ArrayList<>();

    public void addLocation(Location location) {
        for (Location l : this.locations){
            if (l.equals(location)){
                System.out.println("This location already exists");
                return ;
            }
        }
        this.locations.add(location);
    }


    public boolean isValid(){
        for (Location l : this.locations){
            for (Location m : this.locations){
                double ecuation = (m.getY() - l.getY()) * (m.getY() - l.getY()) + (m.getX() - l.getX()) * (m.getX() - l.getX());
                double distance = Math.sqrt(ecuation);

                List<Road> lRoads = l.getRoads();
                List<Road> mRoads = m.getRoads();

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

    public List<Location> getLocations() {
        return locations;
    }

}
