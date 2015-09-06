package noexcuses.venkat.noexcuses.Workouts;

import java.util.ArrayList;

/**
 * Created by Ahmed on 4/26/2015.
 */
public class WorkoutList {
    /*
    Concentrations:
    -0: Cardio (Weightloss)
    -1: Cardio (Maintenance)
    -2: Powerlifting
    -3: Strength Training
    -4: Bodybuilding

    Workouts made so far:
    -Swimming/1 Con/60 Min/5 Days
    -Running/0 Con/45 Min/4 Days
    -Mini Power/4 Con/70 Min/2 Days
    -StrongLifts/3 Con/90 Min/3 Days
    -Power Beginner/2 Con/65 Min/3 Days
    -Intense 30/4 Con/30 Min/5 Days
    -Swimming/0 Con/20 Min/3 Days
    -Running/1 Con/25 Min/2 Days
    -Strength Density/3 Con/40 Min/3 Days
    -Westside Barbell/2 Con/35 Min/4 Days
    -Boxing/0 Con/60 Min/2 Days
    -Boxing/1 Con/45 Min/3 Days
    -Power Body/2 Con/45 Min/5 Days
    -Quick Strength/3 Con/25 Min/4 Days
    -Varying BodyBuild/4 Con/45 Min/4 Days
     */
    private ArrayList<Workout> workouts;

    public WorkoutList() {
        makeWorkouts();
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    private void makeWorkouts() {
        workouts = new ArrayList<Workout>();
        workouts.add(makeSwimming1());
        workouts.add(makeRunning1());
        workouts.add(makeMiniPower());
        workouts.add(makeStrongLifts());
        workouts.add(makePowerBeginner());
        workouts.add(makeIntense30());
        workouts.add(makeSwimming2());
        workouts.add(makeRunning2());
        workouts.add(makeStrengthDensity());
        workouts.add(makeWestsideBarbell());
        workouts.add(makeBoxing1());
        workouts.add(makeBoxing2());
        workouts.add(makePowerBody());
        workouts.add(makeQuickStrength());
        workouts.add(makeVaryingBodyBuild());
    }

    private Workout makeSwimming1() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        movement.setName("Distance");
        movement.setAmount("1000");
        movement.setTimes("1");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Sprint");
        movement.setAmount("25");
        movement.setTimes("15");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Distance");
        movement.setAmount("1100");
        movement.setTimes("1");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 4
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Sprint");
        movement.setAmount("25");
        movement.setTimes("20");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 5
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Distance");
        movement.setAmount("1200");
        movement.setTimes("1");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Swimming");
        workout.setConcentration("1");
        workout.setLength("60");
        workout.setDays("5");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeRunning1() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        movement.setName("Distance");
        movement.setAmount("1");
        movement.setTimes("1");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Sprint");
        movement.setAmount("0.1");
        movement.setTimes("5");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Distance");
        movement.setAmount("1");
        movement.setTimes("1");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 4
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Sprint");
        movement.setAmount("0.1");
        movement.setTimes("5");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Running");
        workout.setConcentration("0");
        workout.setLength("45");
        workout.setDays("4");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeMiniPower() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Squat");
        movement.setSets("3");
        movement.setReps("5");
        movement.setWeight("50");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Lunges");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("10");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Stiff Deadlift");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("120");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Calf Raises");
        movement.setSets("3");
        movement.setReps("15");
        movement.setWeight("50");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 5
        movement = new Movement();
        movement.setName("Hanging Leg Raises");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("50");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Close Grip Bench");
        movement.setSets("3");
        movement.setReps("5");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Overhead Press");
        movement.setSets("3");
        movement.setReps("5");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Kroc Rows");
        movement.setSets("3");
        movement.setReps("15");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Pullups");
        movement.setSets("3");
        movement.setReps("0");
        movement.setWeight("0");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 5
        movement = new Movement();
        movement.setName("Dumbbell Curls");
        movement.setSets("3");
        movement.setReps("12");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.BICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Minimalist Power");
        workout.setConcentration("4");
        workout.setLength("70");
        workout.setDays("2");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeStrongLifts() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Squat");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("55");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Bench");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Barbell Row");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("50");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Squat");
        movement.setSets("5");
        movement.setReps("5");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movement.setWeight("60");
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Overhead Press");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Deadlift");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("110");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Squat");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("60");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Bench");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Barbell Row");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("55");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("StrongLifts 5x5");
        workout.setConcentration("3");
        workout.setLength("90");
        workout.setDays("3");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makePowerBeginner() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Squat");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("55");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Front Squat");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Butt Lift (Bridge)");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("0");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Seated Calf Raise");
        movement.setSets("3");
        movement.setReps("0");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Bench - Medium Grip");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("65");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Dumbbell Bench Press");
        movement.setSets("2");
        movement.setReps("8");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Bench - Close Grip");
        movement.setSets("3");
        movement.setReps("5");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Triceps Pushdown");
        movement.setSets("2");
        movement.setReps("10");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Deadlift");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("95");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Upright Barbell Row");
        movement.setSets("3");
        movement.setReps("6");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Hyper Extensions");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("10");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Barbell Curl");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.BICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Power Beginner");
        workout.setConcentration("2");
        workout.setLength("65");
        workout.setDays("3");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeIntense30() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Barbell Curl");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.BICEPS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Seated Triceps Press");
        movement.setSets("3");
        movement.setReps("0");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Cable Curl");
        movement.setSets("1");
        movement.setReps("25");
        movement.setWeight("10");
		movement.setMainMuscleGroup(MuscleGroup.BICEPS);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Side Lateral Raise");
        movement.setSets("1");
        movement.setReps("10");
        movement.setWeight("8");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Front Dumbbell Raise");
        movement.setSets("1");
        movement.setReps("10");
        movement.setWeight("8");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Bent-Over Rear Delt Raise");
        movement.setSets("1");
        movement.setReps("10");
        movement.setWeight("10");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Bench - Medium Grip");
        movement.setSets("2");
        movement.setReps("20");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Incline Dumbbell Press");
        movement.setSets("1");
        movement.setReps("50");
        movement.setWeight("12");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Cable Crossover");
        movement.setSets("1");
        movement.setReps("50");
        movement.setWeight("15");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Pushups");
        movement.setSets("1");
        movement.setReps("100");
        movement.setWeight("0");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 4
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Seated Cable Rows");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("25");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Close-Grip Front Lat Pulldown");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Hyper Extensions");
        movement.setSets("1");
        movement.setReps("0");
        movement.setWeight("10");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 5
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Leg Press");
        movement.setSets("2");
        movement.setReps("25");
        movement.setWeight("50");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Lying Leg Curls");
        movement.setSets("2");
        movement.setReps("25");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Calf Raise");
        movement.setSets("3");
        movement.setReps("20");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Intense 30");
        workout.setConcentration("4");
        workout.setLength("30");
        workout.setDays("5");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeSwimming2() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        movement.setName("Distance");
        movement.setAmount("2000");
        movement.setTimes("1");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Sprint");
        movement.setAmount("50");
        movement.setTimes("10");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Distance");
        movement.setAmount("2100");
        movement.setTimes("1");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Swimming");
        workout.setConcentration("0");
        workout.setLength("20");
        workout.setDays("3");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeRunning2() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        movement.setName("Distance");
        movement.setAmount("0.5");
        movement.setTimes("1");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        movement = new Movement();
        day = new Day();
        movement.setName("Sprint");
        movement.setAmount("0.2");
        movement.setTimes("3");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Running");
        workout.setConcentration("1");
        workout.setLength("25");
        workout.setDays("2");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeStrengthDensity() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Squat");
        movement.setSets("4");
        movement.setReps("6");
        movement.setWeight("55");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Deadlift");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("95");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Leg Extensions");
        movement.setSets("2");
        movement.setReps("10");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Ab Roller");
        movement.setSets("2");
        movement.setReps("10");
        movement.setWeight("0");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Bench");
        movement.setSets("4");
        movement.setReps("6");
        movement.setWeight("55");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Bent Over Dumbbell Row");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Cable Rows");
        movement.setSets("3");
        movement.setReps("12");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Standing Military Press");
        movement.setSets("5");
        movement.setReps("6");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Rear Delt Raise");
        movement.setSets("4");
        movement.setReps("12");
        movement.setWeight("15");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Situps");
        movement.setSets("2");
        movement.setReps("25");
        movement.setWeight("0");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Strength Density");
        workout.setConcentration("3");
        workout.setLength("40");
        workout.setDays("3");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeWestsideBarbell() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Box Squat");
        movement.setSets("2");
        movement.setReps("8");
        movement.setWeight("55");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Hyperextension");
        movement.setSets("4");
        movement.setReps("8");
        movement.setWeight("10");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Bent-Knee Good Morning");
        movement.setSets("2");
        movement.setReps("6");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Bench");
        movement.setSets("2");
        movement.setReps("8");
        movement.setWeight("65");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Lever Reverse Fly");
        movement.setSets("2");
        movement.setReps("8");
        movement.setWeight("15");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Barbell Upright Row");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("55");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Deadlift (with bands)");
        movement.setSets("6");
        movement.setReps("3");
        movement.setWeight("95");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Box Jumps");
        movement.setSets("4");
        movement.setReps("4");
        movement.setWeight("0");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Cable Standing Crunch");
        movement.setSets("6");
        movement.setReps("10");
        movement.setWeight("0");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 4
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Dumbbell Bench Press");
        movement.setSets("2");
        movement.setReps("6");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Lever Seated Row");
        movement.setSets("3");
        movement.setReps("6");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Dumbbell Shoulder Press");
        movement.setSets("2");
        movement.setReps("8");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Westside Barbell");
        workout.setConcentration("2");
        workout.setLength("35");
        workout.setDays("4");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeBoxing1() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Jump Rope");
        movement.setSets("3");
        movement.setReps("40");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Speed Bag");
        movement.setSets("3");
        movement.setReps("20");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Heavy Bag");
        movement.setSets("2");
        movement.setReps("25");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Lateral Leap/Hop");
        movement.setSets("4");
        movement.setReps("20");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Pushup");
        movement.setSets("6");
        movement.setReps("0");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Heavy Bag");
        movement.setSets("2");
        movement.setReps("25");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Boxing");
        workout.setConcentration("0");
        workout.setLength("60");
        workout.setDays("2");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeBoxing2() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Jump Rope");
        movement.setSets("2");
        movement.setReps("40");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Speed Bag");
        movement.setSets("2");
        movement.setReps("20");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Heavy Bag");
        movement.setSets("1");
        movement.setReps("25");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Lateral Leap/Hop");
        movement.setSets("3");
        movement.setReps("20");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Pushup");
        movement.setSets("3");
        movement.setReps("0");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Heavy Bag");
        movement.setSets("1");
        movement.setReps("25");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Speed Bag");
        movement.setSets("2");
        movement.setReps("25");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Situp");
        movement.setSets("3");
        movement.setReps("30");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Heavy Bag");
        movement.setSets("1");
        movement.setReps("20");
		movement.setMainMuscleGroup(MuscleGroup.CORE);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Boxing");
        workout.setConcentration("1");
        workout.setLength("45");
        workout.setDays("3");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makePowerBody() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Incline Bench");
        movement.setSets("6");
        movement.setReps("5");
        movement.setWeight("60");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Dumbbell Bench Press");
        movement.setSets("4");
        movement.setReps("10");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Incline Dumbbell Flys");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("15");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Squat");
        movement.setSets("7");
        movement.setReps("3");
        movement.setWeight("75");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Leg Press");
        movement.setSets("5");
        movement.setReps("10");
        movement.setWeight("90");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Leg Extensions");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("35");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Standing Shoulder Press");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("50");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Upright Barbell Row");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("50");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Side Lateral Raise");
        movement.setSets("4");
        movement.setReps("12");
        movement.setWeight("10");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 4
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Barbell Curl");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.BICEPS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Dumbbell Curl");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.BICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Lying Triceps Press");
        movement.setSets("4");
        movement.setReps("8");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Triceps Pushdown");
        movement.setSets("4");
        movement.setReps("8");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 5
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Deadlift");
        movement.setSets("7");
        movement.setReps("2");
        movement.setWeight("95");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("One-Arm Dumbbell Row");
        movement.setSets("5");
        movement.setReps("10");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Wide-Grip Lat Pulldown");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("40");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Power Body");
        workout.setConcentration("2");
        workout.setLength("45");
        workout.setDays("5");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeQuickStrength() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Deadlift");
        movement.setSets("3");
        movement.setReps("6");
        movement.setWeight("85");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Bench");
        movement.setSets("3");
        movement.setReps("6");
        movement.setWeight("55");
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Squat");
        movement.setSets("3");
        movement.setReps("7");
        movement.setWeight("60");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Bent Over Row");
        movement.setSets("3");
        movement.setReps("10");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Overhead Press");
        movement.setSets("3");
        movement.setReps("8");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Rear Delt Raise");
        movement.setSets("4");
        movement.setReps("12");
        movement.setWeight("15");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 4
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Squat");
        movement.setSets("3");
        movement.setReps("7");
        movement.setWeight("65");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Bench");
        movement.setSets("3");
        movement.setReps("55");
        movement.setWeight("15");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Quick Strength");
        workout.setConcentration("3");
        workout.setLength("25");
        workout.setDays("4");
        workout.setRoutine(routine);

        return workout;
    }

    private Workout makeVaryingBodyBuild() {
        //INITIALIZATIONS
        Workout workout = new Workout();
        Routine routine = new Routine();
        ArrayList<Day> days = new ArrayList<Day>();
        Day day = new Day();
        ArrayList<Movement> movements = new ArrayList<Movement>();
        Movement movement = new Movement();

        //MOVEMENT/DAY SETUP
        //Day 1
        //Movement 1
        movement.setName("Incline Bench");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("50");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Dumbbell Bench");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("15");
		movement.setMainMuscleGroup(MuscleGroup.CHEST);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Bench Dip");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("0");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Tricep Extensions");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        Movement temp[] = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 2
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Barbell Row");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("45");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Dumbbell Row");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("15");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Preacher Curl");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("30");
		movement.setMainMuscleGroup(MuscleGroup.BICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 3
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Shoulder Press");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Side Lateral Raise");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("12");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Barbell Shrug");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("60");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);
        //Movement 4
        movement = new Movement();
        movement.setName("Arnold Dumbbell Press");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("20");
		movement.setMainMuscleGroup(MuscleGroup.TRICEPS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);
        //Day 4
        movements.clear();
        day = new Day();
        //Movement 1
        movement = new Movement();
        movement.setName("Squat");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("85");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);
        //Movement 2
        movement = new Movement();
        movement.setName("Romanian Deadlifts");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("95");
		movement.setMainMuscleGroup(MuscleGroup.BACK);
        movements.add(movement);
        //Movement 3
        movement = new Movement();
        movement.setName("Leg Extensions");
        movement.setSets("5");
        movement.setReps("5");
        movement.setWeight("40");
		movement.setMainMuscleGroup(MuscleGroup.LEGS);
        movements.add(movement);

        temp = movements.toArray(new Movement[movements.size()]);
        day.setMovement(temp);
        days.add(day);

        //ROUTINE SETUP
        routine.setDay(days.toArray(new Day[days.size()]));

        //WORKOUT SETUP
        workout.setName("Varying BodyBuild");
        workout.setConcentration("4");
        workout.setLength("45");
        workout.setDays("4");
        workout.setRoutine(routine);

        return workout;
    }

}
