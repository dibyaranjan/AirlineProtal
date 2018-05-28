package com.github.dibyaranjan.airlineportal.search.converter;

import java.util.List;

import com.github.dibyaranjan.airlineportal.lowfare.search.Flight;
import com.github.dibyaranjan.airlineportal.lowfare.search.Itinerary;
import com.github.dibyaranjan.airlineportal.lowfare.search.LowFareSearchResult;
import com.github.dibyaranjan.airlineportal.lowfare.search.Outbound;
import com.github.dibyaranjan.airlineportal.search.vo.FlightProposal;
import com.github.dibyaranjan.airlineportal.search.vo.FlightSegment;
import com.github.dibyaranjan.infra.converter.SimpleObjectConverter;
import com.github.dibyaranjan.infra.converter.annotation.Convert;

@Convert(source = LowFareSearchResult.class, target = FlightProposal.class)
public class FlightProposalFromFareSearchResultConverter extends SimpleObjectConverter {

    @Override
    protected <T, S> T doConvert(T targetObject, S sourceObject) {
        LowFareSearchResult source = (LowFareSearchResult) sourceObject;
        FlightProposal target = (FlightProposal) targetObject;

        target.setOrigin(source.getItineraries().get(0).getOutbound().getFlights().get(0).getOrigin().getAirport());
        target.setDestination(source.getItineraries().get(0).getOutbound().getFlights().get(0).getDestination()
                .getAirport());

        target.setOriginTime(source.getItineraries().get(0).getOutbound().getFlights().get(0).getDepartsAt());
        target.setDestinationTime(source.getItineraries().get(0).getOutbound().getFlights().get(0).getArrivesAt());
        List<Itinerary> itineraries = source.getItineraries();
        for (Itinerary itinerary : itineraries) {
            Outbound outbound = itinerary.getOutbound();
            List<Flight> flights = outbound.getFlights();
            for (Flight flight : flights) {
                String flightNumber = flight.getFlightNumber();
                String marketingAirline = flight.getMarketingAirline();
                
                FlightSegment segment = new FlightSegment();
                segment.setCarrierCode(marketingAirline);
                segment.setFlightNumber(Integer.parseInt(flightNumber));
                
                target.addFlightSegment(segment);
            }
        }

        return targetObject;
    }
}
