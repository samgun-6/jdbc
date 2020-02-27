package se.chalmers.dm;

import com.github.javafaker.Faker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class Seeder {

    private Faker faker;
    private Connection connection;
    private Random random;

    public Seeder(Faker faker, Connection connection, Random random) {
        this.faker = faker;
        this.connection = connection;
        this.random = random;
    }

    public void createUserTable(){
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("create_user_table.sql");
            System.out.println(rs);
            rs.close();
            stmt.close();
        }catch(Exception e){
            System.out.println("Seeder failure");
        }

    }
}
