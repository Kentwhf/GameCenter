//package a207project.fall18.GameCenter;
//
//
//
//import android.support.annotation.NonNull;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.*;
//
//// Based on Lindsey Shorer's code on quercus under lecture notes week 7
//// https://q.utoronto.ca/courses/67371/files/folder/Lecture%20Notes/Week%207/Lindsey
//
///**
// * Manages user accounts
// */
//public class UserAccountManager implements java.io.Serializable {
//
//    /**
//     * A hashmap of user accounts
//     */
//    private Map<String, UserAccount> userAccounts;
//
//
//    /**
//     * A logger
//     */
//    private static final Logger logger =
//            Logger.getLogger(UserAccountManager.class.getName());
//
//
//    /**
//     * Dependency injection constructor for UserAccountManager
//     *
//     * @param userAccounts the map containing the usernames and users
//     */
//    UserAccountManager(Map<String, UserAccount> userAccounts) {
//        this.userAccounts = userAccounts;
//    }
//
//
//    /**
//     * Returns whether the creation of new user is successful or not
//     *
//     * @param user the user
//     * @return user creation success
//     */
//    boolean addNewUser(UserAccount user) {
//        // Log the addition of a user.
//        String usernameToFind = user.getUsername();
//        if (! findUsername(usernameToFind)) {
//            logger.log(Level.FINE, "Added a new user " + user.toString());
//            userAccounts.put(usernameToFind, user);
//            return true;
//        }
//        return false;
//        //return true if successful, false if not
//    }
//
//    /**
//     * Returns whether login is successful.
//     *
//     * @param username the username
//     * @param password the user's password
//     * @return login success
//     */
//    boolean login(String username, String password) {
//        if (findUsername(username)) {
//            String fetchedPassword = getUser(username).getPassword();
//            return password.equals(fetchedPassword);
//        } else {
//            return false;
//        }
//    }
//
//
//    /**
//     * Return a user that corresponds to the username
//     *
//     * @param username the user to find
//     * @return UserAccount
//     * Precondition: Assume the user exists
//     */
//    private UserAccount getUser(String username) {
//        return this.userAccounts.get(username);
//    }
//
//
//    /**
//     * Return whether the username of a user within the userAccounts hashmap exists
//     *
//     * @param username the user to find
//     * @return UserAccount
//     */
//    private boolean findUsername(String username) {
//        return userAccounts.containsKey(username);
//    }
//
//
//    @NonNull
//    @Override
//    public String toString() {
//        StringBuilder result = new StringBuilder();
//        for (UserAccount value : userAccounts.values()) {
//            result.append(value.toString()).append("\n");
//        }
//        return result.toString();
//    }
//
//
//}




