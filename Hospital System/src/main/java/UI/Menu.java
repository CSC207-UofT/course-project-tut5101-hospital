package UI;

import java.util.Scanner;

import Exceptions.InvalidInputException;
import Schedule.Schedule;
import UseCases.ScheduleManager;
import Controllers.LoginSignup;
public class Menu{
    Scanner s = new Scanner(System.in);
    int hcn;
    int id;
    LoginSignup ls = new LoginSignup();
    public Menu(){
        
    }public void greeter(){
        System.out.println("Welcome to RealFakeHospital");
    }
    public void loginSignupForPatient(){

        int hcn =0;
        System.out.println("Sign up or login (Type 1 for sign up; Type 2 for login)");

        String c = s.nextLine();
        if(c.equals("2")){
            boolean success = false;

            do{
                System.out.println("Input HealthCardNumber");
                hcn = s.nextInt();
                if (ls.check_if_patient_exists(hcn)) {
                    s.nextLine();
                } else {
                    System.out.println("You do not have an account, enter 1 to switch to sign up instead");
                    int k=s.nextInt();
                    s.nextLine();
                    if(k==1) {
                        c = "1";
                        break;
                    }
                }
                System.out.println("Input password");
                String ipt_pwd = s.nextLine();
                success= ls.LoginForPatients(hcn, ipt_pwd);
                while (!success){
                    System.out.println("Login failed due to incorrect password, please enter 2 to try again. If you forgot your password, enter 3");
                    int k=s.nextInt();
                    s.nextLine();
                    if(k==2) {
                        c = "2";
                        break;
                    } if (k==3) {
                        System.out.println("Input contact number");
                        int contactNum = s.nextInt();
                        System.out.println("You will be contacted by a staff in the next 48 hours to retrieve your password.");
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
            ls.signUpForPatients(name, gender, ctctNum, hcn, pwd);
            System.out.println("Patient account successfully created");
        }
        this.hcn=hcn;

    }

    public void loginSignupForStaff(){

        int id =0;
        System.out.println("Sign up or login (Type 1 for sign up; Type 2 for login)");

        String c = s.nextLine();
        if(c.equals("2")){
            boolean success = false;

            do{
                System.out.println("Input id");
                id = s.nextInt();
                if (ls.check_if_patient_exists(id)) {
                    s.nextLine();
                } else {
                    System.out.println("You do not have an account, enter 1 to switch to sign up instead");
                    int k=s.nextInt();
                    s.nextLine();
                    if(k==1) {
                        c = "1";
                        break;
                    }
                }
                System.out.println("Input password");
                String ipt_pwd = s.nextLine();
                success= ls.LoginForStaffs(id, ipt_pwd);
                while (!success){
                    System.out.println("Login failed due to incorrect password, please enter 2 to try again. If you forgot your password, enter 3");
                    int k=s.nextInt();
                    s.nextLine();
                    if(k==2) {
                        c = "2";
                        break;
                    } if (k==3) {
                        System.out.println("Input id");
                        int idForRetrieve = s.nextInt();
                        System.out.println("You will be notified by management in the next 48 hours to retrieve your password.");
                    }
                }
            }while(!success);

        }if(c.equals("1")){
            System.out.println("Input name");
            String name = s.nextLine();
            System.out.println("Input gender");
            String gender = s.nextLine();
            System.out.println("Input id");
            id = s.nextInt();
            s.nextLine();
            System.out.println("Input password");
            String pwd = s.nextLine();
            System.out.println("Input base salary");
            int salary = s.nextInt();
            /*This is not done yet
            TODO: Find a way to add in Working time
             */
            //ls.signUpForStaffs(name, gender, id, pwd, salary);
            System.out.println("Staff account successfully created");
        }
        this.id=id;

    }

    public void activities(){
            //System.out.println(ls.check_if_patient_exists(hcn));
            String c="1";
            System.out.println("Make or view appointments(Type 1 to make an appointment; Type 2 to view existing appointments)");
            c = s.nextLine();
            if(c.equals("1")){
                makeAppointment();
            }if(c.equals("2")){
                viewAppointment();
            }
        }
    private void makeAppointment() {
        System.out.println(ls.check_if_patient_exists(hcn));
        ScheduleManager sm = new ScheduleManager(ls.initPatient(hcn).getSchedule());
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
        if (sm.getScheduleString() != null) {
            System.out.println("You have successfully booked an appointment");
        }

    }private void viewAppointment() {
        ScheduleManager sm = new ScheduleManager(ls.initPatient(hcn).getSchedule());
        System.out.println(sm.getScheduleString());
    }
}