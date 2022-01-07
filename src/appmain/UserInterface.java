package appmain;

import java.sql.SQLException;
import java.util.Scanner;

import customer.BuyProduct;
import dao.LoginDetailsDao;
import daoimpl.LoginDetailsDaoImpl;
import model.UserDetails;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println("***********Welcome to food Order System****************");
		
		
		System.out.println("1: Sign up");
		System.out.println("2: Sign In");
		System.out.println("3: Exit");
		System.out.println("*************************************************************");
		char ch=' ';
		LoginDetailsDao LoginDao=new LoginDetailsDaoImpl();
		String username,firstname,lastname,password, location, mobileno;
		
		do {
			System.out.println("What you do wish to check from the above list");
		
		
			Scanner sn=new Scanner(System.in);
			int option=sn.nextInt();
		
			switch(option)
			{
				
				
				case 1:System.out.println("enter the details to signup");
						username=sn.next();
						firstname=sn.next();
						lastname=sn.next();
						password=sn.next();
						location=sn.next();
						mobileno=sn.next();
						UserDetails user=new UserDetails();
						user.setUsername(username);
						user.setFirstName(firstname);
						user.setLastName(lastname);
						user.setLocation(location);
						user.setMobileno(mobileno);
			            user.setPassword(password);
						
					LoginDao.signUp(user);
					
					 /*create table userdetails(
					 username varchar(20) primary key,
					 password varchar(20) not null,
					 firstname varchar(20) not null,
					 lastname varchar(20),
					 location varchar(20),
					 mobileno varchar(10) not null
					 )
					 */
					
					break;
				case 2:
					System.out.println("enter the username and password to login");
					String usern=sn.next();
					String pass=sn.next();
					UserDetails details=new UserDetails();
					details.setUsername(usern);
					details.setPassword(pass);
					boolean res=LoginDao.signIn(details);
					if(res)
					{
						System.out.println("login success");
					System.out.println("What you do wish to check from the below list");
					/*System.out.println("1:Add Order");
					System.out.println("2:Delete Order");*/
					char o = 0;
					do{
						System.out.println("1:Add Order");
						System.out.println("2:Delete Order");
						System.out.println("3:View Details");
						System.out.println("Enter the Choice");
						int choice8=sn.nextInt();

						switch(choice8)
						{
						case 1:
							BuyProduct bb;
							try {
								try {
									bb = new BuyProduct ();
									bb.Buy();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							break;
						case 2:
							try {
								try {
									bb = new BuyProduct ();
									bb.Delete();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case 3:
							BuyProduct bb1;
							try {
								try {
									bb1 = new BuyProduct();
									bb1.ViewDetails();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;       
						default:System.out.println("Invalid Choice");
						}
						System.out.println("Do you Want again add or Delete items or View Details");
						o=sn.next().charAt(0);
					}
					while(o=='y');
					
			
			}
					else
					{
						
						System.out.println("login failed");
					}
					break;
					
				case 3:
					System.exit(0);
				default: System.out.println("enter the valid option");
		}	
		System.out.println("Do you wish to check other options");
		ch=sn.next().charAt(0);
		
		}
	while(ch=='y'||ch=='Y');
		
	}
	

}



