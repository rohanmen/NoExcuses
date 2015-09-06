package noexcuses.venkat.noexcuses.DatabaseSchema;

import com.google.gson.Gson;
import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import noexcuses.venkat.noexcuses.GlobalDefinitions;

/**
 * Created by Venkat on 4/22/15.
 */
public class WorkoutDatabaseEntry extends SugarRecord<WorkoutDatabaseEntry> implements Serializable {

    public String workoutName;
    public int currentWorkoutWeight;
    public String stringArr;

    public String userName = GlobalDefinitions.activeUserName;
    //public ArrayList<Integer> pastWorkoutWeights = new ArrayList<Integer>();
    public int[] pastWorkoutWeights = new int[0];




   // public PastWeights pastWorkoutWeights;
    public WorkoutDatabaseEntry(){

    }
    public WorkoutDatabaseEntry(String name, int currentWeight, String userName){  //create the object
        this.workoutName = name;
        this.currentWorkoutWeight = currentWeight;
        //pastWorkoutWeights = new ArrayList<Integer>();
        pastWorkoutWeights = new int[0];
        stringArr = new Gson().toJson(pastWorkoutWeights);
        this.userName = userName;

    }

    private void addElement(int e) {
        pastWorkoutWeights  = Arrays.copyOf(pastWorkoutWeights, pastWorkoutWeights.length + 1);
        pastWorkoutWeights[pastWorkoutWeights.length - 1] = e;
    }

    public void newWeight(int newWeight){
        pastWorkoutWeights = new Gson().fromJson(stringArr, int[].class);
        if(currentWorkoutWeight!=0) {
            addElement(currentWorkoutWeight);
        }
        currentWorkoutWeight = newWeight;
        addElement(currentWorkoutWeight);
        stringArr = new Gson().toJson(pastWorkoutWeights);
    }
    public int getCurrentWeight(){
        return currentWorkoutWeight;
    }

    public int[] getWeightHistory(){
        return new Gson().fromJson(stringArr, int[].class);
    }

    public String getName(){
        return workoutName;
    }

}
