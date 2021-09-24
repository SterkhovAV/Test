package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartureTimeCheck implements PrintableCheck{

    @Override
    public List<Flight> check(List<Flight> flights,Boolean print) {
        List<Flight> result=new ArrayList<>();
        List<Segment> segments;
        boolean add=true;
        for (Flight f:flights){
            segments=f.getSegments();
            for (Segment s:segments) {
                if (s.getDepartureDate().isAfter(s.getArrivalDate())) {
                    add=false;
                }
            }
            if(add) result.add(f);
            add=true;
        }
        if (print) print(result);
        return result;
    }
}
