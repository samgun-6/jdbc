package se.chalmers.dm;

import com.github.javafaker.Faker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class Seeder {

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
            statement = connection.prepareStatement(QueryHelper.sqlQuery("create_fake_user.sql"));

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

        }catch (Exception e){
            System.out.println("oops");
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

    public void insertFakeUsersWithWebPage(int i) {

    }
}
