package noexcuses.venkat.noexcuses.Workouts;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Ahmed on 4/28/2015.
 */
public class QuickWorkout implements Serializable {
    private String name;
    private String length;
    private ArrayList<Movement> movements;

    public QuickWorkout() {
        movements = new ArrayList<Movement>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    public ArrayList<Movement> getMovements() {
        return movements;
    }

    public void addMovement(Movement movement) {
        movements.add(movement);
    }

    public void setMovement(ArrayList<Movement> movements) {
        this.movements = movements;
    }

}
