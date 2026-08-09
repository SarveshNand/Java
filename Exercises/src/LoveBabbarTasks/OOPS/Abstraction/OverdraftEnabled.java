package LoveBabbarTasks.OOPS.Abstraction;

interface OverdraftEnabled {

    double getOverdraftLimit();
    boolean useOverdraft(double amount);
}
