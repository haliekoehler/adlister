import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by HKoehler on 2/6/17.
 */
public class PasswordExample {

    public static void main(String[] args) {
        int numberOfRounds = 12;

        int randomSalt = 0;
        for (int i = 0; i < numberOfRounds; i++){
            randomSalt = generateRandomSalt(randomSalt);
            // a random value calculated by the bcrypt algorithm
        }

        String plainTextPassword = "mypassword"; // this is coming from the form
        String hash = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(numberOfRounds));

        System.out.println(plainTextPassword);
        System.out.println(hash);

        // doPost in Login
        // this is in our database
        // hash = "j;lwjelkjlksjdg"

        boolean passwordsDoMatch = BCrypt.checkpw(plainTextPassword, hash);

    }
}
