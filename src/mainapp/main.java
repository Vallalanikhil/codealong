package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("1.Register ");
		System.out.println("2.Login");
		int x;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		x=Integer.parseInt(br.readLine());
		
		RegisterPojo registerpojo=new RegisterPojo();
		RegisterDAO registerdao=new RegisterDAO();
		LoginPojo loginpojo=new LoginPojo();
		LoginDAO logindao=new LoginDAO();
		
		
		switch(x)
		{
		case 1:
			System.out.println("Enter the first name");
			String firstname=br.readLine();
			System.out.println("Enter the last name");
			String lastname=br.readLine();
			System.out.println("Enter the user name");
			String username=br.readLine();
			System.out.println("Enter the Email");
			String email=br.readLine();
			System.out.println("Enter the password");
			String password=br.readLine();
			
			
			registerpojo.setFirstname(firstname);
			registerpojo.setLastname(lastname);
			registerpojo.setUsername(username);
			registerpojo.setPassword(password);
			registerpojo.setEmail(email);
			
			registerdao.addUser(registerpojo);
			break;
		case 2:
			System.out.println("Enter the user name");
			String user=br.readLine();
			System.out.println("Enter the password");
			String pass=br.readLine();
			
			loginpojo.setUsername(user);
			loginpojo.setPassword(pass);
			
			if(logindao.validate(loginpojo)==true)
			{
				Luck luck=new Luck();
				luck.display();
			}
			else
				System.out.println("incorrect username/password");
			break;
		}

	}

}
