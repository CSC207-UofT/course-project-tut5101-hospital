package Controllers.Appointment;

import UseCases.Patient.PatientManager;

import java.util.Scanner;

public class PayFee {

    PatientManager pm;

    public PayFee(){
        this.pm = PatientManager.getInstance();
    }

    /**
     * Pay the Booking fee of a patient
     */
    public void payBookingFee(long hcn, String c) {
        if (c.equals("1")) {
            System.out.println("How much do you want to add");
            Scanner scanner = new Scanner(System.in);
            int addFee = scanner.nextInt();
            scanner.nextLine();
            pm.getPatient(hcn).addFee(addFee);
            System.out.println("Move on to the appointment");
        } else if (c.equals("2")) {
            System.out.println("Move on to the appointment");
        }
    }

    /**
     *  See some of the options and the money in the account
     * @param hcn health card number
     */
    public void view(long hcn){
        System.out.println("This is the money in your account: $ " + pm.getPatient(hcn).getFee());
        System.out.println("Do you want to add money (Type 1 to add, Type 2 to not add)");
    }
}
