import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        List<Flight> schedule = findPlanesLeavingInTheNextTwoHours(airport);

        for (Flight x : schedule) {
            System.out.println(x);
        }
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Date dateNow = new Date();
        Date datePlusTwoHours = new Date();
        datePlusTwoHours.setHours(datePlusTwoHours.getHours() + 2);

        List<Terminal> terminalList = airport.getTerminals();

        List<Flight> flights = terminalList.stream()
                .flatMap(t -> t.getFlights().stream())
                .filter((s) -> s.getDate().after(dateNow) && s.getDate().before(datePlusTwoHours))
                .filter((f) -> f.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toList());

        return flights;
    }
}