package customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BuyProduct implements CustomerInfo {
	Scanner sc=new Scanner(System.in);
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	
	public BuyProduct() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
	     connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/edubridgeproject","root","Moksh@12");
	     statement=connection.createStatement();	
	}
	
	//Interface Implementation
	@Override
	public void Buy() {
		// TODO Auto-generated method stub
	

	     String insert = "",insert1 = "",insert2="",insert3="",insert4="",insert5="",insert6="";
	     int product_id;	
		String product_name;
		int product_price;
		
		System.out.println("Which Food do You Want to Buy");
		System.out.println("1.Pizza");
		System.out.println("2.Burger");
		System.out.println("3.Cake");
		System.out.println("4.Sandwich");
		System.out.println("5.Pasta");
		System.out.println("6.Bisleri");
		System.out.println("7.Cold Drinks");

		char c = 0;
		do{
			System.out.println("What Do  You Want Purchase Items Above List");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				product_id=1;
				product_name="Pizza";
				product_price=250;
				
				insert=product_id +"                              "+product_name +"                            " +product_price;
				//System.out.println(insert);
				String insert7="insert into customer1 values(";
				insert7=insert7+product_id;
				insert7=insert7+ ", '"+product_name+"'";
				insert7=insert7+ ", "+product_price+");";			
				try {
					statement.executeUpdate(insert7);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;

			case 2:
				product_id=2;
				product_name="Burger";
				product_price=200;
				insert1=product_id +"                              "+product_name+"                         " +product_price;
				//System.out.println(insert);
				String insert8="insert into customer1 values(";
				insert8=insert8+product_id;
				insert8=insert8+ ", '"+product_name+"'";
				insert8=insert8+ ", "+product_price+");";
				try {
					statement.executeUpdate(insert8);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 3:
				product_id=3;
				product_name="Cake";
				product_price=400;
				
				insert3=product_id +"                              "+product_name +"                            " +product_price;
				//System.out.println(insert);
				String insert9="insert into customer1 values(";
				insert9=insert9+product_id;
				insert9=insert9+ ", '"+product_name+"'";
				insert9=insert9+ ", "+product_price+");";		
				try {
					statement.executeUpdate(insert9);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4:
				product_id=4;
				product_name="Sandwich";
				product_price=500;
				
				insert4=product_id +"                              "+product_name +"                            " +product_price;
				//System.out.println(insert);
				String insert10="insert into customer1 values(";
				insert10=insert10+product_id;
				insert10=insert10+ ", '"+product_name+"'";
				insert10=insert10+ ", "+product_price+");";		
				try {
					statement.executeUpdate(insert10);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				product_id=5;
				product_name="Pasta";
				product_price=350;
				
				insert5=product_id +"                              "+product_name +"                            " +product_price;
				//System.out.println(insert);
				String insert11="insert into customer1 values(";
				insert11=insert11+product_id;
				insert11=insert11+ ", '"+product_name+"'";
				insert11=insert11+ ", "+product_price+");";		
				try {
					statement.executeUpdate(insert11);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				product_id=6;
				product_name="Bisleri";
				product_price=20;
				
				insert6=product_id +"                              "+product_name +"                            " +product_price;
				//System.out.println(insert);
				String insert12="insert into customer1 values(";
				insert12=insert12+product_id;
				insert12=insert12+ ", '"+product_name+"'";
				insert12=insert12+ ", "+product_price+");";		
				try {
					statement.executeUpdate(insert12);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				product_id=7;
				product_name="Cold Drinks";
				product_price=200;
				
				insert7=product_id +"                              "+product_name +"                            " +product_price;
				//System.out.println(insert);
				String insert13="insert into customer1 values(";
				insert13=insert13+product_id;
				insert12=insert13+ ", '"+product_name+"'";
				insert13=insert13+ ", "+product_price+");";		
				try {
					statement.executeUpdate(insert13);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
				System.out.println("You Want add another customer item");
				System.out.println("Choose the Option yes or no");
				c=sc.next().charAt(0);
			}
		while(c=='y');
		System.out.println("*****You have Choose Below Items*****");
		System.out.println("product_id" +"      "+"product_name" +"    " +"product_price");
		System.out.println("----------------------------------------------------------------------------");
		System.out.println(insert);
		System.out.println(insert1);
		System.out.println(insert2);
		System.out.println(insert3);
		System.out.println(insert4);
		System.out.println(insert5);
		System.out.println(insert6);
		//System.out.println(insert2);
		try {
			ResultSet re = statement.executeQuery("select * from customer1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		char c = 0;
		do{
		System.out.println("Do you want remove any product");
		System.out.println("which item You Want Delete");
		int product_id=sc.nextInt();
		String delete="delete from customer1 where c_id="+product_id+"";
		
		try {
			statement.executeUpdate(delete);
			System.out.println("Do you want add any product y or n");
			c=sc.next().charAt(0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(c=='y');
	}

	@Override
	public void ViewDetails() {
		// TODO Auto-generated method stub
		int cnt=0;
		try {
			ResultSet view = statement.executeQuery("select * from customer1");
			if(view.next())
			{
				System.out.println(view.getInt(1));
				System.out.println("Your Order Details");
				System.out.println("Product_id                        Product_name                         Product_Price");
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println(view.getInt(1)+"                                             "+view.getString(2)+"                                            "+view.getInt(3));
			cnt++;
			}else if(cnt==0)
			{
			System.out.println("You Have No Item Add Plesae choose Items");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  }




