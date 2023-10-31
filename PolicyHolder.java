import java.util.ArrayList;

public class PolicyHolder {
      private String policyholderFirstName;
      private String policyholderLastName;
      private int policyholderAge;
      private String smokingStatus;
      private double height;
      private double weight;
      private ArrayList<Policy> policies;
   
   
    // Constructors, getters, setters, and other methods

    @Override
    public String toString() {
        return "Policy Number: " + policy.getPolicyNumber
               "\nProvider Name: " + policy.getProviderName
               "\nPolicyholder’s First Name: " + policy.getPolicyholderFirstName
               "\nPolicyholder’s Last Name: " + policy.getPolicyholderLastName
               "\nPolicyholder’s Age: " + policy.getPolicyholderAge
               "\nPolicyholder’s Smoking Status: " + policy.getSmokingStatus
               "\nPolicyholder’s Height: " + policy.getHeight() + " inches"
               "\nPolicyholder’s Weight: " + policy.getWeight() + " pounds"
               "\nPolicyholder’s BMI: " + policy.calculateBMI
               "\nPolicy Price: $" + policy.calculatePolicyPrice  
       }
}