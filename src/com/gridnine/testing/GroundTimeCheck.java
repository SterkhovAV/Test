package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroundTimeCheck implements PrintableCheck{
    int delayHours = 2;

    public void setMaxDelayHours(int delayHours) {
        if (delayHours<0) {
            this.delayHours=0;
        } else this.delayHours = delayHours;
    }

    public int getMaxDelayHours() {
        return delayHours;
    }

    //Date hours
    @Override
    public List<Flight> check(List<Flight> flights,Boolean print) {
        System.out.println("Showing flights with ground delay lower then "+delayHours+" hours");
        List<Flight> result=new ArrayList<>();
        List<Segment> segments;
        boolean add=true;
        for (Flight f:flights){
            segments=f.getSegments();
            for (int i=1;i<segments.size();i++) {
                if(segments.get(i-1).getArrivalDate().plusHours(delayHours).isBefore(segments.get(i).getDepartureDate())
                        || segments.get(i-1).getArrivalDate().plusHours(delayHours).isEqual(segments.get(i).getDepartureDate())) {
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
