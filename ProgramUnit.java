import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import java.lang.String;

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


public class ProgramUnit
{
        Scanner sc = new Scanner(System.in);
        
        ArrayList <String> ProgramName;
        ArrayList <String> ProgramCode;
        ArrayList <String> ProgramMajor;
        ArrayList <String> ProgramAbbreviation;

        ArrayList <String> UnitName;
        ArrayList <String> UnitCode;
        ArrayList <String> UnitType;
        ArrayList <String> UnitMajor;

        ArrayList <String> PreRequisiteUnitName;
        ArrayList <String> PreRequisiteUnitCode;

    	ArrayList <String> CoRequisiteUnitName;
    	ArrayList <String> CoRequisiteUnitCode;

        ArrayList <Integer> AffliatedProgramNumber;

        static int NumberOfProgram = 3;
        static int NumberOfUnit = 41;

        static void PopulateList(ArrayList <String> ProgramName, ArrayList <String> ProgramCode, ArrayList <String> ProgramMajor, ArrayList <String> ProgramAbbreviation, int NumberOfProgram, ArrayList <String> UnitName, ArrayList <String> UnitCode, ArrayList <Integer> AffliatedProgramNumber, ArrayList <String> UnitType,  ArrayList <String> CoRequisiteUnitCode,  ArrayList <String> PreRequisiteUnitCode, ArrayList <String> UnitMajor)
        throws BiffException, IOException, WriteException
        {
        	int i = 0;
        	double UnitLength = 0;
        	double ProgramLength = 0;
      
		    Cell ExtractUnitName;
		    Cell ExtractUnitType;
		    Cell ExtractUnitCode;
		    Cell ExtractPreRequisiteUnitCode;
		    Cell ExtractCoRequisiteUnitCode;
		    Cell ExtractUnitMajor;
		    NumberCell NumberOfCellsUnits;

		    Cell ExtractProgramName;
		    Cell ExtractProgramAbbreviation;
		    Cell ExtractProgramCode;
		    Cell ExtractProgramMajor;
		    NumberCell NumberOfCellsPrograms;

        	Workbook ExcelWorkbook = Workbook.getWorkbook(new File("Unit Data.xls"));

        	Sheet ProgramSheet = ExcelWorkbook.getSheet(0);
        	Sheet UnitSheet = ExcelWorkbook.getSheet(1);

        	Cell ExtractUnitLength = UnitSheet.getCell(7,0);
        	NumberOfCellsUnits = (NumberCell) ExtractUnitLength;
        	UnitLength = NumberOfCellsUnits.getValue();

        	Cell ExtractProgramLength = ProgramSheet.getCell(5,0);
        	NumberOfCellsPrograms = (NumberCell) ExtractProgramLength;
        	ProgramLength = NumberOfCellsPrograms.getValue();


        	for(i = 1; i <= UnitLength; i++)
        	{
        		ExtractUnitName = UnitSheet.getCell(4, i);
        		ExtractUnitType = UnitSheet.getCell(2, i);
       			ExtractUnitCode = UnitSheet.getCell(3, i);
     			ExtractPreRequisiteUnitCode = UnitSheet.getCell(5, i);
     			ExtractCoRequisiteUnitCode = UnitSheet.getCell(6, i);
     			ExtractUnitMajor = UnitSheet.getCell(1,i);

        		UnitName.add(ExtractUnitName.getContents());
        		UnitType.add(ExtractUnitType.getContents());
        		UnitCode.add(ExtractUnitCode.getContents());
        		PreRequisiteUnitCode.add(ExtractPreRequisiteUnitCode.getContents());
        		CoRequisiteUnitCode.add(ExtractCoRequisiteUnitCode.getContents());
        		UnitMajor.add(ExtractUnitMajor.getContents());
        	}

        	for(i = 1; i <= ProgramLength; i++)
        	{
        		ExtractProgramName = ProgramSheet.getCell(2, i);
        		ExtractProgramAbbreviation = ProgramSheet.getCell(4, i);
       			ExtractProgramCode = ProgramSheet.getCell(1, i);
     			ExtractProgramMajor = ProgramSheet.getCell(3, i);

        		ProgramName.add(ExtractProgramName.getContents());
        		ProgramAbbreviation.add(ExtractProgramAbbreviation.getContents());
        		ProgramCode.add(ExtractProgramCode.getContents());
        		ProgramMajor.add(ExtractProgramMajor.getContents());

        	}
        }
        
        static void ListAllPrograms(ArrayList <String> ProgramName, ArrayList <String> ProgramCode, int NumberOfProgram, ArrayList <String> ProgramMajor, ArrayList <String> ProgramAbbreviation)
        {
        	System.out.print('\f');
            int ProgramNumber = 0;

            System.out.println("Number Of Available Programs: " + NumberOfProgram);

            do
            {
                if (!ProgramName.get(ProgramNumber).equals("Null") && !ProgramCode.get(ProgramNumber).equals("Null"))
                {
                    System.out.println("Program Number: " + ProgramNumber + " Program Name: " + ProgramName.get(ProgramNumber) + " Program Code: " +ProgramCode.get(ProgramNumber) + " Program Abbreviation: " + ProgramAbbreviation.get(ProgramNumber));
                }
                ProgramNumber ++;
            } while(ProgramNumber != NumberOfProgram);

            System.out.println("End Of List");
        }

        public void ListSpecificProgram(ArrayList <String> ProgramName, ArrayList <String> ProgramCode, int NumberOfProgram, ArrayList <String> ProgramMajor, ArrayList <String> ProgramAbbreviation, int NumberOfUnit, ArrayList <String> UnitName, ArrayList <String> UnitCode)
        {
        	int Valid = 0;
            int ProgramNumber = 0;
            int UnitNumber = 0;

        	int InspectNumber;
            System.out.println("Enter The Number Of The Program That You Wish To View.");
           	InspectNumber = sc.nextInt();
           	sc.nextLine();

       	    do
        	{
        		if(InspectNumber >= NumberOfProgram || InspectNumber < 0)
            	{
            		System.err.println("Invalid Program Number.");
            		System.out.println("Enter Valid Program Number To Inspect.");
	            	InspectNumber = sc.nextInt();
	            	sc.nextLine();
            	}
            	else
            	{
            		Valid =1;
            	}
        	}while(Valid == 0);

           	System.out.print('\f');
            System.out.println("Program Number: " + ProgramNumber + " Program Name: " + ProgramName.get(InspectNumber) + " Program Code: " +ProgramCode.get(InspectNumber) + " Program Major: " + ProgramMajor.get(InspectNumber) + " Program Abbreviation: " + ProgramAbbreviation.get(InspectNumber));
            System.out.println(" ");
            System.out.println(" ");

            System.out.println("Related Units List:");
            do
		    {
			    if (UnitMajor.get(UnitNumber).equals("ALL") || UnitMajor.get(UnitNumber).equals(ProgramAbbreviation.get(InspectNumber)))
			    {
			        System.out.println("Unit Number: " + UnitNumber + " Unit Name: " + UnitName.get(UnitNumber) + " Unit Code: " +UnitCode.get(UnitNumber) + " Unit Major: " + UnitMajor.get(UnitNumber) + " Unit Type: " + UnitType.get(UnitNumber));
			    }
		    	UnitNumber ++;
		    } while(UnitNumber != NumberOfUnit);
		    

            System.out.println("End Of List");
        }

        public int RemoveProgram(ArrayList <String> ProgramCode, ArrayList <String> ProgramName, int NumberOfProgram, String Role)
        {
        	int Valid = 0;

            if (Role.equals("ADMIN"))
            {
                int RemoveNumber;
                System.out.println("Enter The Number Of The Program That You Wish To Remove.");
                RemoveNumber = sc.nextInt();
                sc.nextLine();

                do
            	{
            		if(RemoveNumber >= NumberOfProgram || RemoveNumber < 0)
	            	{
	            		System.err.println("Invalid Program Number.");
	            		System.out.println("Enter Valid Program Number To Remove.");
		            	RemoveNumber = sc.nextInt();
		            	sc.nextLine();
	            	}
	            	else
	            	{
	            		Valid =1;
	            	}
            	}while(Valid == 0);

            	Valid = 0;

                ProgramCode.remove(RemoveNumber);
                ProgramName.remove(RemoveNumber);
            }
            else
            {
                System.err.println("Insufficient Access.");
            }
            NumberOfProgram--;
            return NumberOfProgram;
        }

        public int DevelopNewProgram(ArrayList <String> ProgramName, ArrayList <String> ProgramCode, int NumberOfProgram, String Role, ArrayList <String> ProgramMajor, ArrayList <String> ProgramAbbreviation)
        {
        	System.out.print('\f');
            if (Role.equals("ADMIN"))
            {
                int ProgramNumber = ProgramName.size();
                int Valid = 0;

                System.out.println("Enter New Program Name.");
	            ProgramName.add(sc.nextLine());

                System.out.println("Enter New Program Code.");
                ProgramCode.add(sc.nextLine());

                System.out.println("Enter New Program Major.");
                ProgramMajor.add(sc.nextLine());

                System.out.println("Enter New Program Abbreviation.");
                ProgramAbbreviation.add(sc.nextLine());

                System.out.print('\f');
                for(ProgramNumber = ProgramNumber -1; ProgramNumber >= 0; ProgramNumber--)
                {
                	if(ProgramName.get(NumberOfProgram).equals(ProgramName.get(ProgramNumber)))
                	{
                		do
		                {
		                	System.err.println("Program Name Already Exist.");
			                System.out.println("Enter New Program Name.");
			                ProgramName.set(NumberOfProgram, sc.nextLine());

			                if(ProgramName.get(NumberOfProgram).equals(ProgramName.get(ProgramNumber)))
			                {
			                	Valid = 0;
			                }
			                else
			                {
			                	Valid = 1;
			                }
		                }while(Valid == 0);
                	}
                	if(ProgramCode.get(NumberOfProgram).equals(ProgramCode.get(ProgramNumber)))
                	{
                		do
		                {
		                	System.err.println("Program Code Already Exist.");
			                System.out.println("Enter New Program Code.");
			                ProgramCode.set(NumberOfProgram, sc.nextLine());

			                if(ProgramCode.get(NumberOfProgram).equals(ProgramCode.get(ProgramNumber)))
			                {
			                	Valid = 0;
			                }
			                else
			                {
			                	Valid = 1;
			                }
		                }while(Valid == 0);
                	}
                	if(ProgramAbbreviation.get(NumberOfProgram).equals(ProgramAbbreviation.get(ProgramNumber)))
                	{
                		do
		                {
		                	System.err.println("Program Abbreviation Already Exist.");
			                System.out.println("Enter New Program Abbreviation.");
			                ProgramAbbreviation.set(NumberOfProgram, sc.nextLine());

			                if(ProgramAbbreviation.get(NumberOfProgram).equals(ProgramAbbreviation.get(ProgramNumber)))
			                {
			                	Valid = 0;
			                }
			                else
			                {
			                	Valid = 1;
			                }
		                }while(Valid == 0);
                	}
                }
            }
            else
            {
                System.err.println("Insufficient Access.");
            }
            NumberOfProgram++;
            return NumberOfProgram;
        } 

        public int DevelopNewUnit(ArrayList <String> UnitName, ArrayList <String> UnitCode, ArrayList <Integer> AffliatedProgramNumber, int NumberOfUnit, String Role, ArrayList <String> UnitMajor, ArrayList <String> UnitType, ArrayList <String> PreRequisiteUnitCode, ArrayList <String> CoRequisiteUnitCode)
        {
        	System.out.print('\f');
            if (Role.equals("ADMIN"))
            {
                int UnitNumber = UnitName.size();
                int Valid = 0;

                System.out.println("Enter New Unit Name.");
	            UnitName.add(sc.nextLine());

                System.out.println("Enter New Unit Code.");
                UnitCode.add(sc.nextLine());

                System.out.println("Enter New Unit Major. (Enter Abbreviation Of Unit Major.)");
                UnitMajor.add(sc.nextLine());

                System.out.println("Enter New Unit Type. (Core, Major Or Elective.)");
                UnitType.add(sc.nextLine());

                System.out.println("Enter New Unit Co-requisite Unit Code. (If Any, Else Enter NULL)");
                CoRequisiteUnitCode.add(sc.nextLine().toUpperCase());

                System.out.println("Enter New Unit Pre-requisite Unit Code. (If Any, Else Enter Null.)");
                PreRequisiteUnitCode.add(sc.nextLine().toUpperCase());

                System.out.print('\f');

                for(UnitNumber = UnitNumber -1; UnitNumber >= 0; UnitNumber--)
                {
                	if(UnitName.get(NumberOfUnit).equals(UnitName.get(UnitNumber)))
                	{
                		do
		                {
		                	System.err.println("Unit Name Already Exist.");
			                System.out.println("Enter New Unit Name.");
			                UnitName.set(NumberOfUnit, sc.nextLine());

			                if(UnitName.get(NumberOfUnit).equals(UnitName.get(UnitNumber)))
			                {
			                	Valid = 0;
			                }
			                else
			                {
			                	Valid = 1;
			                }
		                }while(Valid == 0);
                	}
                	if(UnitCode.get(NumberOfUnit).equals(UnitCode.get(UnitNumber)))
                	{
                		do
		                {
		                	System.err.println("Unit Code Already Exist.");
			                System.out.println("Enter New Unit Code.");
			                UnitCode.set(NumberOfUnit, sc.nextLine());

			                if(UnitCode.get(NumberOfUnit).equals(UnitCode.get(UnitNumber)))
			                {
			                	Valid = 0;
			                }
			                else
			                {
			                	Valid = 1;
			                }
		                }while(Valid == 0);
                	}
                }
            }
            else
            {
                System.err.println("Insufficient Access.");
            }
            NumberOfUnit++;
            return NumberOfUnit;
        } 

        public void ListAllUnits(ArrayList <String> ProgramName, ArrayList <String> ProgramCode, int NumberOfProgram,ArrayList <String> UnitName, ArrayList <String> UnitCode, ArrayList <Integer> AffliatedProgramNumber, int NumberOfUnit)
        {
        	System.out.print('\f');
            int UnitNumber = 0;

            do
            {
                if (!UnitName.get(UnitNumber).equals("Null") && !UnitCode.get(UnitNumber).equals("Null"))
                {
                    System.out.println( "Unit Number: " +UnitNumber + " Unit Name: " + UnitName.get(UnitNumber) + " Unit Code : " +UnitCode.get(UnitNumber));
                }
                UnitNumber ++;
            } while(UnitNumber != NumberOfUnit);

            System.out.println("End Of List");
        }

		public int RemoveUnit(ArrayList <String> UnitCode, ArrayList <String> UnitName, int NumberOfUnit, String Role, ArrayList<String> UnitMajor)
        {
        	int Valid = 0;

            if (Role.equals("ADMIN"))
            {
                int RemoveNumber;
                System.out.println("Enter The Number Of The Unit That You Wish To Remove.");
                RemoveNumber = sc.nextInt();
                sc.nextLine();
                int ProgramNumber = 0;
                int ValidRemove = 0;

                do
            	{
            		if(RemoveNumber >= NumberOfUnit || RemoveNumber < 0)
	            	{
	            		System.err.println("Invalid Unit Number.");
	            		System.out.println("Enter Valid Unit Number To Remove.");
		            	RemoveNumber = sc.nextInt();
		            	sc.nextLine();
	            	}
	            	else
	            	{
	            		Valid =1;
	            	}
            	}while(Valid == 0);

            	Valid = 0;

                do
                {
                	if(PreRequisiteUnitCode.get(ProgramNumber).equals(ProgramCode.get(RemoveNumber)) || CoRequisiteUnitCode.get(ProgramNumber).equals(ProgramCode.get(RemoveNumber)))
                	{
                		ValidRemove++;
                	}
                	ProgramNumber++;
                }while(ProgramNumber != NumberOfProgram);



                if(ValidRemove == 0)
                {
                	UnitCode.remove(RemoveNumber);
	                UnitName.remove(RemoveNumber);
	                UnitType.remove(RemoveNumber);
	                UnitMajor.remove(RemoveNumber);

	                NumberOfUnit--;
                }
                else
                {
                	System.err.println("Unable To Remove Due To Pre-requisite Or Co-requisite Units.");
                }
            }
            else
            {
                System.err.println("Insufficient Access.");
            }
            return NumberOfUnit;
        }

        public void AddCoRequisiteUnit(ArrayList <String> UnitName, ArrayList <String> UnitCode, int NumberOfUnit, String Role, ArrayList <String> CoRequisiteUnitName, ArrayList <String> CoRequisiteUnitCode, int InspectNumber)
        {
            if (Role.equals("ADMIN"))
            {
            	int Valid = 0;

            	System.out.println("Enter Co-requisite Unit Number.");
            	int CoRequisiteUnitNumber = sc.nextInt();
            	sc.nextLine();

            	do
            	{
            		if(CoRequisiteUnitNumber > NumberOfUnit || CoRequisiteUnitNumber < 0)
	            	{
	            		System.err.println("Invalid Unit Number.");
	            		System.out.println("Enter Valid Co-requisite Unit Number.");
		            	CoRequisiteUnitNumber = sc.nextInt();
		            	sc.nextLine();
	            	}
	            	else
	            	{
	            		Valid =1;
	            	}
            	}while(Valid == 0);

            	CoRequisiteUnitCode.set(InspectNumber, UnitCode.get(CoRequisiteUnitNumber));
            }
            else
            {
                System.err.println("Insufficient Access.");
            }
        }

        public void AddPreRequisiteUnit(ArrayList <String> UnitName, ArrayList <String> UnitCode, int NumberOfUnit, String Role, ArrayList <String> PreRequisiteUnitName, ArrayList <String> PreRequisiteUnitCode, int InspectNumber)
        {
            if (Role.equals("ADMIN"))
            {
            	int Valid = 0;

            	System.out.println("Enter Pre-requisite Unit Number.");
            	int PreRequisiteUnitNumber = sc.nextInt();
            	sc.nextLine();

            	do
            	{
            		if(PreRequisiteUnitNumber > NumberOfUnit || PreRequisiteUnitNumber < 0)
	            	{
	            		System.err.println("Invalid Unit Number.");
	            		System.out.println("Enter Valid Pre-requisite Unit Number.");
		            	PreRequisiteUnitNumber = sc.nextInt();
		            	sc.nextLine();
	            	}
	            	else
	            	{
	            		Valid =1;
	            	}
            	}while(Valid == 0);

            	PreRequisiteUnitCode.set(InspectNumber, UnitCode.get(PreRequisiteUnitNumber));
            }
            else
            {
                System.err.println("Insufficient Access.");
            }
        }

        public void RemoveCoRequisiteUnit(ArrayList <String> UnitName, ArrayList <String> UnitCode, int NumberOfUnit, String Role, ArrayList <String> CoRequisiteUnitName, ArrayList <String> CoRequisiteUnitCode, int InspectNumber)
        {
            if (Role.equals("ADMIN"))
            {
            	CoRequisiteUnitCode.set(InspectNumber, "NULL");
            }
            else
            {
                System.err.println("Insufficient Access.");
            }
        }

        public void RemovePreRequisiteUnit(ArrayList <String> UnitName, ArrayList <String> UnitCode, int NumberOfUnit, String Role, ArrayList <String> PreRequisiteUnitName, ArrayList <String> PreRequisiteUnitCode, int InspectNumber)
        {
            if (Role.equals("ADMIN"))
            {
            	PreRequisiteUnitCode.set(InspectNumber, "NULL");
            }
            else
            {
                System.err.println("Insufficient Access.");
            }
        }

        public void ListSpecificUnit(ArrayList <String> ProgramName, ArrayList <String> ProgramCode, int NumberOfProgram,ArrayList <String> UnitName, ArrayList <String> UnitCode, int NumberOfUnit, ArrayList <String> UnitMajor, ArrayList <String> UnitType, ArrayList <String> PreRequisiteUnitCode, ArrayList <String> CoRequisiteUnitCode, int InspectNumber)
        {
        	int Valid = 0;
        	int UnitNumber = 0;

            do
        	{
        		if(InspectNumber >= NumberOfUnit || InspectNumber < 0)
            	{
            		System.err.println("Invalid Unit Number.");
            		System.out.println("Enter Valid Unit Number To Inspect.");
	            	InspectNumber = sc.nextInt();
	            	sc.nextLine();
            	}
            	else
            	{
            		Valid =1;
            	}
        	}while(Valid == 0);

           	System.out.print('\f');

           	System.out.println("Unit Name: " + UnitName.get(InspectNumber) + " Unit Code : " +UnitCode.get(InspectNumber));
           	System.out.println("Unit Major: " + UnitMajor.get(InspectNumber) + " Unit Type : " +UnitType.get(InspectNumber));
           	System.out.println("Pre-requisite Unit Code : " +PreRequisiteUnitCode.get(InspectNumber));
           	System.out.println("Co-requisite Unit Code : " +CoRequisiteUnitCode.get(InspectNumber));
           	System.out.println("");
           	
            do
            {
                if(CoRequisiteUnitCode.get(UnitNumber).contains(UnitCode.get(InspectNumber)))
                {
                	System.out.println("Co-requisite Unit For : " + UnitCode.get(UnitNumber));
                }
                
                if(PreRequisiteUnitCode.get(UnitNumber).contains(UnitCode.get(InspectNumber)))
                {
                	System.out.println("Pre-requisite Unit For : " + UnitCode.get(UnitNumber));
                }
                UnitNumber++;
            }while(UnitNumber != NumberOfUnit);
        }

        public void ListRelatedPrograms(ArrayList <String> ProgramName, ArrayList <String> ProgramCode, int NumberOfProgram,ArrayList <String> UnitName, ArrayList <String> UnitCode, int NumberOfUnit, ArrayList <String> UnitMajor, ArrayList <String> UnitType, int InspectNumber)
        {
        	int ProgramNumber = 0;

        	System.out.print('\f');

        	System.out.println("Unit Name: " + UnitName.get(InspectNumber) + " Unit Code : " +UnitCode.get(InspectNumber));
           	System.out.println("Unit Major: " + UnitMajor.get(InspectNumber) + " Unit Type : " +UnitType.get(InspectNumber));
           	System.out.println("Pre-requisite Unit Code : " +PreRequisiteUnitCode.get(InspectNumber));
           	System.out.println("Co-requisite Unit Code : " +CoRequisiteUnitCode.get(InspectNumber));

           	System.out.println(" ");
        	System.out.println("Related Programs: ");

        	do
            {
                if (UnitMajor.get(InspectNumber).equals(ProgramAbbreviation.get(ProgramNumber)) || UnitMajor.get(InspectNumber).equals("ALL"))
                {
                    System.out.println("Program Number: " + ProgramNumber + " Program Name: " + ProgramName.get(ProgramNumber) + " Program Code : " +ProgramCode.get(ProgramNumber));
                }
                ProgramNumber ++;
            } while(ProgramNumber != NumberOfProgram);
        }

        static void SaveList(ArrayList <String> ProgramName, ArrayList <String> ProgramCode, ArrayList <String> ProgramMajor, ArrayList <String> ProgramAbbreviation, int NumberOfProgram, ArrayList <String> UnitName, ArrayList <String> UnitCode, ArrayList <Integer> AffliatedProgramNumber, ArrayList <String> UnitType,  ArrayList <String> CoRequisiteUnitCode,  ArrayList <String> PreRequisiteUnitCode, ArrayList <String> UnitMajor)
        throws BiffException, IOException, WriteException
        {

            WritableWorkbook ExcelWorkbook = Workbook.createWorkbook(new File("Lib.xls"));
            WritableSheet ProgramSheet = ExcelWorkbook.createSheet("Program Sheet", 0);
            WritableSheet UnitSheet = ExcelWorkbook.createSheet("Unit Sheet", 1);

            int i = 0;

            for(i = 0; i < ProgramName.size(); i++)
            {   
                Label SaveProgramCode = new Label(0, i + 1, ProgramCode.get(i));
                Label SaveProgramName = new Label(1, i + 1, ProgramName.get(i));
                Label SaveProgramMajor = new Label(2, i + 1, ProgramMajor.get(i));
                Label SaveProgramAbbreviation = new Label(3, i + 1, ProgramAbbreviation.get(i));

                ProgramSheet.addCell(SaveProgramCode);
                ProgramSheet.addCell(SaveProgramName);
                ProgramSheet.addCell(SaveProgramMajor);
                ProgramSheet.addCell(SaveProgramAbbreviation);
            }

            for(i = 0; i < UnitName.size(); i++)
            {
                Label SaveUnitCode = new Label(0, i + 1, UnitCode.get(i));
                Label SaveUnitName = new Label(1, i + 1, UnitName.get(i));
                Label SaveUnitType = new Label(2, i + 1, UnitType.get(i));
                Label SaveUnitMajor = new Label(3, i + 1, UnitMajor.get(i));
                Label SaveUnitCoRequisiteUnitCode = new Label(4, i + 1, CoRequisiteUnitCode.get(i));
                Label SaveUnitPreRequisiteUnitCode = new Label(5, i + 1, PreRequisiteUnitCode.get(i));

                UnitSheet.addCell(SaveUnitCode);
                UnitSheet.addCell(SaveUnitName);
                UnitSheet.addCell(SaveUnitType);
                UnitSheet.addCell(SaveUnitMajor);
                UnitSheet.addCell(SaveUnitCoRequisiteUnitCode);
                UnitSheet.addCell(SaveUnitPreRequisiteUnitCode);
            }
            ExcelWorkbook.write();      
            ExcelWorkbook.close(); 
            
        }
}
