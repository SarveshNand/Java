package StaticModifiersAbstractClassAndInterface;

abstract class User {
    String name;

    User(String name){
        this.name = name;
    }

    void showName(){
        System.out.println("Name: " + name);
    }
}
