import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.*;

public class MainFile
{
    // Scanner sc = new Scanner(System.in);

    public static void main(String [] args)
    throws BiffException, IOException, WriteException
    {
    	Scanner sc = new Scanner(System.in);

  		Role Alpha = new Role();
  		ProgramUnit ProgramList = new ProgramUnit();

  		ProgramUnit.NumberOfProgram = 3;
  		ProgramUnit.NumberOfUnit = 41;

  		int Choice = 0;
  		int InspectNumber = 0;

	  	ProgramList.ProgramName = new ArrayList<String>();
	    ProgramList.ProgramCode = new ArrayList<String>();
	    ProgramList.ProgramMajor = new ArrayList<String>();
	    ProgramList.ProgramAbbreviation = new ArrayList<String>();

	    ProgramList.UnitName = new ArrayList<String>();
	    ProgramList.UnitCode = new ArrayList<String>();
	    ProgramList.UnitType = new ArrayList<String>();
	    ProgramList.UnitMajor = new ArrayList<String>();

	    ProgramList.PreRequisiteUnitName = new ArrayList<String>();
	    ProgramList.PreRequisiteUnitCode = new ArrayList<String>();

	    ProgramList.CoRequisiteUnitName = new ArrayList<String>();
	    ProgramList.CoRequisiteUnitCode = new ArrayList<String>();

	    ProgramList.AffliatedProgramNumber = new ArrayList<Integer>();

	    System.out.print('\f');

	    Alpha.UserRole = Alpha.RoleSelect(Alpha.UserRole);
		System.out.println("User Access Level: " + Alpha.UserRole);
		System.in.read();

		ProgramList.PopulateList(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfProgram,ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.UnitType, ProgramList.CoRequisiteUnitCode, ProgramList.PreRequisiteUnitCode, ProgramList.UnitMajor);
		System.out.print('\f');

		if(Alpha.UserRole.equals("ADMIN"))
		{
			do
	    	{
	    		System.out.print('\f');
	    		System.out.println("HOME MENU");
	    		System.out.println("");

	    		System.out.println("<1> List All Programs.");
	    		System.out.println("<2> List All Units.");
	    		System.out.println("<99> Exit.");

	    		System.out.println("");
	    		System.out.print("Choice: ");
	    		Choice = sc.nextInt();
	    		sc.nextLine();

	    		switch(Choice)
	    		{
		    		case 1:
		    		{
		    			System.out.print('\f');
		    			ProgramList.ListAllPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);

		    			System.out.println("");
		    			System.out.println("PROGRAM MENU");
		    			System.out.println("");

		    			System.out.println("<1> View Program Details.");
			    		System.out.println("<2> Develop New Program.");
			    		System.out.println("<3> Remove Program.");
			    		System.out.println("<00> Back.");
			    		System.out.println("<99> Exit.");

			    		System.out.println("");
			    		System.out.print("Choice: ");
			    		Choice = sc.nextInt();
			    		sc.nextLine();

			    		switch(Choice)
			    		{
			    			case 1:
				    		{
				    			ProgramList.ListAllPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);
				    			ProgramList.ListSpecificProgram(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfUnit, ProgramList.UnitName, ProgramList.UnitCode);
				    			System.out.println("Press Enter To Continue.");
				    			Choice = 1;
				    			System.in.read();
				    			break;
				    		}
				    		case 2:
				    		{
				    			ProgramUnit.NumberOfProgram = ProgramList.DevelopNewProgram(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, Alpha.UserRole, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);
				    			System.out.println("Program Added. (Press Enter To Continue.)");
				    			Choice = 1;
				    			System.in.read();
				    			break;
				    		}
				    		case 3:
				    		{
				    			ProgramUnit.NumberOfProgram = ProgramList.RemoveProgram(ProgramList.ProgramCode, ProgramList.ProgramName, ProgramList.NumberOfProgram, Alpha.UserRole);
				    			System.out.println("Program Removed. (Press Enter To Continue.)");
				    			Choice = 1;
				    			System.in.read();
				    			break;
				    		}
				    		case 00:
				    		{
				    			System.out.println("Press Enter To Continue.");
				    			System.in.read();
				    		}
				    		case 99:
				    		{
				    			ProgramList.SaveList(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfProgram,ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.UnitType, ProgramList.CoRequisiteUnitCode, ProgramList.PreRequisiteUnitCode, ProgramList.UnitMajor);
				    			System.out.print('\f');
								System.out.println("Program Closed.");
				    			System.exit(0);
				    		}
			    		}
		    		}
		    		case 2:
		    		{
		    			System.out.print('\f');
		    			ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);

		    			System.out.println("");
		    			System.out.println("UNIT MENU");
		    			System.out.println("");

		    			System.out.println("<1> View Unit Details.");
			    		System.out.println("<2> Develop New Unit.");
			    		System.out.println("<3> Remove Unit.");
			    		System.out.println("<00> Back.");
			    		System.out.println("<99> Exit.");

			    		System.out.println("");
			    		System.out.print("Choice: ");
			    		Choice = sc.nextInt();
			    		sc.nextLine();

			    		switch (Choice)
			    		{
			    			case 1:
				    		{
				    			System.out.print('\f');

				    			ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);

				    			System.out.println("Enter The Number Of The Unit That You Wish To View.");
		           				InspectNumber = sc.nextInt();
		           				sc.nextLine();

		           				while(Choice != 99)
		           				{
			           				ProgramList.ListSpecificUnit(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramUnit.NumberOfUnit, ProgramList.UnitMajor, ProgramList.UnitType, ProgramList.PreRequisiteUnitCode, ProgramList.CoRequisiteUnitCode, InspectNumber );
					    			
					    			System.out.println("");
					    			System.out.println("SPECIFIC UNIT MENU");
				    				System.out.println("");

					    			System.out.println("<1> Add Pre-requisite Unit.");
						    		System.out.println("<2> Add Co-requisite Unit.");
						    		System.out.println("<3> Remove Co-requisite Unit.");
						    		System.out.println("<4> Remove Pre-requisite Unit.");
						    		System.out.println("<5> View Related Programs.");
						    		System.out.println("<00> Back.");
						    		System.out.println("<99> Exit.");

						    		System.out.println("");
						    		System.out.print("Choice: ");
						    		Choice = sc.nextInt();
						    		sc.nextLine();

						    		switch (Choice)
						    		{
						    			case 1:
							    		{
							    			ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);
							    			ProgramList.AddCoRequisiteUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.CoRequisiteUnitName,ProgramList.CoRequisiteUnitCode, InspectNumber);
							    			System.out.println("Co-requisite Unit Added. (Press Enter To Continue.)");
							    			System.in.read();
					    					break;
							    		}
							    		case 2:
							    		{
							    			ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);
							    			ProgramList.AddPreRequisiteUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.PreRequisiteUnitName,ProgramList.PreRequisiteUnitCode, InspectNumber);
							    			System.out.println("Pre-requisite Unit Added. (Press Enter To Continue.)");
							    			System.in.read();
					    					break;
							    		}
							    		case 3:
							    		{
							    			ProgramList.RemoveCoRequisiteUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.CoRequisiteUnitName,ProgramList.CoRequisiteUnitCode, InspectNumber);
							    			System.out.println("Co-requisite Unit Removed. (Press Enter To Continue.)");
							    			System.in.read();
					    					break;
							    		}
							    		case 4:
							    		{
							    			ProgramList.RemovePreRequisiteUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.CoRequisiteUnitName,ProgramList.PreRequisiteUnitCode, InspectNumber);
							    			System.out.println("Pre-requisite Unit Removed. (Press Enter To Continue.)");
							    			System.in.read();
					    					break;
							    		}
							    		case 5:
							    		{
							    			ProgramList.ListRelatedPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramUnit.NumberOfUnit, ProgramList.UnitMajor, ProgramList.UnitType, InspectNumber);
							    			System.out.println("Press Enter To Continue.");
							    			System.in.read();
					    					break;
							    		}
							    		case 00:
							    		{
							    			Choice = 99;
							    			System.out.println("Press Enter To Continue.");
							    			System.in.read();

							    		}
							    		case 99:
							    		{
							    			ProgramList.SaveList(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfProgram,ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.UnitType, ProgramList.CoRequisiteUnitCode, ProgramList.PreRequisiteUnitCode, ProgramList.UnitMajor);
							    			System.out.print('\f');
											System.out.println("Program Closed.");
							    			System.exit(0);
							    		}
						    		}
		           				}
				    		}
				    		case 2:
				    		{
				    			ProgramUnit.NumberOfUnit = ProgramList.DevelopNewUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramUnit.NumberOfUnit, Alpha.UserRole, ProgramList.UnitMajor, ProgramList.UnitType, ProgramList.PreRequisiteUnitCode, ProgramList.CoRequisiteUnitCode);
				    			System.out.println("New Unit Added. (Press Enter To Continue.)");
				    			Choice = 2;
				    			System.in.read();
				    			break;
				    		}
				    		case 3:
				    		{
				    			ProgramUnit.NumberOfUnit = ProgramList.RemoveUnit(ProgramList.UnitCode, ProgramList.UnitName, ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.UnitMajor);
				    			System.out.println("Unit Removed. (Press Enter To Continue.)");
				    			Choice = 2;
				    			System.in.read();
				    			break;
				    		}
							case 00:
				    		{
				    			System.out.println("Press Enter To Continue.");
				    			System.in.read();
				    		}
				    		case 99:
				    		{
				    			ProgramList.PopulateList(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfProgram,ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.UnitType, ProgramList.CoRequisiteUnitCode, ProgramList.PreRequisiteUnitCode, ProgramList.UnitMajor);
				    			System.out.print('\f');
								System.out.println("Program Closed.");
				    			System.exit(0);
				    		}
			    		}
		    		}
	    		}

	    	}while(Choice != 99);
		}
		else if(Alpha.UserRole.equals("STUDENT"))
		{
			do
	    	{
	    		System.out.print('\f');
	    		System.out.println("HOME MENU");
	    		System.out.println("");

	    		System.out.println("<1> List All Programs.");
	    		System.out.println("<2> List All Units.");
	    		System.out.println("<99> Exit.");

	    		System.out.println("");
	    		System.out.print("Choice: ");
	    		Choice = sc.nextInt();
	    		sc.nextLine();

	    		switch(Choice)
	    		{
	    			case 1:
		    		{
		    			System.out.print('\f');
		    			ProgramList.ListAllPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);

		    			System.out.println("");
		    			System.out.println("PROGRAM MENU");
		    			System.out.println("");

		    			System.out.println("<1> View Program Details.");
		    			System.out.println("<00> Back To Main Menu.");
			    		System.out.println("<99> Exit.");

			    		System.out.println("");
			    		System.out.print("Choice: ");
			    		Choice = sc.nextInt();
			    		sc.nextLine();

			    		switch(Choice)
			    		{
				    		case 1:
				    		{
				    			ProgramList.ListAllPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);
				    			ProgramList.ListSpecificProgram(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfUnit, ProgramList.UnitName, ProgramList.UnitCode);
				    			System.out.println("Press Enter To Continue.");
					    		System.in.read();
				    		}
				    		case 00:
				    		{
				    			System.out.println("Press Enter To Continue.");
				    			System.in.read();
				    			break;
				    		}
			    		}
		    		}
		    		case 2:
		    		{
		    			System.out.print('\f');
		    			ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);

		    			System.out.println("");
		    			System.out.println("UNIT MENU");
		    			System.out.println("");

		    			System.out.println("<1> View Unit Details.");
		    			System.out.println("<00> Back To Main Menu.");
			    		System.out.println("<99> Exit.");

			    		System.out.println("");
			    		System.out.print("Choice: ");
			    		Choice = sc.nextInt();
			    		sc.nextLine();

			    		switch (Choice)
			    		{
			    			case 1:
				    		{
				    			System.out.print('\f');
				    			ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);
				    			
				    			System.out.println("Enter The Number Of The Unit That You Wish To View.");
		           				InspectNumber = sc.nextInt();
		           				sc.nextLine();

				    			ProgramList.ListSpecificUnit(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramUnit.NumberOfUnit, ProgramList.UnitMajor, ProgramList.UnitType, ProgramList.PreRequisiteUnitCode, ProgramList.CoRequisiteUnitCode, InspectNumber);
				    			
				    			System.out.println("");
				    			System.out.println("SPECIFIC UNIT MENU");
			    				System.out.println("");

					    		System.out.println("<1> View Related Programs.");
					    		System.out.println("<00> Back To Main Menu.");
					    		System.out.println("<99> Exit.");

					    		System.out.println("");
					    		System.out.print("Choice: ");
					    		Choice = sc.nextInt();
					    		sc.nextLine();

					    		switch(Choice)
					    		{
						    		case 1:
						    		{
						    			ProgramList.ListRelatedPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramUnit.NumberOfUnit, ProgramList.UnitMajor, ProgramList.UnitType, InspectNumber);
						    			System.out.println("Press Enter To Continue.");
						    			System.in.read();
						    		}
						    		case 00:
						    		{
						    			System.out.println("Press Enter To Continue.");
						    			System.in.read();
						    			break;
						    		}
					    		}
				    		}
			    		}
		    		}
	    		}
	    	}while(Choice != 99);
		}

		ProgramList.SaveList(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfProgram,ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.UnitType, ProgramList.CoRequisiteUnitCode, ProgramList.PreRequisiteUnitCode, ProgramList.UnitMajor);

		System.out.print('\f');
		System.out.println("Program Closed.");
		

  		// ProgramList.PopulateList(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfProgram,ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.UnitType, ProgramList.CoRequisiteUnitCode, ProgramList.PreRequisiteUnitCode, ProgramList.UnitMajor);
  		// ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);
      	// System.in.read();

      	// ProgramList.ListSpecificProgram(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation, ProgramUnit.NumberOfUnit, ProgramList.UnitName, ProgramList.UnitCode);
      
      	// ProgramUnit.NumberOfProgram = ProgramList.DevelopNewProgram(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, Alpha.UserRole, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);
      	// ProgramList.ListAllPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);
      	// System.in.read();

      	// ProgramList.ListAllPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);
      	// ProgramUnit.NumberOfProgram = ProgramList.RemoveProgram(ProgramList.ProgramCode, ProgramList.ProgramName, ProgramList.NumberOfProgram, Alpha.UserRole);
      	// System.in.read();

      	// ProgramList.ListAllPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.ProgramMajor, ProgramList.ProgramAbbreviation);
      	// System.in.read();

      	// ProgramUnit.NumberOfUnit = ProgramList.DevelopNewUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramUnit.NumberOfUnit, Alpha.UserRole, ProgramList.UnitMajor, ProgramList.UnitType);
      	// ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);
      	// System.in.read();

      	// ProgramUnit.NumberOfUnit = ProgramList.RemoveUnit(ProgramList.UnitCode, ProgramList.UnitName, ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.UnitMajor);
      	// ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);
      	// System.in.read();

  //     	ProgramList.AddCoRequisiteUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.CoRequisiteUnitName,ProgramList.CoRequisiteUnitCode);
  //     	ProgramList.AddPreRequisiteUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.PreRequisiteUnitName,ProgramList.PreRequisiteUnitCode);
  //     	ProgramList.ListAllUnits(ProgramList.ProgramName,ProgramList.ProgramCode, ProgramList.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber, ProgramList.NumberOfUnit);
		// InspectNumber = ProgramList.ListSpecificUnit(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramUnit.NumberOfUnit, ProgramList.UnitMajor, ProgramList.UnitType, ProgramList.PreRequisiteUnitCode, ProgramList.CoRequisiteUnitCode);
		// ProgramList.ListRelatedPrograms(ProgramList.ProgramName, ProgramList.ProgramCode, ProgramUnit.NumberOfProgram, ProgramList.UnitName, ProgramList.UnitCode, ProgramUnit.NumberOfUnit, ProgramList.UnitMajor, ProgramList.UnitType, InspectNumber);
		// ProgramList.AddCoRequisiteUnit(ProgramList.UnitName, ProgramList.UnitCode, ProgramList.AffliatedProgramNumber,ProgramList.NumberOfUnit, Alpha.UserRole, ProgramList.CoRequisiteUnitName,ProgramList.CoRequisiteUnitCode);

    }
}
