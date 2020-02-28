package se.chalmers.dm;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class Seeder {

    private int countId = 0;
    private Faker faker;
    private Connection connection;
    private Random random;
    private PreparedStatement statement;

    public Seeder (Faker faker, Connection connection, Random random){
        this.faker = faker;
        this.connection = connection;
        this.random = random;
    }

    public void createUserTable(){
        try {
            statement = connection.prepareStatement(QueryHelper.sqlQuery("create_user_table.sql"));
            statement.execute();
            statement.close();
        }catch(Exception e){
            System.out.println("Seeder failure");
        }

    }

    public void insertFakeUsers(int amount) {
        try {
            statement = connection.prepareStatement(QueryHelper.sqlQuery("insert_user.sql"));

            for (int i = 0; i < amount; i++) {
                statement.setString(1,faker.idNumber().ssnValid());
                statement.setString(2,faker.name().firstName());
                statement.setString(3,faker.name().lastName());
                statement.setString(4,faker.internet().emailAddress());
                statement.setBoolean(5,faker.bool().bool());
                statement.addBatch();
            }
            statement.executeBatch();
            statement.close();
            countId += amount;

        }catch (Exception e){
            System.out.println("Oops, error in adding fake users");
        }

    }

    public void createWebPageTable(){
        try {
            statement = connection.prepareStatement(QueryHelper.sqlQuery("create_webpage_table.sql"));
            statement.execute();
            statement.close();
        }catch(Exception e){
            System.out.println("Seeder failure");
        }
    }

    public void insertFakeUsersWithWebPage(int amount) {
        try {
            insertFakeUsers(amount);
            countId -= amount;
            statement = connection.prepareStatement(QueryHelper.sqlQuery("insert_webpage.sql"));

            for(int j = 0; j < amount; j++){
                statement.setString(1, faker.internet().url());
                statement.setInt(2, ++countId);
                statement.setString(3, faker.chuckNorris().fact());
                statement.setInt(4, faker.number().numberBetween(0,100));
                statement.addBatch();
            }
            statement.executeBatch();
            statement.close();


        }catch (Exception e){
            System.out.println("Oops, error in adding users with webpages.");
        }


    }
}
