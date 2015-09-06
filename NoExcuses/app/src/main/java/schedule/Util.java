package schedule;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import noexcuses.venkat.noexcuses.GlobalDefinitions;

/**
 * Created by rohanmenhdiratta on 4/13/15.
 */
public class Util {

    private static String[] daysOfWeek = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
    private static String[] timeSlots =  new String[96];

    static {
        initTimeSlots();
    }

    public Util()
    {

    }

    /**
     *Get the user's schedule for a given day of the week
     * @param day : String representing day of week. ex: "MONDAY", "TUESDAY"
     * @param c : context of the Activity the method is called from
     * @return : array of boolean (size 96) corresponding to if a time slot is free or busy.  true = free, false = busy
     */
    public static boolean[] getScheduleFromDatabase(String day, Context c)
    {
        boolean[] arrayToRet = new boolean[timeSlots.length];

//        Realm realm = Realm.getInstance(c);
//        // Build the query looking at all users:
//        RealmQuery<Schedule> query = realm.where(Schedule.class);
//        RealmResults<Schedule> results = realm.where(Schedule.class).equalTo("day", day).findAll();
//        Log.v("Util", "NumResults = " + results.size());

        SharedPreferences sharedPref = c.getSharedPreferences(GlobalDefinitions.activeUserName, Context.MODE_PRIVATE);
        String schedule = sharedPref.getString(day, "");
        Log.v("Util", schedule);
        if(schedule.equals(""))
        {
            for(int j = 0; j < timeSlots.length; j++)
            {
                arrayToRet[j] = true;
            }
        }
        else
        {
            //undo the string
            //String schedule = results.last().getSchedule();
            Log.v("Util", "sched lenght = " + schedule.length() + "   " + schedule);
            for (int j = 0; j < schedule.length(); j++)
            {
                String bool =schedule.substring(j, j+1);
                if(bool.equals("1"))
                {
                    arrayToRet[j] = true;
                }
                else
                {
                    arrayToRet[j] = false;
                }
            }
        }

        return arrayToRet;
    }

    public static boolean scheduleExistsInDatabase(String day, Context c)
    {
        Realm realm = Realm.getInstance(c);
        // Build the query looking at all users:
        RealmQuery<Schedule> query = realm.where(Schedule.class);
        RealmResults<Schedule> results = realm.where(Schedule.class).equalTo("day", day).findAll();

        if(results.isEmpty())
        {
            return false;
        }

        return true;
    }

    public static String[] getDaysOfWeek()
    {
        return daysOfWeek;
    }

    public static String[] getTimeSlots()
    {
        initTimeSlots();
        return timeSlots;
    }


    public static void initTimeSlots()
    {
        timeSlots[0] = "12:00am - 12:15am";
        timeSlots[1] = "12:15am - 12:30am";
        timeSlots[2] = "12:30am - 12:45am";
        timeSlots[3] = "12:45am - 1:00am";
        timeSlots[4] = "1:00am - 1:15am";
        timeSlots[5] = "1:15am - 1:30am";
        timeSlots[6] = "1:30am - 1:45am";
        timeSlots[7] = "1:45am - 2:00am";
        timeSlots[8] = "2:00am - 2:15am";
        timeSlots[9] = "2:15am - 2:30am";
        timeSlots[10] = "2:30am - 2:45am";
        timeSlots[11] = "2:45am - 3:00am";
        timeSlots[12] = "3:00am - 3:15am";
        timeSlots[13] = "3:15am - 3:30am";
        timeSlots[14] = "3:30am - 3:45am";
        timeSlots[15] = "3:45am - 4:00am";
        timeSlots[16] = "4:00am - 4:15am";
        timeSlots[17] = "4:15am - 4:30am";
        timeSlots[18] = "4:30am - 4:45am";
        timeSlots[19] = "4:45am - 5:00am";
        timeSlots[20] = "5:00am - 5:15am";
        timeSlots[21] = "5:15am - 5:30am";
        timeSlots[22] = "5:30am - 5:45am";
        timeSlots[23] = "5:45am - 6:00am";

        timeSlots[24] = "6:00am - 6:15am";
        timeSlots[25] = "6:15am - 6:30am";
        timeSlots[26] = "6:30am - 6:45am";
        timeSlots[27] = "6:45am - 7:00am";
        timeSlots[28] = "7:00am - 7:15am";
        timeSlots[29] = "7:15am - 7:30am";
        timeSlots[30] = "7:30am - 7:45am";
        timeSlots[31] = "7:45am - 8:00am";
        timeSlots[32] = "8:00am - 8:15am";
        timeSlots[33] = "8:15am - 8:30am";
        timeSlots[34] = "8:30am - 8:45am";
        timeSlots[35] = "8:45am - 9:00am";
        timeSlots[36] = "9:00am - 9:15am";
        timeSlots[37] = "9:15am - 9:30am";
        timeSlots[38] = "9:30am - 9:45am";
        timeSlots[39] = "9:45am - 10:00am";
        timeSlots[40] = "10:00am - 10:15am";
        timeSlots[41] = "10:15am - 10:30am";
        timeSlots[42] = "10:30am - 10:45am";
        timeSlots[43] = "10:45am -11:00am";
        timeSlots[44] = "11:00am - 11:15am";
        timeSlots[45] = "11:15am - 11:30am";
        timeSlots[46] = "11:30am - 11:45am";
        timeSlots[47] = "11:45am - 12:00pm";

        timeSlots[48] = "12:00pm - 12:15pm";
        timeSlots[49] = "12:15pm - 12:30pm";
        timeSlots[50] = "12:30pm - 12:45pm";
        timeSlots[51] = "12:45pm - 1:00pm";
        timeSlots[52] = "1:00pm - 1:15pm";
        timeSlots[53] = "1:15pm - 1:30pm";
        timeSlots[54] = "1:30pm - 1:45pm";
        timeSlots[55] = "1:45pm - 2:00pm";
        timeSlots[56] = "2:00pm - 2:15pm";
        timeSlots[57] = "2:15pm - 2:30pm";
        timeSlots[58] = "2:30pm - 2:45pm";
        timeSlots[59] = "2:45pm - 3:00pm";
        timeSlots[60] = "3:00pm - 3:15pm";
        timeSlots[61] = "3:15pm - 3:30pm";
        timeSlots[62] = "3:30pm - 3:45pm";
        timeSlots[63] = "3:45pm - 4:00pm";
        timeSlots[64] = "4:00pm - 4:15pm";
        timeSlots[65] = "4:15pm - 4:30pm";
        timeSlots[66] = "4:30pm - 4:45pm";
        timeSlots[67] = "4:45pm - 5:00pm";
        timeSlots[68] = "5:00pm - 5:15pm";
        timeSlots[69] = "5:15pm - 5:30pm";
        timeSlots[70] = "5:30pm - 5:45pm";
        timeSlots[71] = "5:45pm - 6:00pm";

        timeSlots[72] = "6:00pm - 6:15pm";
        timeSlots[73] = "6:15pm - 6:30pm";
        timeSlots[74] = "6:30pm - 6:45pm";
        timeSlots[75] = "6:45pm - 7:00pm";
        timeSlots[76] = "7:00pm - 7:15pm";
        timeSlots[77] = "7:15pm - 7:30pm";
        timeSlots[78] = "7:30pm - 7:45pm";
        timeSlots[79] = "7:45pm - 8:00pm";
        timeSlots[80] = "8:00pm - 8:15pm";
        timeSlots[81] = "8:15pm - 8:30pm";
        timeSlots[82] = "8:30pm - 8:45pm";
        timeSlots[83] = "8:45pm - 9:00pm";
        timeSlots[84] = "9:00pm - 9:15pm";
        timeSlots[85] = "9:15pm - 9:30pm";
        timeSlots[86] = "9:30pm - 9:45pm";
        timeSlots[87] = "9:45pm - 10:00pm";
        timeSlots[88] = "10:00pm - 10:15pm";
        timeSlots[89] = "10:15pm - 10:30pm";
        timeSlots[90] = "10:30pm - 10:45pm";
        timeSlots[91] = "10:45pm -11:00pm";
        timeSlots[92] = "11:00pm - 11:15pm";
        timeSlots[93] = "11:15pm - 11:30pm";
        timeSlots[94] = "11:30pm - 11:45pm";
        timeSlots[95] = "11:45pm - 12:00am";

    }
}
