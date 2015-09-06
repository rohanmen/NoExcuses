package noexcuses.venkat.noexcuses.Workouts;

import java.util.ArrayList;

/**
 * Created by Ahmed on 4/28/2015.
 */
public class QuickWorkoutList {
    private ArrayList<QuickWorkout> quickWorkoutList;

    public QuickWorkoutList() {
        makeQuickWorkouts();
    }

    private void makeQuickWorkouts() {
        quickWorkoutList = new ArrayList<QuickWorkout>();
        quickWorkoutList.add(qW1());
        quickWorkoutList.add(qW2());
        quickWorkoutList.add(qW3());
        quickWorkoutList.add(qW4());
        quickWorkoutList.add(qW5());
    }

    public ArrayList<QuickWorkout> getQuickWorkouts() {
        return quickWorkoutList;
    }

    private QuickWorkout qW1() {
        //INITIALIZATIONS
        QuickWorkout quickWorkout = new QuickWorkout();
        Movement movement = new Movement();

        //Movement 1
        movement.setName("Pushups");
        movement.setAmount("10");
        movement.setTimes("2");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        quickWorkout.addMovement(movement);

        //Movement 2
        movement = new Movement();
        movement.setName("Jumping Jacks");
        movement.setAmount("20");
        movement.setTimes("3");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        quickWorkout.addMovement(movement);

        //Movement 3
        movement = new Movement();
        movement.setName("Spider Lunges");
        movement.setAmount("10");
        movement.setTimes("4");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        quickWorkout.addMovement(movement);

        //Movement 4
        movement = new Movement();
        movement.setName("Walkouts");
        movement.setAmount("10");
        movement.setTimes("3");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        quickWorkout.addMovement(movement);

        //setting QuickWorkout
        quickWorkout.setName("Pushups N' Things");
        quickWorkout.setLength("10");

        return quickWorkout;
    }

    private QuickWorkout qW2() {
        //INITIALIZATIONS
        QuickWorkout quickWorkout = new QuickWorkout();
        Movement movement = new Movement();

        //Movement 1
        movement.setName("Jumping Lunges");
        movement.setAmount("10");
        movement.setTimes("5");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        quickWorkout.addMovement(movement);

        //Movement 2
        movement = new Movement();
        movement.setName("Spider Lunges");
        movement.setAmount("10");
        movement.setTimes("4");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        quickWorkout.addMovement(movement);

        //Movement 3
        movement = new Movement();
        movement.setName("Pushups");
        movement.setAmount("10");
        movement.setTimes("2");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        quickWorkout.addMovement(movement);

        //Movement 4
        movement = new Movement();
        movement.setName("Walkouts");
        movement.setAmount("10");
        movement.setTimes("5");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        quickWorkout.addMovement(movement);

        //setting QuickWorkout
        quickWorkout.setName("Lunges Galore");
        quickWorkout.setLength("15");

        return quickWorkout;
    }

    private QuickWorkout qW3() {
        //INITIALIZATIONS
        QuickWorkout quickWorkout = new QuickWorkout();
        Movement movement = new Movement();

        //Movement 1
        movement.setName("Plank");
        movement.setAmount("1");
        movement.setTimes("2");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        quickWorkout.addMovement(movement);

        //Movement 2
        movement = new Movement();
        movement.setName("Situps");
        movement.setAmount("20");
        movement.setTimes("3");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        quickWorkout.addMovement(movement);

        //setting QuickWorkout
        quickWorkout.setName("Core Focus");
        quickWorkout.setLength("10");

        return quickWorkout;
    }

    private QuickWorkout qW4() {
        //INITIALIZATIONS
        QuickWorkout quickWorkout = new QuickWorkout();
        Movement movement = new Movement();

        //Movement 1
        movement.setName("Wall Sits");
        movement.setAmount("1");
        movement.setTimes("3");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        quickWorkout.addMovement(movement);

        //Movement 2
        movement = new Movement();
        movement.setName("Ab Twisters");
        movement.setAmount("25");
        movement.setTimes("4");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        quickWorkout.addMovement(movement);

        //Movement 3
        movement = new Movement();
        movement.setName("Crunches");
        movement.setAmount("10");
        movement.setTimes("2");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        quickWorkout.addMovement(movement);

        //setting QuickWorkout
        quickWorkout.setName("Leg and Core");
        quickWorkout.setLength("10");

        return quickWorkout;
    }

    private QuickWorkout qW5() {
        //INITIALIZATIONS
        QuickWorkout quickWorkout = new QuickWorkout();
        Movement movement = new Movement();

        //Movement 1
        movement.setName("Burpees");
        movement.setAmount("10");
        movement.setTimes("2");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        quickWorkout.addMovement(movement);

        //Movement 2
        movement = new Movement();
        movement.setName("Run in Place");
        movement.setAmount("1");
        movement.setTimes("3");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        quickWorkout.addMovement(movement);

        //setting QuickWorkout
        quickWorkout.setName("Quick Heart");
        quickWorkout.setLength("5");

        return quickWorkout;
    }
}
