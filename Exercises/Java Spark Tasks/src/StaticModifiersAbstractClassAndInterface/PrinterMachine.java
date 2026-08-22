package StaticModifiersAbstractClassAndInterface;

public class PrinterMachine implements Printable, Scannable{
    @Override
    public void print(){
        System.out.println("Print");
    }

    @Override
    public void scan(){
        System.out.println("Scan");
    }
}
