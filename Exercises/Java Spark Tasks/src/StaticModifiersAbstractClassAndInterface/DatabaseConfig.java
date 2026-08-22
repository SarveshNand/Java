package StaticModifiersAbstractClassAndInterface;

public class DatabaseConfig {
    static String databaseName;
    static {
        databaseName = "StudentDB";
    }
    static void showDatabaseName(){
        System.out.println("Database Name: " + databaseName);
    }
}
