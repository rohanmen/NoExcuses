package noexcuses.venkat.noexcuses.Workouts;

import java.io.Serializable;

/**
 * Created by Venkat on 4/14/15.
 */
public class Movement implements Serializable
{
    private String reps;

    private String weight;

    private String name;

    private String sets;

    private String amount;

    private String times;

	private MuscleGroup mainMuscleGroup;

    public String getAmount ()
    {
        return amount;
    }

    public void setAmount (String amount)
    {
        this.amount = amount;
    }


    public String getReps ()
    {
        return reps;
    }



    public void setReps (String reps)
    {
        this.reps = reps;
    }

    public String getWeight ()
    {
        return weight;
    }

    public void setWeight (String weight)
    {
        this.weight = weight;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getSets ()
    {
        return sets;
    }

    public void setSets (String sets)
    {
        this.sets = sets;
    }

    public String getTimes() { return times; }

    public void setTimes(String times) { this.times = times; }

    @Override
    public String toString()
    {
        return "MOVEMENT [reps = "+reps+", weight = "+weight+", name = "+name+", sets = "+sets+"]";
    }

	public void setMainMuscleGroup(MuscleGroup muscleGroup)
	{
		this.mainMuscleGroup = muscleGroup;
	}

	public MuscleGroup getMainMuscleGroup()
	{
		return this.mainMuscleGroup;
	}
}

