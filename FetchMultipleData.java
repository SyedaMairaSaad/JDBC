package practice;
import java.sql.*;


public class FetchMultipleData {
	public static void main(String[] arg) throws ClassNotFoundException {
		
		String url="jdbc:mysql://localhost:3306/javadb";
		String userName="root";
		String password="12345";		
		String query ="select firstName,lastName from persons;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
			Connection con=DriverManager.getConnection(url, userName, password);
			Statement st=con.createStatement();		
			ResultSet rs= st.executeQuery(query);			
			
			
			while(rs.next()) {
			System.out.println("First Name: "+rs.getString(1)+" Last Name: "+rs.getString(2));
			}
			
			st.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
