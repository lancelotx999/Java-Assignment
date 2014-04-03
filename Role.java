
import java.util.Scanner;

public class Role
{
	Scanner sc = new Scanner(System.in);

	String UserRole = "Student";

	public String RoleSelect(String UserRole)
    {
		String Password = "4308131";
		String EnteredPassword;
		int Valid = 0;
		int Choice = 0;

		do
		{
			System.out.print('\f');
			System.out.println("Please Log In.");
			System.out.println("Enter User Role.");
			System.out.println("<1> Admin.");
			System.out.println("<2> Student.");

			System.out.print("Choice: ");
			Choice = sc.nextInt();
			sc.nextLine();

			if(Choice == 1)
			{
				System.out.println("Enter Admin Password.");
				EnteredPassword = sc.nextLine();

				if(EnteredPassword.equals(Password))
				{
					UserRole= "ADMIN";
					Valid = 1;
				}
				else
				{
					System.err.println("Invalid Password. Role Set As Student.");
					UserRole = "STUDENT";
					Valid = 1;
				}
			}
			else if(Choice == 2)
			{
				UserRole = "STUDENT";
				Valid = 1;
			}
			else 
			{
				System.err.println("Invalid Role.");
				Valid = 0;
			}
		}while(Valid == 0);

		return UserRole;
	}


}