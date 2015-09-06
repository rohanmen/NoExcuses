package noexcuses.venkat.noexcuses.Workouts;

//import java.util.List;
//import javax.xml.bind.annotation.XmlElement;


import java.io.Serializable;

/**
 * Created by Venkat on 4/14/15.
 */

public class Day implements Serializable
{
    private String type;
    private String times;

//    @XmlElement
    private Movement[] Movement;

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    public String getTimes() { return times; }

    public void setTimes(String times) { this.times = times; }

    public Movement[] getMovement ()
    {
        return Movement;
    }

    public void setMovement (Movement[] Movement)
    {
        this.Movement = Movement;
    }

    @Override
    public String toString()
    {

        return "DAY: type = "+type+", Movement = "+ Movement.toString() +"]";
    }
}


