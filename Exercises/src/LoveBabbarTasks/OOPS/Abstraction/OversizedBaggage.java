package LoveBabbarTasks.OOPS.Abstraction;

class OversizedBaggage extends Baggage implements WeightRestricted {

    OversizedBaggage(String baggageId, double weight, Passenger passenger) {
        super(baggageId, weight, passenger);
    }

    @Override
    double calculateFee() {

        return 2000 + (weight * 50);
    }

    @Override
    public boolean checkWeightLimit() {

        return weight <= 50;
    }
}
