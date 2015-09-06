package noexcuses.venkat.noexcuses.Workouts;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import noexcuses.venkat.noexcuses.FitnessUserInformation;
import noexcuses.venkat.noexcuses.WorkoutXMLDriver;
import schedule.Util;


/**
 * Created by Ahmed on 4/21/2015.
 */
public class FitnessUserRoutine{

    Context context;
    private FitnessUserInformation user;
    private Workout workout; //best workout
    private ArrayList<Workout> availableWorkouts; //workouts that fit the schedule
    private HashMap<Workout,Integer> availableWorkoutGaps; //gaps from available workouts
    private HashMap<String,Integer> greatestDayGaps; //gaps in user's schedule
    private HashMap<String,String> greatestDayTimes; //time frames related to gaps in schedule

    //This constructor goes through the list of available workouts and gets the greatest time gaps
    //in the user's schedule. It then compares the time range of the workout to the user's greatest
    //time gaps. If they fit within a range, it chooses that workout. Needs more ironing out.
    public FitnessUserRoutine(Context context, FitnessUserInformation user) {
        this.context = context;
        this.user = user;
        greatestDayTimes = new HashMap<String,String>();
        greatestDayGaps = obtainTimes();
        availableWorkouts = obtainWorkouts();
        workout = getBestWorkout();
    }

    public Workout getWorkout() {
        return workout;
    }
    public ArrayList<Workout> getListOfWorkouts() {
        return availableWorkouts;
    }
    public HashMap<String,String> getGreatestDayTimes() { return greatestDayTimes; }

    //gets the list of available workouts
    private ArrayList<Workout> obtainWorkouts() {
        availableWorkoutGaps = new HashMap<Workout,Integer>();
        ArrayList<Workout> fitWorkouts = new ArrayList<Workout>(); //workouts that fit the user's schedule
        WorkoutList workoutList = new WorkoutList();
        int dayCount = 0;
        for (Workout w : workoutList.getWorkouts()) {
            if (Long.parseLong(w.getConcentration()) == user.getConcentration()) {
                for (String s : Util.getDaysOfWeek()) {
                    if (Integer.parseInt(w.getLength()) <= (greatestDayGaps.get(s) * 15)) {
                        w.addWorkoutDay(s);
                        dayCount++;
                        availableWorkoutGaps.put(w, (greatestDayGaps.get(s) * 15) - Integer.parseInt(w.getLength()));
                    }
                }
                if (dayCount >= Integer.parseInt(w.getDays())) {
                    fitWorkouts.add(w);
                }
            }
            dayCount = 0;
        }
        return fitWorkouts;
    }

    //gets the greatest time gap of each day in the user's schedule
    private HashMap<String,Integer> obtainTimes() {
        HashMap<String,Integer> days = new HashMap<String,Integer>();
        int greatestGap;
        int gap;
        int timeStart = 0;
        StringBuilder timeString = new StringBuilder(); //string with the actual slot from gap
        for (String s : Util.getDaysOfWeek()) {
            greatestGap = 0;
            gap = 0;
            boolean times[] = Util.getScheduleFromDatabase(s, context);
            for (int i = 0; i < 96; i++) { //after 7:00 am
                if (times[i] == true) {
                    if (gap > greatestGap) {
                        timeString = new StringBuilder();
                        greatestGap = gap;
                        timeString.append(Util.getTimeSlots()[timeStart]);
                        timeString.append(Util.getTimeSlots()[timeStart + gap - 1]); //actual time gap in string form, unparsed
                        gap = 0;
                        timeStart = 0;
                    }
                }
                else {
                    if (timeStart == 0) {
                        timeStart = i;
                    }
                    gap++;
                }
            }
            days.put(s, greatestGap);
            greatestDayTimes.put(s, parseTimeString(timeString).toString());
            timeString = new StringBuilder();
        }
        return days;
    }

    private Workout getBestWorkout() {
        Workout best = new Workout();
        best.setConcentration("-1");
        for (Workout w : availableWorkouts) {
            if (best.getConcentration().equals("-1")) {
                best = w;
            }
            else {
                if (availableWorkoutGaps.get(w) < availableWorkoutGaps.get(best)) {
                    best = w;
                }
            }
        }
        return best;
    }

    private StringBuilder parseTimeString(StringBuilder timeString) {
        boolean hitDash = false; //did you hit a dash, if so, delete up to next dash to have continuous time
        for (int i = timeString.length() - 1; i >= 0; i--) {
            if (timeString.charAt(i) == '-') {
                hitDash = !hitDash;
                i--;
            }
            if (hitDash == true) {
                timeString.deleteCharAt(i);
            }
        }
        return timeString;
    }
}
