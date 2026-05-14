package day3;


public class SecureSocialProfile {

    private String username;
    private String password;
    private int followersCount;
    private boolean isPrivate;

    public SecureSocialProfile(String name, String pass) {
        this.username = name;
        this.password = pass;
        this.followersCount = 0; 
        this.isPrivate = true; 
    }

    public String getUsername() {
        return username;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void updatePassword(String oldPass, String newPass) {

        if (this.password.equals(oldPass)) {

            if (newPass.length() >= 6) {
                this.password = newPass;
                System.out.println("✅ Success: Password updated.");
            } else {
                System.out.println("❌ Error: New password is too short (Minimum 6).");
            }
        } else {
            System.out.println("❌ Error: Wrong old password! You cannot change it.");
        }
    }

    public void addFollower() {
        this.followersCount++; 
    }

    public static void main(String[] args) {
        
        SecureSocialProfile myProfile = new SecureSocialProfile("java_pro", "secure123");

        System.out.println("--- 🛡️ SECURE PROFILE SYSTEM ---");

        System.out.println("Attempting password update...");
        myProfile.updatePassword("wrong_pass", "hacked!"); 
        myProfile.updatePassword("secure123", "new_strong_pass"); 

        myProfile.addFollower(); // Adds 1 follower safely
        
        System.out.println("\nFinal Followers: " + myProfile.getFollowersCount());
        System.out.println("Username: " + myProfile.getUsername());
        
        System.out.println("\n💡 CONCLUSION: Encapsulation makes our code SAFE and BUG-FREE!");
    }
}
