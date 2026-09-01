package Generic;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void save(T item){
        items.add(item);
    }

    public T findFirst(){
        if (items.isEmpty()){
            return null;
        }
        return items.get(0);
    }

    public List<T> findAll(){
        return items;
    }
}
