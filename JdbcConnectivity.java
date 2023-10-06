package practice;
// 1- import package
import java.sql.*;

/*
1- import package
2- set Driver
3- set connection 
4-Prepare statment
5-Executer Query
6-Process result
7-close connections and drivers
*/

public class JdbcConnectivity {
	public static void main(String[] arg) throws ClassNotFoundException {
		//start with driver setting (step 2) clause to understand
		//for url : jdbc.mysql is to know you are making jdbc connection to mysql database
		//as database could be on other server as well so connet using ://
		//out server is localhost and default port of mysql database is 3306
		//than /DATABASE_NAME
		String url="jdbc:mysql://localhost:3306/javadb";
		String userName="root";
		String password="Qwerty12345";
		
		
		String query ="select firstName from persons where PersonID=1";

		
		
		//2- step 2: set Driver 
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			//3- set connection : you need url , user name,password here
			Connection con=DriverManager.getConnection(url, userName, password);
			//4- Prepare statment
			Statement st=con.createStatement();
			//5-Executer Query
			ResultSet rs= st.executeQuery(query);
			
			
			//6- Process result
			//use re.next() to fix exception of  java.sql.SQLException: Before start of result set
			rs.next();
			System.out.println(rs.getString("firstName"));
			//7- step 7 close connections statment and connection both
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
