package Entity.Schedule;
/**
 * This file contains the map of the hospital and is used to hold all the rooms in the building
 * <p>
 * import java.io.BufferedReader;
 * import java.io.FileReader;
 * import java.io.IOException;
 * import java.io.BufferedReader;
 * import java.io.FileReader;
 * import java.io.IOException;
 * import java.io.BufferedReader;
 * import java.io.FileReader;
 * import java.io.IOException;
 **/

/**import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException; **/

import java.util.*;


public class Map implements java.io.Serializable {
    private final HashMap<String, String> PatientRooms;
    private final HashMap<String, String> Rooms;

    public Map(HashMap<String, String> rooms, HashMap<String, String> patientRooms) {
        this.Rooms = rooms;
        this.PatientRooms = patientRooms;
    }

    public HashMap<String, String> getPatientRooms() {
        return PatientRooms;
    }

    public HashMap<String, String> getRooms() {
        return Rooms;
    }

/**    public static void main( String[] args ) throws IOException
 {
 String maptxt = "map.txt";  // all rooms will be imported from a txt file following the format of room number:purpose
 HashMap<String, String> rooms = new HashMap<String, String>();

 String line;
 BufferedReader reader = new BufferedReader(new FileReader(maptxt));
 while ((line = reader.readLine()) != null)
 {
 String[] parts = line.split(":", 2);
 if (parts.length >= 2)
 {
 String key = parts[0];
 String value = parts[1];
 rooms.put(key, value);
 } else {
 System.out.println("ignoring line: " + line);
 }
 }
 } **/
}
