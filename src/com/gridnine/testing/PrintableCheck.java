package com.gridnine.testing;

import java.util.List;

public interface PrintableCheck {

    public List<Flight> check(List<Flight> flights,Boolean print);

    public default void print(List<Flight> flights) {
        if (flights.size()==0) {
            System.out.println("No matching flights");
        } else {
            for (Flight f:flights) System.out.println(f.toString());
        }
    }
}
