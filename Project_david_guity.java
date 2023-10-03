import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project_david_guity
{
     //input and output
   public static void main(String[] args) 
   {
      Scanner scanner = new Scanner(System.in);
   
      System.out.print("Please enter the Policy Number: ");
      String policyNumber = scanner.nextLine();
   
      System.out.print("Please enter the Provider Name: ");
      String providerName = scanner.nextLine();
   
      System.out.print("Please enter the Policyholder’s First Name: ");
      String firstName = scanner.nextLine();
   
      System.out.print("Please enter the Policyholder’s Last Name: ");
      String lastName = scanner.nextLine();
   
      System.out.print("Please enter the Policyholder’s Age: ");
      int age = scanner.nextInt();
      scanner.nextLine();
   
      System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
      String smokingStatus = scanner.nextLine();
   
      System.out.print("Please enter the Policyholder’s Height (in inches): ");
      double height = scanner.nextDouble();
   
      System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
      double weight = scanner.nextDouble();
   
      Policy policy = new Policy(policyNumber, providerName, firstName, lastName,
                                age, smokingStatus, height, weight);
   
      System.out.println("Policy Number: " + policy.getPolicyNumber());
      System.out.println("Provider Name: " + policy.getProviderName());
      System.out.println("Policyholder’s First Name: " + policy.getPolicyholderFirstName());
      System.out.println("Policyholder’s Last Name: " + policy.getPolicyholderLastName());
      System.out.println("Policyholder’s Age: " + policy.getPolicyholderAge());
      System.out.println("Policyholder’s Smoking Status: " + policy.getSmokingStatus());
      System.out.println("Policyholder’s Height: " + policy.getHeight() + " inches");
      System.out.println("Policyholder’s Weight: " + policy.getWeight() + " pounds");
      System.out.println("Policyholder’s BMI: " + policy.calculateBMI());
      System.out.println("Policy Price: $" + policy.calculatePolicyPrice());
   
      scanner.close();
      // Read policy information from file
      Policy[] policies = readPoliciesFromFile("CSC251Project/PolicyInformation.txt");
   
           
        // Display the number of smokers and non-smokers
      int smokerCount = countSmokers(policies);
      int nonSmokerCount = policies.length - smokerCount;
      System.out.println("The number of policies with a smoker is: " + smokerCount);
      System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
   }

    // Method to read policy information from file
   private static Policy[] readPoliciesFromFile(String filename) {
      Policy[] policies = null;
      try {
         File file = new File(filename);
         Scanner scanner = new Scanner(file);
      
         int policyCount = 0;
         while (scanner.hasNextLine()) {
            scanner.nextLine();
            policyCount++;
         }
      
         scanner.close();
         policies = new Policy[policyCount];
         scanner = new Scanner(file);
      
         int index = 0;
         while (scanner.hasNextLine()) {
            int policyNumber = Integer.parseInt(scanner.nextLine());
            String providerName = scanner.nextLine();
            String firstName = scanner.nextLine();
            String lastName = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());
            String smokingStatus = scanner.nextLine();
            double height = Double.parseDouble(scanner.nextLine());
            double weight = Double.parseDouble(scanner.nextLine());
         
            policies[index] = new Policy(policyNumber, providerName, firstName, lastName,
                                age, smokingStatus, height, weight);
         
            index++;
         }
      
         scanner.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   
      return policies;
   }

    // Method to display policy information
   private static void displayPolicyInformation(Policy policy) {
      System.out.println("Policy Number: " + policy.getPolicyNumber());
      System.out.println("Provider Name: " + policy.getProviderName());
      System.out.println("Policyholder's First Name: " + policy.getPolicyholderFirstName());
      System.out.println("Policyholder's Last Name: " + policy.getPolicyholderLastName());
      System.out.println("Policyholder's Age: " + policy.getPolicyholderAge());
      System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
      System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
      System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
      System.out.println("Policyholder's BMI: " + policy.calculateBMI());
      System.out.println("Policy Price: $" + policy.calculatePolicyPrice());
      System.out.println();
   }

    // Method to count the number of smokers
   private static int countSmokers(Policy[] policies) {
      int count = 0;
      for (Policy policy : policies) {
         if (policy.getSmokingStatus().equals("smoker")) {
            count++;
         }
      }
      return count;
   }
}