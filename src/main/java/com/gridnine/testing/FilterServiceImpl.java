package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterServiceImpl implements FilterService {
    @Override
    public List<Flight> departureBeforeTime(List<Flight> flights) {
        LocalDateTime now = LocalDateTime.now();
        Stream<Flight> stream = flights.stream();

        stream = stream.filter(flight -> {
            for(Segment segment: flight.getSegments()){
                if(segment.getDepartureDate().isBefore(now)){
                    return true;
                }
            }
            return false;
        });

        List<Flight> filteredFlights= stream.collect(Collectors.toList());
        return  filteredFlights;
    }

    @Override
    public List<Flight> flightDate(List<Flight> flights) {
        Stream<Flight> stream = flights.stream();

        stream = stream.filter(flight -> {
            for(Segment segment: flight.getSegments()){
                if(segment.getDepartureDate().isAfter(segment.getArrivalDate())){
                    return true;
                }
            }
            return false;
        });

        List<Flight> filteredFlights= stream.collect(Collectors.toList());
        return  filteredFlights;
    }


    @Override
    public List<Flight> timeOfEarth(List<Flight> flights) {
        Stream<Flight> stream = flights.stream();

        stream = stream.filter(flight -> {
            Comparator<Segment> comparator =new Comparator<Segment>() {
                @Override
                public int compare(Segment o1, Segment o2) {
                    if(o1.getDepartureDate().isBefore(o2.getDepartureDate()))
                    return -1;
                    else
                        return 1;
                }
            };

            List<Segment> segmentsSort= flight.getSegments().stream().sorted(comparator).collect(Collectors.toList());
            Iterator<Segment> iterator = segmentsSort.iterator();
            Segment segment1 = iterator.next();
            while (iterator.hasNext()){
                Segment segment2 =iterator.next();
                if(segment1.getArrivalDate().plusHours(2).isBefore(segment2.getDepartureDate())) {
                    return true;
                }
            }
            return false;
        });
        return stream.collect(Collectors.toList());
    }
}

