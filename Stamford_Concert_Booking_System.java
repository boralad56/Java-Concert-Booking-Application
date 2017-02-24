
/* We first import all the java libraries that we need for our program 
 * i have imported util.Calender and util.GregorianCalender so that i can obtain
 * the date and time in order to determine if its morning, afternoon or evening , 
 * i also imported util.Scanner in order to get users input to the keyboard*/
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* This is the public class where the name of my program is located and any
 * global variables will be declared here so that they can be used in the 
 * entire program with ease */
public class Stamford_Concert_Booking_System {
	
	/* Here i am declaring an array to store all my data i have collected 
	 * I have decided to declare it in the public class so that when i reference
	 * it anywhere in the program it will be understood without me having to declare
	 *  it again*/
	static String[] seats = new String[21];
	
	/* This is the beginning of the main method, this is where my program will be 
	 * coded and all functionalities tested for accuracy */
	public static void main(String[] args) {
		
		/* Here we are declaring a variable called time of the day and assigning 
		 * a null value to it */
		String Time_of_day = null;
		
		
		/* This is where i obtained the time of the day from my users computer
		 * and assigned it to variables which i declared to make it easier differentiate 
		 * the data collected */
		GregorianCalendar time = new GregorianCalendar();
		  int hour = time.get(Calendar.HOUR_OF_DAY);
		  int min = time.get(Calendar.MINUTE);
		  int day = time.get(Calendar.DAY_OF_MONTH);
		  int month = time.get(Calendar.MONTH) + 1;
		  int year = time.get(Calendar.YEAR);

		  /* Here i use logical statements to check weather the time of day is 
		   * morning , afternoon , evening or noon , so that this can be used latter 
		   * to greet the user with the time of day */
		  if (hour < 12)
		   Time_of_day="Morning";
		  else if (hour < 17 && !(hour == 12))
		   Time_of_day="Afternoon";
		  else if (hour == 12)
		   Time_of_day="Noon";
		  else
		   Time_of_day="Evening";
		 

		  /* A welcoming message is firstly displayed to the user on program startup 
		   * welcoming them to the concert booking system */
		       System.out.println ("******* Welcome to Stamford Concert *******");
		       System.out.println ("*******************************************");
		          
		       /*Here we declare a scanner which will be used to obtain the users name , 
		        * the user is asked his/her name and the value is assigned to a variable
		        * called useName */
		       Scanner console = new Scanner (System.in);
		       System.out.print("Whats your name?");
		       String userName = console.next ();
		       int menu = 0;
		     System.out.println("");

		     /*Here we are assigning numbers to the array we declared earlier with the use of 
		      * a for loop */
		       for (int i = 0; i<seats.length;i++) {
		         seats[i] = i+1+"";
		       }
		       
               
		       /* This is the first screen which is displayed on program start-up , the menu
			    * of options is displayed so that the user can choose what he/she wants to do */
		       do {
		           System.out.println("Good " +Time_of_day+", "+userName+". How can I help you?");
			   System.out.println("[1] Seat plan");
			   System.out.println("[2] Buy a ticket");
			   System.out.println("[3] Pay now");
			   System.out.println("[4] Concert Information");
			   System.out.print("Press 1, 2, 3, 4, or -1 to exit:");
		           menu = console.nextInt();
		           
		           /* We then use logical statements to understand the users input and pass
		            * his / her option to a method that suits the required option */
		           if (menu>4 || menu ==0 || menu<-1){
		        	   System.out.println("Please press 1, 2, 3, 4 or -1 to exit only");
		        	   System.out.println(" ");
		           } else if (menu == 1){
		        	   seatPlan();
		           } else if (menu == 2){
		              buyTicket();
		           } else if (menu == 3){
		        	   System.out.println(" ");
		              payNow();
		           } else if (menu == 4){
		              concertInfo();
		              System.out.println("");
		           }
		        } while (menu!=-1);
		        System.out.println("Thank you! Hope to see you soon.");
		   }
	
	/* This is a method called seatPlan which is used to display the seating arrangement
	 * when the user selects the option called seat plan */
		   public static void seatPlan() {
			   
			 /* Here we use a for loop in order to print out the contents of the array,
			  * we also make use of a conditional if statement to determine where we 
			  * should enter into a new line so that the seat plan appears in order of 
			  * rows  */
		     for (int i = 0;i<20;i++){
		    	 System.out.print("[" +seats[i]+ "]\t");
             if (i==4){
            	 System.out.println(" ");
             }else if (i==9){
		     System.out.println(" ");
		     }else if (i==14){
		     System.out.println(" ");
		     }else if (i==19){
		     System.out.println(" ");
		     }
		    }
		     System.out.println(" ");
		   }
		   
		   
		   /* This is the buyTicket method which will be called when the user selects the buy ticket 
		    * option  */
		   public static void buyTicket() {
			   
			   /* Here a scanner is declared and the user is asked to enter a seat number they would 
			    * like to purchase */
			 Scanner console = new Scanner (System.in);
			 int seatsearch =0;
			 System.out.println("****** Buy ******");
		     System.out.print("Enter seat number:");
		     seatsearch = console.nextInt();
		     
		     
		     /* Conditional if statements are used to check weather the seat number entered is
		      * valid or not , if not an error message will be displayed, if not the seat will be booked 
		      * and assigned with an X value and the user is notified that the seat is booked, if the
		      * seat had been booked prior then a message telling the user that the seat is not 
		      * available is displayed*/
		     if (seatsearch>=21 || seatsearch<1 ){
		    	 System.out.println("Sorry the entered seat number is not valid.");
		         System.out.println("");
		     }else {
		    		 if (seats[seatsearch-1]=="X"){
		    			 System.out.println("Sorry the seat is not available");
		    			 System.out.println(" ");
		    		 }else if(seats[seatsearch-1]!="X"){
		    			 System.out.println("Thank you for booking the concert");
		    			 System.out.println("Seat #"+seatsearch+" is booked.");
		    			 System.out.println("");
                         seats[seatsearch-1]="X";
		    		 }
		    		 }
		    	 }
		     
		   /* This is the payNow method that is called when the user inputs the Pay now option*/	
		public static void payNow() {
		     
			
			/* Prices are assigned to variables based on rows , which will be used latter 
			 * to determine the purchase price */
		    double total = 0;
		    double row1_price=399.99;
		    double row2_price=299.99;
		    double row3_price=199.99;
		    double row4_price=99.99;
		    
		    /* row count variables are assigned with 0 values as these will be used latter to 
		     * count how many tickets from the same row were purchased */
		    int row1count =0;
		    int row2count =0;
		    int row3count =0;
		    int row4count =0;
		    
		    /* For loop to count and display seats from row 1 that were booked */
		     for(int h=0 ; h<6;h++){
	    		 if(seats[h]=="X"){
	    			 System.out.println("Your have booked seat#"+(h+1)+": "+ row1_price);
	    			 row1count=row1count+1;
	    		 }
		     }
	    		 
	    		 
		     /* For loop to count and display seats from row 2 that were booked */	 
	    	for(int j=6 ; j<11;j++){
		    	if(seats[j]=="X"){
		    		System.out.println("Your have booked seat#"+(j+1)+": "+ row2_price);
		    		row2count=row2count+1;
		    		 }
	    		 }
	    	
	    	    
	    	/* For loop to count and display seats from row 3 that were booked */
	    	for(int k=11 ; k<16;k++){
		    	if(seats[k]=="X"){
		    		System.out.println("Your have booked seat#"+(k+1)+": "+ row3_price);
		    		row3count=row3count+1;
		    		 }
	    		 } 
	    	
	    	
	    	/* For loop to count and display seats from row 4 that were booked */
	    	for(int l=16 ; l<20;l++){
		    	if(seats[l]=="X"){
		    		System.out.println("Your have booked seat#"+(l+1)+": "+ row4_price);
		    		row4count=row4count+1;
		    		 }
	    		 }
	    	
	    	/* Here i multiplied the row price by the number of tickets bought from 
	    	 * that row , in order to get the price to be paid for each row  */
	    	row1_price=row1_price*row1count;
	    	row2_price=row2_price*row2count;
	    	row3_price=row3_price*row3count;
	    	row4_price=row4_price*row4count;
	    	
	    	/* Here i added all the prices to be paid for the rows and assigned it to a variable 
	    	 * called total */
	    	total=row1_price+row2_price+row3_price+row4_price;
	    		 
	    	/* Here i displayed the total price with the desired styling  */
		        System.out.println("============================================== ");
		    	System.out.println("TOTAL PRICE: "+total);
		    	System.out.println("============================================== ");
		    	System.out.println("");
		   }
		  
		/* This is the concertInfo method which will be called when the user inputs the option
		 * for concert info*/
		   public static void concertInfo() {
			   
			 /* Information about the concert will be displayed with the desired styling */
		     System.out.println("**********************************************");
		     System.out.println("Stamford Concert is organized by STIU All Star");
		     System.out.println("The booking system is created by Daniel Goncalves ");
		     System.out.println("**********************************************");

		   }

}	

	


