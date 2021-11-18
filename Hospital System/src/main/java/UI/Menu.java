package UI;

import java.util.Scanner;

import Exceptions.InvalidInputException;
import UseCases.PatientScheduleManager;
import Controllers.LoginSignup;
public class Menu{
    Scanner s = new Scanner(System.in);
    int hcn;
    LoginSignup ls = new LoginSignup();
    public Menu(){
        
    }public void greeter(){
        System.out.println("Welcome to RealFakeHospital");
    }
    public void loginSignup(){

        int hcn =0;
        System.out.println("Sign up or login(1/2)");

        String c = s.nextLine();
        if(c.equals("2")){
            boolean success = false;

            do{
                System.out.println("Input HealthCardNumber");
                hcn = s.nextInt();
                s.nextLine();
                System.out.println("Input password");
                String ipt_pwd = s.nextLine();
                success= ls.logIn(hcn, ipt_pwd);
                if(!success){
                    System.out.println("Login failed, enter 1 to switch to sign up instead");
                    int k=s.nextInt();
                    s.nextLine();
                    if(k==1){
                        c="1";
                        break;
                    }
                }
            }while(!success);

        }if(c.equals("1")){
            System.out.println("Input name");
            String name = s.nextLine();
            System.out.println("Input gender");
            String gender = s.nextLine();
            System.out.println("Input contact number");
            int ctctNum = s.nextInt();
            s.nextLine();
            System.out.println("Input health card number");
            hcn = s.nextInt();
            s.nextLine();
            System.out.println("Input password");
            String pwd = s.nextLine();
            ls.signUp(name, gender, ctctNum, hcn, pwd);
            //System.out.println(ls.check_if_patient_exists(hcn));
        }
        this.hcn=hcn;

    }public void activities(){
            //System.out.println(ls.check_if_patient_exists(hcn));
            String c="1";
            System.out.println("Make or view appointments(1/2)");
            c = s.nextLine();
            if(c.equals("1")){
                makeAppointment();
            }if(c.equals("2")){
                viewAppointment();
            }
        }
    private void makeAppointment() {
        System.out.println(ls.check_if_patient_exists(hcn));
        PatientScheduleManager sm = new PatientScheduleManager(ls.initPatient(hcn).getSchedule());
        System.out.println("Input event");
        String event = s.nextLine();
        System.out.println("Input start time yyyy-MM-dd HH:mm");
        String start = s.nextLine();
        System.out.println("Input end time yyyy-MM-dd HH:mm");
        String end = s.nextLine();
        try {
            sm.add_or_modify_Event(event, start, end);
        } catch (InvalidInputException e) {
            System.out.println("Input is invalid");
        }
        
    }private void viewAppointment() {
        PatientScheduleManager sm = new PatientScheduleManager(ls.initPatient(hcn).getSchedule());
        System.out.println(sm.getScheduleString());
    }
}