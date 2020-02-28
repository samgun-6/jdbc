package se.chalmers.dm;

import com.github.javafaker.Bool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Queries {

    private PreparedStatement statement;

    public List<User> findInactiveUsers(Connection connection) {
        List<User> inactiveUsers = new ArrayList<>();
        try {
            statement = connection.prepareStatement(QueryHelper.sqlQuery("find_inactive_users.sql"));
            ResultSet result = statement.executeQuery();

            if(result != null){
                while(result.next()) {
                    int id = result.getInt(1);
                    String ssn = result.getString(2);
                    String fname = result.getString(3);
                    String lname = result.getString(4);
                    String email = result.getString(5);
                    Boolean isActive = result.getBoolean(6);
                    User user = new User(id, ssn, fname, lname, email, isActive);
                    inactiveUsers.add(user);
                }
            }
        }catch (Exception e){
            System.out.println("Oops, error in finding inactive users.");
        }

        return inactiveUsers;
    }

    public List<String> findSpecialQuotes(Connection connection) {
        List<String> quotes = new ArrayList<>();
        try {
            statement = connection.prepareStatement(QueryHelper.sqlQuery("find_special_quotes.sql"));
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                quotes.add(result.getString(1));
            }

        }catch(Exception e){
            System.out.println("Oops, error in finding quotes.");
        }
        return quotes;
    }
}
