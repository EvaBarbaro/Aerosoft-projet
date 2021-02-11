package interfaces;

import java.util.ArrayList;

public interface Dao {
    
    Object get(Object id);
    
    ArrayList getAll();
    
    void save(Object t);
    
    void update(Object t, ArrayList params);
    
    void delete(Object t);
}
