
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

		do
		{
			System.out.println("Please Log In.");
			System.out.println("Enter User Role.");
			UserRole = sc.nextLine();

			UserRole = UserRole.toUpperCase();

			if(UserRole.equals("ADMIN"))
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
			else if(UserRole.equals("STUDENT"))
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