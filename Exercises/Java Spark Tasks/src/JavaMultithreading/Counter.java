package JavaMultithreading;

public class Counter{
    int count;

//    void increment(){
//        count++;
//    }

    synchronized void increment(){
        count++;
    }
}
