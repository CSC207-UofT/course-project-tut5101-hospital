package Patients;

import java.util.HashMap;

import Exceptions.StuffNotFoundException;

import java.io.*;

public class PatientData implements java.io.Serializable {
    private HashMap<Integer,Patient> patients;
    //init
    public PatientData() {
        patients = new HashMap<>();
        loadData();
    }



    //add, modify, remove Patients
    public void add_or_modify_Patient(Patient patient) {
        // add the patient if it is not already in, modify it if it is already in
        //the database. 
        if (!patients.containsKey(patient.getHealthCardNum())) {
            patients.put(patient.getHealthCardNum(), patient);
        }
    }public void removePatient(Patient patient) throws StuffNotFoundException{
        if (!patients.containsKey(patient.getHealthCardNum())) {
            patients.remove(patient.getHealthCardNum());
        }else{
            throw new StuffNotFoundException("");
        }
    }



    //view and search patients
    public String viewPatient(Patient patient) {
        if (!patients.containsKey(patient.getHealthCardNum())) {
            return patients.get(patient.getHealthCardNum()).getPatientInfo();
        }else{
            return "Patient not found";
        }}
    public Patient searchHCN(int healthCardNum) {
        if (!patients.containsKey(healthCardNum)) {
            return patients.get(healthCardNum);
        } else{
            return null;
        }  
    }



    //load and save data
    public void saveData(){
        try {
            FileOutputStream fileOut =
            new FileOutputStream("patients.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
    }private void loadData(){
        PatientData pd = null;
      try {
         FileInputStream fileIn = new FileInputStream("patients.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         pd = (PatientData) in.readObject();
         in.close();
         fileIn.close();
         this.patients=pd.patients;
      } catch (IOException e){
        e.printStackTrace();
      } catch (ClassNotFoundException e){
        e.printStackTrace();
      }
    }
    

    
}