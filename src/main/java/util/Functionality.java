package util;

import Dao.EmployeeManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

public class Functionality
{
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    PreparedStatement preparedStatement;
    void save() throws ClassNotFoundException, SQLException, IOException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate_demo","root","varansi2011");
        String query="INSERT INTO EmployeeManagement(id,name,salary) values(?,?,?)";
        preparedStatement= connection.prepareStatement(query);
        System.out.println("Enter your id");
        int id=Integer.parseInt(bufferedReader.readLine());
        System.out.println("Enter name");
        String name=bufferedReader.readLine();
        System.out.println("Enter salary");
        float salary=Float.parseFloat(bufferedReader.readLine());
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setFloat(3,salary);
        preparedStatement.executeUpdate();
    }
  void delete(int id) throws SQLException, ClassNotFoundException
  {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate_demo","root","varansi2011");
        String query="Delete from EmployeeManagement where id=?";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
    void update(float salary, int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate_demo","root","varansi2011");
        String query= "Update EmployeeManagement set salary=? where id=?";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setFloat(1,salary);
        preparedStatement.setInt(2,id);
        preparedStatement.executeUpdate();
    }
    void get(int id) throws ClassNotFoundException, SQLException
    {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate_demo","root","varansi2011");
        String query="SELECT * from EmployeeManagement where id=?";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,id);
        ResultSet resultSet=preparedStatement.executeQuery();
      while (resultSet.next())
      {
          System.out.println(" id "+ resultSet.getInt(1)+" name "+ resultSet.getString(2)+" Salary "+resultSet.getFloat(3));
      }

    }
    void getAll() throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernate_demo","root","varansi2011");
        String query="SELECT * from EmployeeManagement ";
        preparedStatement=connection.prepareStatement(query);
        ResultSet resultSet=preparedStatement.executeQuery();
        while (resultSet.next())
        {
            System.out.println(" id "+ resultSet.getInt(1)+" name "+ resultSet.getString(2)+" Salary "+resultSet.getFloat(3));
        }
    }

}
