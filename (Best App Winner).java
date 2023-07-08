/*
Name : Alanoud Owaed Almutairi 
ID : 2105088
Sectio : BBR
Course : CPCS203
Assignment : 1
 */
package bbr_2105088;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
public class BBR_2105088 {

    
    public static void main(String[] args) throws FileNotFoundException {
        
        // creat input file and creat a scanner input and cheak if the file exists or not  
        File inputF = new File ("input.txt");
        Scanner input = new Scanner (inputF);
        if(!inputF.exists()){
            System.out.println("The file :" + inputF.getName() + " is not exists");
            System.exit(0);
        }
        
      //creat output file its name print + creat PrintWriter 
        File printFile = new File ("print.txt");
        PrintWriter print = new PrintWriter (printFile);
       
        print.println("\n\n***** Welcome to Best App Winner System *****");
        
       //creat an arrayes to send it to the methods  + read size for each one from the input file  
             String [] uniName = new String [input.nextInt()] ;
             String [] Day = new String [input.nextInt()];
             String [] Date = new String [Day.length];
    
             String [][] StuName = new String [uniName.length][];
        for (int i = 0 ; i < uniName.length ; i++){
           StuName[i] = new String[input.nextInt()];}
            
             String [] criteria = new String [input.nextInt()];
    
           int [][][] points = new int [uniName.length][][];
        for (int j = 0 ; j<StuName.length ; j++){
             points[j] = new int [StuName[j].length][criteria.length];}
             
             //read the data from the input file  
            String command= null ;
            do{
                command = input.next();
                if (command.equalsIgnoreCase("addUniversity"))     
                    addUniversty( input ,uniName);
                else if (command.equalsIgnoreCase("addDays"))    
                    addDays (Day  ,input );           
                else if ( command.equalsIgnoreCase("addDates")) 
                    addDate(Date,input );                
                else if (command.equalsIgnoreCase("addStudentsName"))
                    addStudentName (uniName, StuName , input);
                else if (command.equalsIgnoreCase("addAwardCriteria"))
                     addAwardCriteria(criteria ,input );
                else if(command.equalsIgnoreCase("addScore"))
                    addScore (uniName ,StuName , criteria ,input ,points);
                else if(command.equalsIgnoreCase("printcontestDetails"))
                     PrintContestDetails(uniName,Day ,Date,print);
                else if (command.equalsIgnoreCase("printcontestdetailResults"))
                    PrintContestDetailsResults(StuName ,uniName,criteria , print,points );
                else if (command.equalsIgnoreCase("printwinnerAwardByEachCriteria"))
                    PrintWinnerAwardByEaChCriteria(uniName ,criteria , StuName , points , print  );
            }while(!command.equalsIgnoreCase("Quit"));
            
          print.print("\tThank you for using Best App Winner System, Good Bye!");
             
        input.close();
        print.flush();
        print.close();
        
    
            }
    
    //-------------------------------------------------------------------------------------------//
    
        public static void addUniversty(Scanner input ,String[]uniName ){

       //this method read a universty names from input file
       for (int i = 0 ; i<uniName.length;i++ ){
       uniName [i] = input.next();
       }
       // here we send the universty name to split methode to remove "_" from the names  
       for(int j =0; j <uniName.length ; j++){
          uniName[j]=textSplit(uniName[j]);
       }
       }
        
    //------------------------------------------------------------------------------------------//
        
        public static void addDays (String[]Day  ,Scanner input  ){
        
       //read days name from the input file 
       for (int j = 0 ; j<Day.length ; j++){
           Day[j]= input.next(); 
       }
        }
        
    //-----------------------------------------------------------------------------------------//
        
        public static void addDate( String []Date,Scanner input ){
       // read the dates from input file  
       
       for (int n = 0 ; n < Date.length ; n++){
           Date [n] = input.next();}
       // here we send the date to split method to remove "-" from the dates 
            for(int j =0; j <Date.length ; j++){
              Date[j]=textSplit(Date[j]);
       }  
       }
    //----------------------------------------------------------------------------------------//
        public static void addStudentName (String[]uniName ,String[][] StuName ,Scanner input ){
       //read the students name from input file 
      
       for (int row = 0 ; row <uniName.length; row++){    
          for(int column = 0 ; column< StuName[row].length  ; column++){
               StuName [row][column] = input.next();      
           }
       }
       // here we send the students name to split method to remove "_" from the names 
        for(int j =0; j <uniName.length ; j++){
            for(int i = 0 ; i <StuName[j].length ;i++){
          StuName[j][i]=textSplit(StuName[j][i]);
       }}
        }
    //---------------------------------------------------------------------------------------//
       public static void addAwardCriteria(String[]criteria ,Scanner input){ 
       // read the critera name from input file 
       for (int i = 0 ; i<criteria.length ; i++){
           criteria[i] = input.next();
       } 
       // here we send the critera name to split method to remove "_" from the criteria name 
       for(int j =0; j <criteria.length ; j++){
          criteria[j]=textSplit(criteria[j]);
       } 
       }
    //-------------------------------------------------------------------------------------//
       public static void addScore (String [] uniName  ,String[][]StuName, String [] criteria ,Scanner input,
               int [][][] points ){
       // 3D Array to read the score from input file  
      
     for (int y = 0 ; y <uniName.length ; y++){ // number of universty  
         
         for (int x = 0 ; x < StuName[y].length ; x++){ //number of students in specific universty 
             
             for (int z = 0 ; z < criteria.length ; z++){ // number of criteria 
                 
                 points[y][x][z]= input.nextInt();
             }
         }
     }}
    //--------------------------------------------------------------------------------------------//
    public static String textSplit(String text) {
        // this method return a text with out "_" 
      String newText =  text.replaceAll("[_ /]", " ");
        return newText; 
    }
    //-------------------------------------------------------------------------------------//
       public static void PrintContestDetails(String[]UniName,String[]Day ,String[]Date,PrintWriter print){
        print.println();
        print.println("------------  Contest App details are as follows ------");
        print.println("University Name                Contest Day                    Contest Date     ");
        print.println("------------------------------------------------------------------------------");
        
        // here I print a universty name and date and day as a table
        for(int i = 0 ; i<UniName.length ; i++){
            print.printf(" " + "%-30s" ,UniName[i]);
            print.printf("%-31s " , Day[i]);
        // here I exchange the space on the date into " / " 
            print.printf("%-31s " , Date[i].replaceAll(" ","/"));
            print.println();
        }
          }
    //-------------------------------------------------------------------------------------//
       public static void PrintContestDetailsResults(String[][]StuName ,String[]UniName,String[]Criteria ,
            PrintWriter print   ,int [][][] points ){
           
           // this loop print the score of each student in each universty 
           print.println();
           for(int i = 0 ; i<UniName.length ; i++){
              print.println("---Contest Results of  "+UniName[i] +" is as Follows ---");
              print.println();
              for(int j = 0 ; j <StuName[i].length ;j++){
                  print.println("---Student Name   "+ StuName[i][j]+ " points  are as Follows ---");
                  for(int z = 0 ; z <Criteria.length ; z++){
                      
                      print.print(" " + Criteria[z] + " :");
                      print.println(" " + points[i][j][z]);
                  }
                  print.println();
              }
              
           }
           
       }
    //----------------------------------------------------------------------------------------//
       public static void PrintWinnerAwardByEaChCriteria(String[]UniName ,String[]Criteria , String[][] StuName ,
               int [][][]points ,PrintWriter print ){
       
       int max = 0 ; 
       String crit = null;
         String winner = null;
       
          // this loop for find the winner by comparing the specific score with max 
          
          for (int i = 0 ; i< Criteria.length ; i++){
            for (int j = 0 ; j < UniName.length ;j++ ){
              for (int z = 0 ; z< StuName[j].length ;z++){
                  if (points[j][z][i] > max){
                      max = points[j][z][i];
                      winner = StuName[j][z];}
           }
            max = 0 ;
            // here we print the winner information after comparing 
            print.println("--- Results of  " + UniName[j] +" is as Follows ---");
            print.println(" Contest Winner name in Category:   " + Criteria[i]+ " : ");
            print.println(" " +winner);
            print.println();     
            }
              
          }
       }
}