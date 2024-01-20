// This code is almost impossible to write meaningfully test cases against,
//it need to be refactored into at least two methods.


import java.util.Scanner;

public class InsuranceProgram {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int basicInsurance = 500;
        int surcharge = 100; // under 25 years
        
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        if(age < 25) {
            basicInsurance += surcharge; 
            System.out.println("Additional surcharge " + surcharge);
            
            System.out.print("\nHow many accidents did you have? ");
            int accidents = input.nextInt();
            
            switch (accidents) {
                case 0: System.out.println("No surcharge");
                        System.out.println("Total amount to pay: " + basicInsurance);
                        break;
                case 1: System.out.println("Additional surcharge for accident: " + 50 + " \ntotal amount to pay: " + (basicInsurance + 50)); // Pay 650
                break;
                case 2: System.out.println("Additional surcharge for accident: " + 125 + " \ntotal amount to pay: " + (basicInsurance + 125)); // Pay 725
                break; 
                case 3: System.out.println("Additional surcharge for accident: " + 225 + " \ntotal amount to pay: " + (basicInsurance + 225)); // Pay 825
                break;
                case 4: System.out.println("Additional surcharge for accident: " + 375 + " \ntotal amount to pay: " + (basicInsurance + 375)); // Pay 975
                break;
                case 5: System.out.println("Additional surcharge for accident: " + 575 + " \ntotal amount to pay: " + (basicInsurance + 575)); // Pay 1175
                break;
            }
            
            if(accidents > 6)
                System.out.println("No insurance");
        } 
        
        if (age >= 25) {
            System.out.println("No additional surcharge");
            System.out.print("\nHow many accidents did you have? ");
            int accidents = input.nextInt();
            
            switch (accidents) {
                case 0: System.out.println("No surcharge");
                        System.out.println("Total amount to pay: " + basicInsurance);
                        break;
                case 1: System.out.println("Additional surcharge for accident: " + 50 + " \ntotal amount to pay: " + (basicInsurance + 50)); // Pay 550
                break;
                case 2: System.out.println("Additional surcharge for accident: " + 125 + " \ntotal amount to pay: " + (basicInsurance + 125)); // Pay 625;
                break; 
                case 3: System.out.println("Additional surcharge for accident: " + 225 + " \ntotal amount to pay: " + (basicInsurance + 225)); // Pay 725;
                break;
                case 4: System.out.println("Additional surcharge for accident: " + 375 + " \ntotal amount to pay: " + (basicInsurance + 375)); // Pay 875;
                break;
                case 5: System.out.println("Additional surcharge for accident: " + 575 + " \ntotal amount to pay: " + (basicInsurance + 575)); // Pay 1075;
                break;
            }
            
            if(accidents > 6)
                System.out.println("No insurance");
        }
    }
}