package noexcuses.venkat.noexcuses;

/**
 * Created by Venkat on 3/27/15.
 */
public class FitnessUserInformation implements java.io.Serializable, Information {

    private String name;
    private String age;
    private String currentWeight;
    private String targetWeight;
    private long concentration;   //1: cardio (weightloss), 2: cardio (maintenance), 3: powerlifting, 4: str training, 5:bodybuilding

    public void setConcentration(long concentration) {
        this.concentration = concentration;
    }

    public long getWorkoutPartner() {
        return workoutPartner;
    }

    public void setWorkoutPartner(long workoutPartner) {
        this.workoutPartner = workoutPartner;
    }

    public long getIntensity() {
        return intensity;
    }

    public void setIntensity(long intensity) {
        this.intensity = intensity;
    }

    public String getLengthOfWorkout() {
        return lengthOfWorkout;
    }

    public void setLengthOfWorkout(String lengthOfWorkout) {
        this.lengthOfWorkout = lengthOfWorkout;
    }

    private long workoutPartner;    //1: no workout partner, 0: there is a workout partner
    private long intensity;     //1: Low Intensity, 2: Medium Intensity, 3: High Intensity
    private String lengthOfWorkout;

    public FitnessUserInformation(String name, String age, String currentWeight, String targetWeight, long concentration, long workoutPartner, long intensity, String lengthOfWorkout) {
        this.name = name;
        this.age = age;
        this.currentWeight = currentWeight;
        this.targetWeight = targetWeight;
        this.concentration = concentration;
        this.workoutPartner = workoutPartner;
        this.intensity = intensity;
        this.lengthOfWorkout = lengthOfWorkout;
    }


    //Getters and Setters for the user information
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(String currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(String targetWeight) {
        this.targetWeight = targetWeight;
    }

    public long getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }
}
