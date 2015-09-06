package schedule;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by rohanmenhdiratta on 4/11/15.
 */
public class Schedule extends RealmObject {

    @PrimaryKey
    private String schedule;
    private String timeStamp;
    private String day;

    //setters and getters

    public String getSchedule()
    {
        return this.schedule;
    }

    public String getTimeStamp()
    {
        return this.timeStamp;
    }

    public String getDay()
    {
        return  this.day;
    }

    public void setSchedule(String s)
    {
        this.schedule = s;
    }

    public void setTimeStamp(String t)
    {
        this.timeStamp = t;
    }

    public void setDay(String d)
    {
        this.day = d;
    }

}
