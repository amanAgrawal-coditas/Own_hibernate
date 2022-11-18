package util;

import Dao.EmployeeManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MainApplication
{
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static Functionality functionality = new Functionality();
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException
    {
        while (true)
        {
        System.out.println("Press 0 for exit");
        System.out.println("Press 1 for delete");
        System.out.println("Press 2 for insert ");
        System.out.println("Press 3 for update salary");
        System.out.println("Press 4 for retrieve by id");
        System.out.println("Press 5 for retrieve all");
        System.out.println("enter your choice");
        int choice = Integer.parseInt(bufferedReader.readLine());

            switch (choice) {
                case 0: {
                    System.exit(0);
                    break;
                }
                case 1: {
                    System.out.println("Enter the id you want to delete");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    functionality.delete(id);
                    System.out.println("Successfully deleted");
                    break;
                }
                case 2: {
                    functionality.save();
                    break;
                }
                case 3: {
                    System.out.println("Enter the id");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("Select new salary");
                    float salary = Float.parseFloat(bufferedReader.readLine());
                    functionality.update(salary, id);
                    System.out.println("Updated salary");
                    break;
                }
                case 4:
                {
                    System.out.println("Enter your id");
                    int id = Integer.parseInt(bufferedReader.readLine());
                    functionality.get(id);
                    break;
                }
                case 5:
                {
                    functionality.getAll();
                    break;
                }
                default: {
                    System.out.println("Wrong input");
                }
            }
        }
    }
}
