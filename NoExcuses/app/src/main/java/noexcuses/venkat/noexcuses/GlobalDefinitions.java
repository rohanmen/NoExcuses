package noexcuses.venkat.noexcuses;

import android.content.Context;

import com.google.android.gms.fitness.Fitness;

import noexcuses.venkat.noexcuses.Workouts.FitnessUserRoutine;
import noexcuses.venkat.noexcuses.Workouts.Workout;

/**
 * Created by Venkat on 4/22/15.
 */
public class GlobalDefinitions {


    public static Context currentApplicationContext = null;

    //Active User Definitions
    public static String activeUserName = null;
    public static String activeUserPass = null;

    public static FitnessUserInformation currentUser = null;

    public static FitnessUserRoutine fitnessUser = null;
    public static Workout currentWorkout = null;

    private GlobalDefinitions(){

    }


}
