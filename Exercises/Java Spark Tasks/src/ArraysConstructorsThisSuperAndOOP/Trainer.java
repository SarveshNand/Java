package ArraysConstructorsThisSuperAndOOP;

public class Trainer extends User{
    String subject;

    Trainer(String name, String email, String subject) {
        super(name, email);
        this.subject = subject;
    }

    @Override
    void showProfile() {
        super.showProfile();
        System.out.println("Subject: " + subject);
    }
}
