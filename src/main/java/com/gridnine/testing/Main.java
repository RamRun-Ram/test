package com.gridnine.testing;

import java.util.List;

/**
 * Точка входа в приложение
 *
 * @author Ramil Shigapov
 */
public class Main {

    public static void main(String[] args) {
            //Создание списка полетов
            List<Flight> flights = FlightBuilder.createFlights();
            //Создание сервиса фильтров
            FilterService fil = new FilterServiceImpl();
            //Вывод результатов фильтрации
            System.out.println(fil.departureBeforeTime(flights));
            System.out.println(fil.flightDate(flights));
            System.out.println(fil.timeOfEarth(flights));
        }
    }

