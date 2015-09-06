package noexcuses.venkat.noexcuses.Workouts;

/**
 * Created by Ahmed on 5/10/2015.
 */
public class WorkoutChunk {
    private Workout workout;
    private QuickWorkout quickWorkout;
    private String workoutText;

    public WorkoutChunk() {
        workout = new Workout();
        quickWorkout = new QuickWorkout();
    }

    public Workout getWorkout() {
        return workout;
    }
    public String getWorkoutText() {
        return workoutText;
    }
    public QuickWorkout getQuickWorkout() {
        return quickWorkout;
    }
    public void setWorkout(Workout workout) {
        this.workout = workout;
    }
    public void setWorkoutText(String workoutText) {
        this.workoutText = workoutText;
    }
    public void setQuickWorkout(QuickWorkout quickWorkout) {
        this.quickWorkout = quickWorkout;
    }
}
