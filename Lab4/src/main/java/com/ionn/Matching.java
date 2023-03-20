package com.ionn;

import java.util.*;

public class Matching {
    List<Student> studentList;
    TreeSet<Project> projectList;

    Map<Student, List<Project>> prefMap;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public TreeSet<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(TreeSet<Project> projectList) {
        this.projectList = projectList;
    }

    public Map<Student, List<Project>> getPrefMap() {
        return prefMap;
    }

    public void setPrefMap(Map<Student, List<Project>> prefMap) {
        this.prefMap = prefMap;
    }

    public void lowerPreferences(){
        System.out.println("*** Students with lower than average preferences :");
        long NumarDePreferinte;
        long NumarDePreferinteTotal = 0;
        for (Project p  :projectList
             ) {
            NumarDePreferinte =   studentList.stream()
                    .filter(s -> prefMap.get(s).contains(p))
                    .count();
            NumarDePreferinteTotal = NumarDePreferinteTotal + NumarDePreferinte;
        }
        final int NumarMediuDePreferinte =(int) NumarDePreferinteTotal/studentList.size();
        prefMap.entrySet().stream()
                .filter(s -> s.getValue().size()<NumarMediuDePreferinte)
                .forEach(s -> System.out.println(s.getKey() + " : " + s.getValue().size()));

    }

    public void maximumCardinalityMatching(){
        System.out.println("*** Matchings between students and projects :");
        List<Project> tempL = new ArrayList<>();
        Student tempS = new Student("");
        while(!prefMap.isEmpty()) {
            boolean firstTime = true;
            for (Student s : prefMap.keySet()
            ) {
                if (prefMap.get(s).size() < tempL.size() || firstTime) {
                    tempL = prefMap.get(s);
                    tempS = s;
                    firstTime = false;
                }
            }
            prefMap.remove(tempS);
            for (Project p: tempL
                 ) {
                if(projectList.contains(p)){
                    projectList.remove(p);
                    System.out.println("Student : " + tempS + "Project : " + p );
                    break;
                }
            }
        }
    }
}
