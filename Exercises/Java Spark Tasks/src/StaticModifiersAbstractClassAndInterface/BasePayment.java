package StaticModifiersAbstractClassAndInterface;

abstract class BasePayment {
    static String appName = "MyPaymentApp";
    String transactionId;

    BasePayment(String transactionId){
        this.transactionId = transactionId;
    }

    void printReceipt(){
        System.out.println("App: " + appName);
        System.out.println("Transaction ID: " + transactionId);
    }
}
