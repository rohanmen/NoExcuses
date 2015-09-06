package noexcuses.venkat.noexcuses;

import java.io.File;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Unmarshaller;

import noexcuses.venkat.noexcuses.Workouts.Workout;

/**
 * Created by Venkat on 4/13/15.
 */
public class WorkoutXMLDriver {

    File XMLFile = null;
    public WorkoutXMLDriver(File activeFile){
        this.XMLFile = activeFile;      //Pass in the file path using the constructor

    }

    public Workout getObjectFromXML() {          //call this to get the object back
//        try {
//
//
//            JAXBContext jaxbContext = JAXBContext.newInstance(Workout.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            Workout activeWork = (Workout) jaxbUnmarshaller.unmarshal(XMLFile);
//            return activeWork;
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
        return null;
    }



}
