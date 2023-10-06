package practice;
import java.sql.*;


class Person{
	private int personId;	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
class personDAO{
	public Person getPerson(int personID) {
		String url = "jdbc:mysql://localhost:3306/javadb";
		String userName = "root";
		String password = "Qwerty12345";
		String query ="select * from persons where PersonID="+personID;
		Person p=new Person();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection(url,userName,password);
			Statement st=con.createStatement();
			
			ResultSet result=st.executeQuery(query);
			result.next();
			
			p.setPersonId(personID);
			p.setFirstName(result.getString(2));
			p.setLastName(result.getString(3));
			p.setAddress(result.getString(4));
			p.setCity(result.getString(5));
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException  e1) {		
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return p;
		
	}
}
public class DaoJdbc {
	
	public static void main(String[] arg) {
		personDAO dao=new personDAO();
		Person person =dao.getPerson(2);
		System.out.println(person.getFirstName());
	}

}
