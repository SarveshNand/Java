package LoveBabbarTasks.OOPS.Abstraction;

class CheckedBaggage extends Baggage implements WeightRestricted {

    CheckedBaggage(String baggageId, double weight, Passenger passenger) {
        super(baggageId, weight, passenger);
    }

    @Override
    double calculateFee() {

        if (weight <= 15) {
            return 0;
        }

        return (weight - 15) * 100;
    }

    @Override
    public boolean checkWeightLimit() {

        return weight <= 32;
    }
}