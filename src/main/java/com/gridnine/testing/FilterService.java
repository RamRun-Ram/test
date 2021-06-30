package com.gridnine.testing;

import java.util.List;

public interface FilterService {
    //Фильтр вылетов до текущего момента времени
    List<Flight> departureBeforeTime(List<Flight> flights);
    //Фильтр сегментов с датой прилёта раньше даты вылета
    List<Flight> flightDate(List<Flight> flights);
    //Фильтр общего время, проведённого на земле превышающего два часа
    List<Flight> timeOfEarth(List<Flight> flights);
}
