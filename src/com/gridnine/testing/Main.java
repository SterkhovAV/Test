package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        CurrentTimeCheck currentTimeCheck=new CurrentTimeCheck();
        DepartureTimeCheck departureTimeCheck=new DepartureTimeCheck();
        GroundTimeCheck groundTimeCheck=new GroundTimeCheck();
        System.out.println("Flights list before checks");
        for (Flight f:flights) {
            System.out.println(f.toString());
        }
        System.out.println("Flights list after current time check");
        currentTimeCheck.check(flights,true);
        System.out.println("Flights list after departure time check");
        departureTimeCheck.check(flights,true);
        System.out.println("Flights list after ground check");
        groundTimeCheck.check(flights,true);
        System.out.println("Flights list after full check");
        currentTimeCheck.check(departureTimeCheck.check(groundTimeCheck.check(flights,false),false),true);

    }


}
