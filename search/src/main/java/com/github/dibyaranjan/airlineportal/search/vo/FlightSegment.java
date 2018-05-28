package com.github.dibyaranjan.airlineportal.search.vo;

public class FlightSegment {
    private String carrierCode;
    private int flightNumber;

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carrierCode == null) ? 0 : carrierCode.hashCode());
        result = prime * result + flightNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FlightSegment other = (FlightSegment) obj;
        if (carrierCode == null) {
            if (other.carrierCode != null)
                return false;
        } else if (!carrierCode.equals(other.carrierCode))
            return false;
        if (flightNumber != other.flightNumber)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FlightSegment [carrierCode=" + carrierCode + ", flightNumber=" + flightNumber + "]";
    }
}
