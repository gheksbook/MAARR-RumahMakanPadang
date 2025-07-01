/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseConnection;

public class UserSession {
    private static String loggedInUsername;
    private static String loggedInUserId; 
    public static void setLoggedInUser(String username, String userId) {
        loggedInUsername = username;
        loggedInUserId = userId;
    }

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    public static String getLoggedInUserId() {
        return loggedInUserId;
    }

    public static void clearSession() {
        loggedInUsername = null;
        loggedInUserId = null;
    }
}
