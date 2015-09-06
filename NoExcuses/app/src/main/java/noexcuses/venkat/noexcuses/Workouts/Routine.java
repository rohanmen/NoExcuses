package noexcuses.venkat.noexcuses.Workouts;

//import java.util.List;
//
///**
// * Created by Venkat on 4/13/15.
// */
//
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;

public class Routine implements Serializable
{
//    @XmlElement
    private Day[] Day;

    public Day[] getDay ()
    {
        return Day;
    }

    public void setDay (Day[] Day)
    {
        this.Day = Day;
    }

    @Override
    public String toString()
    {
        return "Day = "+Day.toString()+"]";
    }
}

