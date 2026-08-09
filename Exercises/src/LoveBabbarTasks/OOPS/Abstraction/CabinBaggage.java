package LoveBabbarTasks.OOPS.Abstraction;

class CabinBaggage extends Baggage implements WeightRestricted {

    CabinBaggage(String baggageId, double weight, Passenger passenger) {
        super(baggageId, weight, passenger);
    }

    @Override
    double calculateFee() {

        if (checkWeightLimit()) {
            return 0;
        }

        return 1000;
    }

    @Override
    public boolean checkWeightLimit() {

        return weight <= 7;
    }
}
