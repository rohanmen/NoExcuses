package noexcuses.venkat.noexcuses.Workouts;

/**
 * Created by Venkat on 4/13/15.
 */

//import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

/**
 * Created by Venkat on 4/13/15.
 */
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "Workout")
public class Workout
{
    private String concentration;

    private String days;

    private String name;

    private String length;

    private ArrayList<String> workoutDays = new ArrayList<String>(); //actual day names when user is available

//    @XmlElement
    private Routine Routine;

    public void addWorkoutDay(String day) {
        workoutDays.add(day);
    }

    public ArrayList<String> getWorkoutDays() {
        return workoutDays;
    }

    public String getConcentration ()
    {
        return concentration;
    }

    public void setConcentration (String concentration)
    {
        this.concentration = concentration;
    }

    public String getDays ()
    {
        return days;
    }

    public void setDays (String days)
    {
        this.days = days;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getLength ()
    {
        return length;
    }

    public void setLength (String length)
    {
        this.length = length;
    }

    public Routine getRoutine ()
    {
        return Routine;
    }

    public void setRoutine (Routine Routine)
    {
        this.Routine = Routine;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [concentration = "+concentration+", days = "+days+", name = "+name+", length = "+length+", Routine = "+Routine+"]";
    }
}


