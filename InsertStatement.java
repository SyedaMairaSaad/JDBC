package practice;

import java.sql.*;

public class InsertStatement {
	public static void main(String[] arg) {

		String url = "jdbc:mysql://localhost:3306/javadb";
		String userName = "root";
		String password = "Qwerty12345";
		String query = "insert into persons values (?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, userName, password);
			// below statement can be used for one by one insertion but not recoomened
			// Statement st=con.createStatement();
			// insit of abov use prepareStatement
			PreparedStatement st = con.prepareStatement(query);
			// for insert update user executeUpdate
			st.setInt(1, 3);
			st.setString(2, "Unaiza");
			st.setString(3, "Saad");
			st.setString(4, "Pakistan");
			st.setString(5, "Karachi");
			int rowCount = st.executeUpdate();
			System.out.print(rowCount+" Records Inserted");

			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
