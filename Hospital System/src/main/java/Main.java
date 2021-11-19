import UI.Menu;

public class Main {
        public static void main(String[] args){
            Menu menu = new Menu();
            menu.greeter();
            menu.loginSignup();
            menu.activities();
        }

/*     public static void main(String[] args) {
        Schedule test;
        test = new Schedule("sdf");
        test.printTimeTable();
        System.out.println("Press 1 if you are a staff. Press 2 if you are a patient.");
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        int n = reader.nextInt(); // Scans the next token of the input as an int. once finished
        if (n == 1){
            System.out.println("Press 1 for appointment. Press 2 for check in. Press 3 for result.");
            int n1 = reader.nextInt(); // Scans the next token of the input as an int. once finished
            System.out.println("Wait to exit. Not Implemented yet.");
            reader.close();
        }
        else if(n == 2){
            System.out.println("Press 1 for schedule. Press 2 for result.");
            int n2 = reader.nextInt(); // Scans the next token of the input as an int. once finished
            System.out.println("Wait to exit. Not Implemented yet.");
            reader.close();
        }
        else{
            System.out.println("Wrong key please try again.");
            System.exit(0);
        }
    } */
}