/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.swing.JOptionPane;

public class db {
    
    public static Connection mycon() {
        
        Connection con = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pos","root","");
            //JOptionPane.showMessageDialog(null, "Database connected");
            return con;
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
    }
}

        
    

