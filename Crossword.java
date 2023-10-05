//Name: Eathan Rajendram
//Date: January 10, 2022
//Teacher: Ms. Basaraba
//Description: This program will allow the user to solve 3 crossword puzzles.

import java.awt.*; //Imports java command libraries
import hsa.Console; //Gives access to Console class files
import java.io.*; //Importing command files to access txt files

public class Crossword //Creates class called Crossword
{
    Console c; //Creates console window
    int bookX = 0; //x-Coordinate of book in intro screen
    int paperX; //x-Coordinate of paper in book in intro screen
    String userMainOption; //Stores number user enters in main menu screen
    int intUserMainOption; //Stores userMainOption as an integer
    String userStartOption; //Stores number user enters in start screen
    int intUserStartOption; //Stores userStartOption as an integer
    String userTimerOption; //Stores number user enters in timer screen
    int intUserTimerOption; //Stores userTimerOption as an integer
    double startTime; //Stores time when user begins the crossword in milliseconds
    double elapsedTime; //Stores time user took to complete the crossword
    double elapsedSeconds; //Divides elapsedTime by 1000 to get seconds
    double secondsDisplay; //Divides elapsedSeconds by 60 and gets remainder to get seconds that can be understood by user
    double elapsedMinutes; //Divides elapsedSeconds by 60 to get minutes
    double minutesDisplay; //Divides elapsedMinutes by 60 and gets remainder to get minutes that can be understood by user
    int intSecondsDisplay; //Convertes secondsDisplay to an integer to ensure no decimal.
    int intMinutesDisplay; //Convertes minutesDisplay to an intger to ensure no decimal.
    boolean validEntry; //Condition variable to make while loops run
    String userClue; //Stores clue number user wants to solve
    int intUserClue; //Stores userClue as an integer
    String userCrosswordGuess; //Stores user's guess
    int total = 0; //Stores how many words user guessed correctly
    int run = 0; //Stores how many words have already been solved in the crossword
    int check = 0; //To ensure user does not guess the first word again after it has already been guessed
    int checkTwo = 0; //To ensure user does not guess the second word again after it has already been guessed
    int checkThree = 0; //To ensure user does not guess the third word again after it has already been guessed
    int checkFour = 0; //To ensure user does not guess the fourth word again after it has already been guessed
    int checkFive = 0; //To ensure user does not guess the fifth word again after it has already been guessed
    int checkSix = 0; //To ensure user does not guess the sixth word again after it has already been guessed
    int checkSeven = 0; //To ensure user does not guess the seventh word again after it has already been guessed
    int checkEight = 0; //To ensure user does not guess the eigth word again after it has already been guessed
    int checkNine = 0; //To ensure user does not guess the ninth word again after it has already been guessed
    int checkTen = 0; //To ensure user does not guess the tenth word again after it has already been guessed
    int checkEleven = 0; //To ensure user does not guess the eleventh word again after it has already been guessed
    int checkTwelve = 0; //To ensure user does not guess the twelfth word again after it has already been guessed
    int checkThirteen = 0; //To ensure user does not guess the thirteenth word again after it has already been guessed
    int checkFourteen = 0; //To ensure user does not guess the fourteenth word again after it has already been guessed
    int checkFifteen = 0; //To ensure user does not guess the fifteenth word again after it has already been guessed
    int checkSixteen = 0; //To ensure user does not guess the sixteenth word again after it has already been guessed
    String userName; //Stores user's name
    String scores[] = new String [13]; //Stores scores as String
    String name[] = new String [13]; //Stores names as String
    String time[] = new String [13]; //Stores times as integers
    int intScores[] = new int [13]; //Stores scores as integers

    int s = 0;
    public void splashscreen ()  //splashscreen() method
    {
	Splashscreen s = new Splashscreen (c);
	s.start (); //Runs splashscreen() thread
	try
	{
	    s.join ();
	}
	catch (InterruptedException e)
	{
	}
    }


    public void intro ()  //intro() method
    {
	c.clear (); //Clears screen
	c.setColor (new Color (139, 0, 0));
	bookX += 15;
	for (int timer = 0 ; timer <= 60 ; timer++)
	{
	    c.fillRect (190, 60, 270 - bookX, 380);
	}
	try
	{
	    Thread.sleep (5000);
	}
	catch (Exception e)
	{
	}
	c.fillRect (65, 60, 540, 380);
	c.setColor (Color.white);
	c.fillRect (95, 70, 480, 360);
	c.setColor (Color.black);
	c.drawLine (335, 70, 335, 430);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 30));
	c.drawString ("Book of     Crosswords", 150, 160);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 20));
	c.drawString ("Authors:", 160, 320);
	c.drawString ("Eathan Rajendram", 120, 360);
	c.drawString ("&", 200, 380);
	c.drawString ("Ovya Saseelan", 135, 400);
	c.drawString ("Welcome to the", 370, 260);
	c.drawString ("most fun book", 370, 280);
	c.drawString ("you will ever", 370, 300);
	c.drawString ("encounter in", 370, 320);
	c.drawString ("your lifetime!", 370, 340);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 16));
	c.drawString ("Press any key to", 370, 380);
	c.drawString ("continue!", 410, 400);
	c.getChar ();

    }


    public void mainMenu ()  //mainMenu() method
    {
	c.clear (); //Clears screen
	validEntry = false;
	//Background
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}
	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}
	//Displaying options to user
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 50));
	c.setColor (Color.red);
	c.drawString ("Main Menu", 210, 70);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 24));
	c.setColor (Color.black);
	c.drawString ("Please choose from the following options: ", 45, 140);
	c.drawString ("1) Start", 65, 200);
	c.drawString ("2) Instructions", 65, 260);
	c.drawString ("3) Leaderboard", 65, 320);
	c.drawString ("4) Exit", 65, 380);
	c.drawString ("Enter 1, 2, 3, or 4: ", 65, 437);
	while (!validEntry) //If user enters invalid input, will keep asking for valid input
	{
	    try
	    {
		c.setColor (Color.black);
		c.setCursor (22, 45);
		userMainOption = c.readString (); //Getting option from user as a String
		intUserMainOption = Integer.parseInt (userMainOption); //Converting userMainOption to an integer
		if (intUserMainOption == 1 || intUserMainOption == 2 || intUserMainOption == 3 || intUserMainOption == 4) //If user entered an integer, but not 1, 2, 3, or 4
		{
		    validEntry = true;
		}
		else //If user entered any other kind of number
		{
		    c.setColor (Color.black);
		    c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
		    c.drawString ("Error, you have not entered 1, 2, 3, or 4. Press any key to try again.", 35, 467);
		    c.getChar ();
		    c.setColor (Color.white);
		    c.fillRect (350, 425, 650, 13);
		    c.fillRect (0, 455, 650, 15);
		    validEntry = false;
		}
	    }


	    catch (NumberFormatException e)  //If user entered any other kind of input
	    {
		c.setColor (Color.black);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
		c.drawString ("Error, you have not entered 1, 2, 3, or 4. Press any key to try again.", 35, 467);
		c.getChar ();
		c.setColor (Color.white);
		c.fillRect (350, 425, 650, 13);
		c.fillRect (0, 455, 650, 15);
	    }
	}
	if (intUserMainOption == 1) //If user chooses 1
	{
	    start (); //Calls start() method
	}
	if (intUserMainOption == 2) //If user chooses 2
	{
	    instructionsOne (); //Calls instructionsOne() method
	}
	if (intUserMainOption == 3) //If user chooses 3
	{
	    leaderboard (); //Calls leaderboard() method
	}
	if (intUserMainOption == 4) //If user chooses 4
	{
	    goodbye (); //Calls goodbye() method
	    System.exit (0);
	}
    }


    public void instructionsOne ()  //instructions() method
    {
	c.clear (); //Clears screen
	c.setColor (Color.black);
	//Background
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}
	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}
	c.setColor (Color.red);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 30)); //Setting font
	c.drawString ("HOW TO USE THE PROGRAM", 50, 80);
	c.setColor (Color.black);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 20)); //Setting font
	//Lists how to use the program
	c.drawString ("- Select a crossword puzzle (themes are ", 50, 140);
	c.drawString ("entertainment, famous people and animals).", 75, 170);
	c.drawString ("- You will have the ability to be timed.", 50, 200);
	c.drawString ("- When solving a puzzle:", 50, 230);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 16)); //Setting font
	c.drawString ("- Enter the corresponding clue number (1-16).", 80, 260);
	c.drawString ("- Get the word right, word will be displayed on", 80, 290);
	c.drawString (" puzzle board.", 90, 320);
	c.drawString ("- Get the word wrong, will receive an error message", 80, 350);
	c.drawString ("and be asked to choose a clue number.", 100, 380);
	c.drawString ("- Do not add a space if your answer is two words.", 80, 410);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 20)); //Setting font
	c.drawString ("Press any key to continue!", 75, 468);
	c.getChar (); //Waiting until user enters any key
	instructionsTwo (); //Calls instructionTwo() method
    }


    public void instructionsTwo ()  //instructionsTwo() method
    {
	c.clear (); //Clears screen
	c.setColor (Color.black);
	//Background
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}
	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}
	//Continuing to inform user on how to use the program
	c.setColor (Color.red);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 30)); //Setting font
	c.drawString ("HOW TO USE THE PROGRAM", 50, 80);
	c.setColor (Color.black);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 16)); //Setting font
	c.drawString ("- Each word is worth 1 point (puzzle is out of 16", 80, 140);
	c.drawString ("points)", 100, 170);
	c.drawString ("- There is a cheat option. If you cheat, the", 80, 200);
	c.drawString ("answer will be given, but no points will be given.", 100, 230);
	c.drawString ("- There will also be a giveup option.", 80, 260);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 20)); //Setting font
	c.drawString ("- After completing the puzzle, you will enter", 50, 290);
	c.drawString ("your name and based on your score and time", 75, 320);
	c.drawString ("(if applicable), you will be ranked on the", 75, 350);
	c.drawString ("leaderboard.", 75, 380);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 20)); //Setting font
	c.drawString ("Press any key to go back to main menu!", 75, 468);
	c.getChar (); //Gets user to enter any key
	mainMenu (); //Calls mainMenu() method
    }


    public void start ()  //start() method
    {
	validEntry = false;
	c.clear (); //Clears screen
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}
	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 50));
	c.setColor (Color.red);
	c.drawString ("Start", 250, 70);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 24));
	c.setColor (Color.black);
	c.drawString ("Please choose from the following options: ", 45, 140);
	c.drawString ("1) Entertainment Crossword", 65, 200);
	c.drawString ("2) Famous People Crossword", 65, 290);
	c.drawString ("3) Animal Crossword", 65, 380);
	c.drawString ("Enter 1, 2, or 3: ", 65, 437);
	//Popcorn icon
	//Box
	int popcornX[] = {460, 500, 490, 470};
	int popcornY[] = {180, 180, 210, 210};
	int popcornXY = 4;
	c.setColor (Color.red);
	c.fillPolygon (popcornX, popcornY, popcornXY);
	//Kernels
	for (int i = 460 ; i < 500 ; i += 10)
	{
	    c.setColor (Color.yellow);
	    c.fillOval (i, 175, 10, 10);
	}
	for (int i = 465 ; i < 490 ; i += 10)
	{
	    c.setColor (Color.yellow);
	    c.fillOval (i, 170, 10, 10);
	}
	for (int i = 470 ; i < 490 ; i += 10)
	{
	    c.setColor (Color.yellow);
	    c.fillOval (i, 165, 10, 10);
	}
	for (int i = 470 ; i < 500 ; i += 10)
	{
	    c.setColor (Color.white);
	    c.drawLine (i, 180, i, 210);
	}
	//Person icon
	c.setColor (Color.yellow);
	c.fillOval (465, 250, 40, 40); //Head
	c.setColor (Color.black);
	c.fillOval (475, 260, 8, 8); //Eyes
	c.fillOval (487, 260, 8, 8);
	c.drawArc (475, 263, 20, 20, 320, -100); //Smile
	//Animal icon
	c.setColor (Color.blue);
	c.fillOval (380, 345, 80, 40); //Head
	c.fillArc (380, 325, 30, 40, 90, 180); //Smile
	c.fillOval (440, 325, 40, 40); //Body
	//Ear
	int animalX[] = {445, 450, 462, 443};
	int animalY[] = {307, 310, 335, 345};
	int animalXY = 4;
	c.fillPolygon (animalX, animalY, animalXY);

	for (int i = 0 ; i < 5 ; i += 1)
	{
	    c.drawLine (390 + i, 370, 380 + i, 405); //Leg 1
	    c.drawLine (410 + i, 375, 405 + i, 405); //Leg 2
	    c.drawLine (442 + i, 370, 450 + i, 400); //Leg 3
	    c.drawLine (422 + i, 370, 430 + i, 405); //Leg 4
	}
	//Eye
	c.setColor (Color.white);
	c.fillOval (460, 335, 15, 15);
	c.setColor (Color.black);
	c.fillOval (467, 340, 8, 8);
	while (!validEntry) //If user enters invalid input, will keep asking for valid input
	{
	    try
	    {
		c.setColor (Color.black);
		c.setCursor (22, 40);
		userStartOption = c.readString (); //Getting option from user as a String
		intUserStartOption = Integer.parseInt (userStartOption); //Converting userStartOption to an integer
		if (intUserStartOption == 1 || intUserStartOption == 2 || intUserStartOption == 3) //If user entered an integer, but not 1, 2, or 3
		{
		    validEntry = true;
		}
		else //If user entered any other kind of number
		{
		    c.setColor (Color.black);
		    c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
		    c.drawString ("Error, you have not entered 1, 2, or 3. Press any key to try again.", 35, 467);
		    c.getChar ();
		    c.setColor (Color.white);
		    c.fillRect (300, 425, 650, 13);
		    c.fillRect (0, 455, 650, 15);
		    validEntry = false;
		}
	    }


	    catch (NumberFormatException e)  //If user entered any other kind of input
	    {
		c.setColor (Color.black);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
		c.drawString ("Error, you have not entered 1, 2, or 3. Press any key to try again.", 35, 467);
		c.getChar ();
		c.setColor (Color.white);
		c.fillRect (300, 425, 650, 13);
		c.fillRect (0, 455, 650, 15);
	    }
	}
	timer (); //Calls timer() method
    }


    public void timer ()  //timer() method
    {
	validEntry = false;
	c.clear ();
	//Background
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}
	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 50));
	c.setColor (Color.red);
	c.drawString ("Timer", 250, 70);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 24));
	c.setColor (Color.black);
	c.drawString ("Please choose from the following options: ", 45, 140);
	c.drawString ("1) Timer", 65, 200);
	c.drawString ("2) No timer", 65, 290);
	c.drawString ("Enter 1 or 2: ", 65, 437);
	//Clock icon
	c.fillOval (350, 175, 200, 200);
	c.setColor (Color.white);
	c.fillOval (363, 187, 175, 175);
	c.setColor (Color.black);
	//Numbers on clock
	c.drawString ("12", 440, 220);
	c.drawString ("1", 480, 230);
	c.drawString ("2", 500, 255);
	c.drawString ("3", 515, 285);
	c.drawString ("4", 505, 315);
	c.drawString ("5", 480, 340);
	c.drawString ("6", 445, 350);
	c.drawString ("7", 410, 340);
	c.drawString ("8", 385, 315);
	c.drawString ("9", 375, 285);
	c.drawString ("10", 380, 255);
	c.drawString ("11", 405, 230);
	//Hands of clock
	for (int i = 0 ; i <= 3 ; i++)
	{
	    c.setColor (Color.red);
	    c.drawLine (450, 277 + i, 400, 277 + i);
	    c.drawLine (447 + i, 277, 447 + i, 230);
	}
	int triangleHorizontalX[] = {395, 405, 405};
	int triangleHorizontalY[] = {280, 290, 270};
	int triangleHorizontalXY = 3;
	c.fillPolygon (triangleHorizontalX, triangleHorizontalY, triangleHorizontalXY);
	int triangleVerticalX[] = {439, 449, 459};
	int triangleVerticalY[] = {238, 228, 238};
	int triangleVerticalXY = 3;
	c.fillPolygon (triangleVerticalX, triangleVerticalY, triangleVerticalXY);
	while (!validEntry) //If user enters invalid input, will keep asking for valid input
	{
	    try
	    {
		c.setColor (Color.black);
		c.setCursor (22, 33);
		userTimerOption = c.readString (); //Getting option from user as a String
		intUserTimerOption = Integer.parseInt (userTimerOption); //Converting userTimerOption to an integer
		if (intUserTimerOption == 1 || intUserTimerOption == 2) //If user entered an integer, but not 1 or 2
		{
		    validEntry = true;
		}
		else //If user entered any other kind of number
		{
		    c.setColor (Color.black);
		    c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
		    c.drawString ("Error, you have not entered 1 or 2. Press any key to try again.", 35, 467);
		    c.getChar ();
		    c.setColor (Color.white);
		    c.fillRect (250, 425, 650, 13);
		    c.fillRect (0, 455, 650, 15);
		    validEntry = false;
		}
	    }


	    catch (NumberFormatException e)  //If user entered any other kind of input
	    {
		c.setColor (Color.black);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
		c.drawString ("Error, you have not entered 1 or 2. Press any key to try again.", 35, 467);
		c.getChar ();
		c.setColor (Color.white);
		c.fillRect (250, 425, 650, 13);
		c.fillRect (0, 455, 650, 15);
	    }
	}
	if (intUserTimerOption == 1) //If user's choice was 1 for timer
	{
	    startTime = System.currentTimeMillis (); //Starts timer
	}
	if (intUserStartOption == 1) //If user's choice was 1 for puzzle they want to do
	{
	    puzzleOne ();
	}
	else if (intUserStartOption == 2) //If user's choice was 2 for puzzle they want to do
	{
	    puzzleTwo ();
	}
	else if (intUserStartOption == 3) //If user's choice was 3 for puzzle they want to do
	{
	    puzzleThree ();
	}
    }


    public void puzzleOne ()  //puzzleOne() method
    {
	crosswordEntertainment (); //Calls crosswordEntertainment() method
	cluesOne (); //Calls cluesOne() method
	enterWordOne (); //Calls enterWordOne() method
    }


    public void crosswordEntertainment ()  //crosswordEntertainment() method
    {
	c.clear ();
	//Border
	for (int i = 0 ; i < 5 ; i++)
	{
	    c.drawRect (0 + i, 0 + i, 475, 400);
	}
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 50));
	c.setColor (Color.red);
	c.drawString ("ENTERTAINMENT", 50, 50);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 8));
	c.setColor (Color.black);
	//Chris Hemsworth
	for (int i = 100 ; i < 380 ; i += 20)
	{
	    c.drawRect (80, i, 20, 20);
	    c.drawString ("1", 82, 110);
	}
	//Ogre
	for (int i = 40 ; i < 120 ; i += 20)
	{
	    c.drawRect (i, 140, 20, 20);
	    c.drawString ("9", 42, 150);
	}
	//Batman
	for (int i = 20 ; i < 140 ; i += 20)
	{
	    c.drawRect (i, 240, 20, 20);
	    c.drawString ("10", 22, 250);
	}
	//Starfish
	for (int i = 200 ; i < 360 ; i += 20)
	{
	    c.drawRect (40, i, 20, 20);
	    c.drawString ("2", 42, 210);
	}
	//Sesame Street
	for (int i = 80 ; i < 320 ; i += 20)
	{
	    c.drawRect (i, 180, 20, 20);
	    c.drawString ("16", 82, 190);
	}
	//Wakanda
	for (int i = 60 ; i < 200 ; i += 20)
	{
	    c.drawRect (140, i, 20, 20);
	    c.drawString ("3", 142, 70);
	}
	//Avatar
	for (int i = 140 ; i < 260 ; i += 20)
	{
	    c.drawRect (i, 80, 20, 20);
	    c.drawString ("11", 142, 90);
	}
	//Celine Dion
	for (int i = 160 ; i < 360 ; i += 20)
	{
	    c.drawRect (180, i, 20, 20);
	    c.drawString ("6", 182, 170);
	}
	//Fiona
	for (int i = 160 ; i < 260 ; i += 20)
	{
	    c.drawRect (i, 220, 20, 20);
	    c.drawString ("12", 162, 230);
	}
	//George
	for (int i = 160 ; i < 280 ; i += 20)
	{
	    c.drawRect (i, 260, 20, 20);
	    c.drawString ("14", 162, 270);
	}
	//Seven
	for (int i = 120 ; i < 220 ; i += 20)
	{
	    c.drawRect (260, i, 20, 20);
	    c.drawString ("4", 262, 130);
	}
	//JRR Tolkien
	for (int i = 120 ; i < 320 ; i += 20)
	{
	    c.drawRect (300, i, 20, 20);
	    c.drawString ("7", 302, 130);
	}
	//Pokemon
	for (int i = 160 ; i < 300 ; i += 20)
	{
	    c.drawRect (i, 320, 20, 20);
	    c.drawString ("13", 162, 330);
	}
	//JK Rowling
	for (int i = 280 ; i < 460 ; i += 20)
	{
	    c.drawRect (i, 240, 20, 20);
	    c.drawString ("15", 282, 250);
	}
	//Superman
	for (int i = 100 ; i < 260 ; i += 20)
	{
	    c.drawRect (420, i, 20, 20);
	    c.drawString ("5", 422, 110);
	}
	//Marvel
	for (int i = 140 ; i < 260 ; i += 20)
	{
	    c.drawRect (380, i, 20, 20);
	    c.drawString ("8", 382, 150);
	}
	//Popcorn icon
	//Box
	int popcornX[] = {360, 420, 410, 370};
	int popcornY[] = {330, 330, 380, 380};
	int popcornXY = 4;
	c.setColor (Color.red);
	//Kernels
	c.fillPolygon (popcornX, popcornY, popcornXY);
	for (int i = 357 ; i < 410 ; i += 15)
	{
	    c.setColor (Color.yellow);
	    c.fillOval (i, 313, 20, 20);
	}
	for (int i = 365 ; i < 400 ; i += 15)
	{
	    c.setColor (Color.yellow);
	    c.fillOval (i, 298, 20, 20);
	}
	for (int i = 370 ; i < 400 ; i += 15)
	{
	    c.setColor (Color.yellow);
	    c.fillOval (i, 288, 20, 20);
	}
	for (int i = 370 ; i < 430 ; i += 10)
	{
	    c.setColor (Color.white);
	    c.drawLine (i, 330, i, 380);
	}
    }


    public void cluesOne ()  //cluesOne() method
    {
	//Clues for puzzle
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 20));
	c.setColor (Color.red);
	c.drawString ("DOWN", 500, 25);
	c.drawString ("ACROSS", 500, 230);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 11));
	c.setColor (Color.black);
	c.drawString ("1. Actor of Thor", 500, 40);
	c.drawString ("2. What is Patrick", 500, 55);
	c.drawString ("from Spongebob", 520, 65);
	c.drawString ("3. Country of Black", 500, 80);
	c.drawString ("Panther", 520, 90);
	c.drawString ("4. # dwarves in", 500, 105);
	c.drawString ("Snow White", 520, 115);
	c.drawString ("5. Actor Henry Cavil", 500, 130);
	c.drawString ("is DC's...", 520, 140);
	c.drawString ("6. Iconic singer", 500, 155);
	c.drawString ("from the Titanic", 520, 165);
	c.drawString ("7. Author of Lord of", 500, 180);
	c.drawString ("the Rings", 520, 190);
	c.drawString ("8. Hulk: Movie maker", 500, 205);
	c.drawString ("9.  What is Shrek", 500, 245);
	c.drawString ("10. Protector of", 500, 260);
	c.drawString ("Gotham City", 528, 270);
	c.drawString ("11. Highest grossing", 500, 285);
	c.drawString ("movie", 528, 295);
	c.drawString ("12. Shrek's wife", 500, 310);
	c.drawString ("13. Gotta catch", 500, 325);
	c.drawString ("em all...", 528, 335);
	c.drawString ("14. Peppa Pig's", 500, 350);
	c.drawString ("brother", 528, 360);
	c.drawString ("15. Author of Harry", 500, 375);
	c.drawString ("Potter", 528, 385);
	c.drawString ("16. Where Elmo lives", 500, 400);
    }


    public void enterWordOne ()  //enterWordOne() method
    {
	//Resetting variables to zero each time method is called to allow while loop to run
	run = 0;
	total = 0;
	check = 0;
	checkTwo = 0;
	checkThree = 0;
	checkFour = 0;
	checkFive = 0;
	checkSix = 0;
	checkSeven = 0;
	checkEight = 0;
	checkNine = 0;
	checkTen = 0;
	checkEleven = 0;
	checkTwelve = 0;
	checkThirteen = 0;
	checkFourteen = 0;
	checkFifteen = 0;
	checkSixteen = 0;
	while (run != 16) //Runs until all 16 words are displayed on board
	{
	    validEntry = false;
	    c.setColor (Color.white);
	    c.fillRect (125, 425, 610, 10);
	    c.fillRect (0, 445, 650, 45);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 11));
	    c.setColor (Color.black);
	    c.drawString ("To give up or cheat, enter 'giveup' or 'cheat'", 300, 484);
	    c.drawString ("respectively when prompted 'What is your guess?:'", 300, 494);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
	    c.drawString ("Enter clue #:", 20, 434);
	    while (!validEntry) //If user enters invalid input, will keep asking for valid input
	    {
		try
		{
		    c.setColor (Color.black);
		    c.setCursor (22, 17);
		    userClue = c.readString (); //Getting option from user as a String
		    intUserClue = Integer.parseInt (userClue); //Converting userClue to an integer
		    if (intUserClue > 0 && intUserClue < 17) //If user entered an integer, but not 1-16
		    {
			validEntry = true;
		    }
		    //If user already guessed the number
		    if ((intUserClue == 1 && check != 1) || (intUserClue == 2 && checkTwo != 2) || (intUserClue == 3 && checkThree != 3) || (intUserClue == 4 && checkFour != 4) || (intUserClue == 5 && checkFive != 5) || (intUserClue == 6 && checkSix != 6) || (intUserClue == 7 && checkSeven != 7) || (intUserClue == 8 && checkEight != 8) || (intUserClue == 9 && checkNine != 9) || (intUserClue == 10 && checkTen != 10) || (intUserClue == 11 && checkEleven != 11) || (intUserClue == 12 && checkTwelve != 12) || (intUserClue == 13 && checkThirteen != 13) || (intUserClue == 14 && checkFourteen != 14) || (intUserClue == 15 && checkFifteen != 15) || (intUserClue == 16 && checkSixteen != 16))
		    {
			validEntry = true;
		    }
		    else //If user entered any other kind of number
		    {
			c.setColor (Color.black);
			c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
			c.drawString ("Error, you have already guessed this", 20, 457);
			c.drawString ("number or have not entered a number", 20, 467);
			c.drawString ("from 1-16. Press any key to try again.", 20, 477);
			c.getChar ();
			c.setColor (Color.white);
			c.fillRect (125, 425, 610, 10);
			c.fillRect (0, 445, 300, 85);
			validEntry = false;
		    }
		}


		catch (NumberFormatException e)  //If user entered any other kind of input
		{
		    c.setColor (Color.black);
		    c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		    c.drawString ("Error, you have not entered a number", 20, 457);
		    c.drawString ("from 1-16. Press any key to try again.", 20, 467);
		    c.getChar ();
		    c.setColor (Color.white);
		    c.fillRect (125, 425, 610, 10);
		    c.fillRect (0, 445, 300, 85);
		}
	    }
	    c.drawString ("What is your guess?:", 20, 455);
	    c.setCursor (23, 24);
	    userCrosswordGuess = c.readLine (); //Getting user's guess
	    if ((userCrosswordGuess.toLowerCase ()).equals ("giveup")) //If user decides to give up
	    {
		break;
	    }
	    //If user decides to cheat on any of the words
	    if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 1)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 85, 115);
		c.drawString ("H", 85, 135);
		c.drawString ("R", 85, 155);
		c.drawString ("I", 85, 175);
		c.drawString ("S", 85, 195);
		c.drawString ("H", 85, 215);
		c.drawString ("E", 85, 235);
		c.drawString ("M", 85, 255);
		c.drawString ("S", 85, 275);
		c.drawString ("W", 85, 295);
		c.drawString ("O", 85, 315);
		c.drawString ("R", 85, 335);
		c.drawString ("T", 85, 355);
		c.drawString ("H", 85, 375);
		run++;
		check = 1;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 2)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 45, 215);
		c.drawString ("T", 45, 235);
		c.drawString ("A", 45, 255);
		c.drawString ("R", 45, 275);
		c.drawString ("F", 45, 295);
		c.drawString ("I", 45, 315);
		c.drawString ("S", 45, 335);
		c.drawString ("H", 45, 355);
		run++;
		checkTwo = 2;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 3)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("W", 145, 75);
		c.drawString ("A", 145, 95);
		c.drawString ("K", 145, 115);
		c.drawString ("A", 145, 135);
		c.drawString ("N", 145, 155);
		c.drawString ("D", 145, 175);
		c.drawString ("A", 145, 195);
		run++;
		checkThree = 3;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 4)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 265, 135);
		c.drawString ("E", 265, 155);
		c.drawString ("V", 265, 175);
		c.drawString ("E", 265, 195);
		c.drawString ("N", 265, 215);
		run++;
		checkFour = 4;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 5)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 425, 115);
		c.drawString ("U", 425, 135);
		c.drawString ("P", 425, 155);
		c.drawString ("E", 425, 175);
		c.drawString ("R", 425, 195);
		c.drawString ("M", 425, 215);
		c.drawString ("A", 425, 235);
		c.drawString ("N", 425, 255);
		run++;
		checkFive = 5;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 6)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 185, 175);
		c.drawString ("E", 185, 195);
		c.drawString ("L", 185, 215);
		c.drawString ("I", 185, 235);
		c.drawString ("N", 185, 255);
		c.drawString ("E", 185, 275);
		c.drawString ("D", 185, 295);
		c.drawString ("I", 185, 315);
		c.drawString ("O", 185, 335);
		c.drawString ("N", 185, 355);
		run++;
		checkSix = 6;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 7)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("J", 305, 135);
		c.drawString ("R", 305, 155);
		c.drawString ("R", 305, 175);
		c.drawString ("T", 305, 195);
		c.drawString ("O", 305, 215);
		c.drawString ("L", 305, 235);
		c.drawString ("K", 305, 255);
		c.drawString ("I", 305, 275);
		c.drawString ("E", 305, 295);
		c.drawString ("N", 305, 315);
		run++;
		checkSeven = 7;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 8)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("M", 385, 155);
		c.drawString ("A", 385, 175);
		c.drawString ("R", 385, 195);
		c.drawString ("V", 385, 215);
		c.drawString ("E", 385, 235);
		c.drawString ("L", 385, 255);
		run++;
		checkEight = 8;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 9)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("O", 45, 155);
		c.drawString ("G", 65, 155);
		c.drawString ("R", 85, 155);
		c.drawString ("E", 105, 155);
		run++;
		checkNine = 9;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 10)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("B", 25, 255);
		c.drawString ("A", 45, 255);
		c.drawString ("T", 65, 255);
		c.drawString ("M", 85, 255);
		c.drawString ("A", 105, 255);
		c.drawString ("N", 125, 255);
		run++;
		checkTen = 10;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 11)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("A", 145, 95);
		c.drawString ("V", 165, 95);
		c.drawString ("A", 185, 95);
		c.drawString ("T", 205, 95);
		c.drawString ("A", 225, 95);
		c.drawString ("R", 245, 95);
		run++;
		checkEleven = 11;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 12)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("F", 165, 235);
		c.drawString ("I", 185, 235);
		c.drawString ("O", 205, 235);
		c.drawString ("N", 225, 235);
		c.drawString ("A", 245, 235);
		run++;
		checkTwelve = 12;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 13)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("P", 165, 335);
		c.drawString ("O", 185, 335);
		c.drawString ("K", 205, 335);
		c.drawString ("E", 225, 335);
		c.drawString ("M", 245, 335);
		c.drawString ("O", 265, 335);
		c.drawString ("N", 285, 335);
		run++;
		checkThirteen = 13;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 14)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("G", 165, 275);
		c.drawString ("E", 185, 275);
		c.drawString ("O", 205, 275);
		c.drawString ("R", 225, 275);
		c.drawString ("G", 245, 275);
		c.drawString ("E", 265, 275);
		run++;
		checkFourteen = 14;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 15)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("J", 285, 255);
		c.drawString ("K", 305, 255);
		c.drawString ("R", 325, 255);
		c.drawString ("O", 345, 255);
		c.drawString ("W", 365, 255);
		c.drawString ("L", 385, 255);
		c.drawString ("I", 405, 255);
		c.drawString ("N", 425, 255);
		c.drawString ("G", 445, 255);
		run++;
		checkFifteen = 15;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 16)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 85, 195);
		c.drawString ("E", 105, 195);
		c.drawString ("S", 125, 195);
		c.drawString ("A", 145, 195);
		c.drawString ("M", 165, 195);
		c.drawString ("E", 185, 195);
		c.drawString ("S", 205, 195);
		c.drawString ("T", 225, 195);
		c.drawString ("R", 245, 195);
		c.drawString ("E", 265, 195);
		c.drawString ("E", 285, 195);
		c.drawString ("T", 305, 195);
		run++;
		checkSixteen = 16;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    //If user guessed clues correctly
	    else if (intUserClue == 1 && (userCrosswordGuess.toLowerCase ()).equals ("chrishemsworth"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 85, 115);
		c.drawString ("H", 85, 135);
		c.drawString ("R", 85, 155);
		c.drawString ("I", 85, 175);
		c.drawString ("S", 85, 195);
		c.drawString ("H", 85, 215);
		c.drawString ("E", 85, 235);
		c.drawString ("M", 85, 255);
		c.drawString ("S", 85, 275);
		c.drawString ("W", 85, 295);
		c.drawString ("O", 85, 315);
		c.drawString ("R", 85, 335);
		c.drawString ("T", 85, 355);
		c.drawString ("H", 85, 375);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		check = 1;
		c.getChar ();
	    }
	    else if (intUserClue == 2 && (userCrosswordGuess.toLowerCase ()).equals ("starfish"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 45, 215);
		c.drawString ("T", 45, 235);
		c.drawString ("A", 45, 255);
		c.drawString ("R", 45, 275);
		c.drawString ("F", 45, 295);
		c.drawString ("I", 45, 315);
		c.drawString ("S", 45, 335);
		c.drawString ("H", 45, 355);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTwo = 2;
		c.getChar ();
	    }
	    else if (intUserClue == 3 && (userCrosswordGuess.toLowerCase ()).equals ("wakanda"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("W", 145, 75);
		c.drawString ("A", 145, 95);
		c.drawString ("K", 145, 115);
		c.drawString ("A", 145, 135);
		c.drawString ("N", 145, 155);
		c.drawString ("D", 145, 175);
		c.drawString ("A", 145, 195);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkThree = 3;
		c.getChar ();
	    }
	    else if (intUserClue == 4 && (userCrosswordGuess.toLowerCase ()).equals ("seven"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 265, 135);
		c.drawString ("E", 265, 155);
		c.drawString ("V", 265, 175);
		c.drawString ("E", 265, 195);
		c.drawString ("N", 265, 215);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFour = 4;
		c.getChar ();
	    }
	    else if (intUserClue == 5 && (userCrosswordGuess.toLowerCase ()).equals ("superman"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 425, 115);
		c.drawString ("U", 425, 135);
		c.drawString ("P", 425, 155);
		c.drawString ("E", 425, 175);
		c.drawString ("R", 425, 195);
		c.drawString ("M", 425, 215);
		c.drawString ("A", 425, 235);
		c.drawString ("N", 425, 255);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFive = 5;
		c.getChar ();
	    }
	    else if (intUserClue == 6 && (userCrosswordGuess.toLowerCase ()).equals ("celinedion"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 185, 175);
		c.drawString ("E", 185, 195);
		c.drawString ("L", 185, 215);
		c.drawString ("I", 185, 235);
		c.drawString ("N", 185, 255);
		c.drawString ("E", 185, 275);
		c.drawString ("D", 185, 295);
		c.drawString ("I", 185, 315);
		c.drawString ("O", 185, 335);
		c.drawString ("N", 185, 355);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSix = 6;
		c.getChar ();
	    }
	    else if (intUserClue == 7 && (userCrosswordGuess.toLowerCase ()).equals ("jrrtolkien"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("J", 305, 135);
		c.drawString ("R", 305, 155);
		c.drawString ("R", 305, 175);
		c.drawString ("T", 305, 195);
		c.drawString ("O", 305, 215);
		c.drawString ("L", 305, 235);
		c.drawString ("K", 305, 255);
		c.drawString ("I", 305, 275);
		c.drawString ("E", 305, 295);
		c.drawString ("N", 305, 315);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSeven = 7;
		c.getChar ();
	    }
	    else if (intUserClue == 8 && (userCrosswordGuess.toLowerCase ()).equals ("marvel"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("M", 385, 155);
		c.drawString ("A", 385, 175);
		c.drawString ("R", 385, 195);
		c.drawString ("V", 385, 215);
		c.drawString ("E", 385, 235);
		c.drawString ("L", 385, 255);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkEight = 8;
		c.getChar ();
	    }
	    else if (intUserClue == 9 && (userCrosswordGuess.toLowerCase ()).equals ("ogre"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("O", 45, 155);
		c.drawString ("G", 65, 155);
		c.drawString ("R", 85, 155);
		c.drawString ("E", 105, 155);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkNine = 9;
		c.getChar ();
	    }
	    else if (intUserClue == 10 && (userCrosswordGuess.toLowerCase ()).equals ("batman"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("B", 25, 255);
		c.drawString ("A", 45, 255);
		c.drawString ("T", 65, 255);
		c.drawString ("M", 85, 255);
		c.drawString ("A", 105, 255);
		c.drawString ("N", 125, 255);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTen = 10;
		c.getChar ();
	    }
	    else if (intUserClue == 11 && (userCrosswordGuess.toLowerCase ()).equals ("avatar"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("A", 145, 95);
		c.drawString ("V", 165, 95);
		c.drawString ("A", 185, 95);
		c.drawString ("T", 205, 95);
		c.drawString ("A", 225, 95);
		c.drawString ("R", 245, 95);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkEleven = 11;
		c.getChar ();
	    }
	    else if (intUserClue == 12 && (userCrosswordGuess.toLowerCase ()).equals ("fiona"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("F", 165, 235);
		c.drawString ("I", 185, 235);
		c.drawString ("O", 205, 235);
		c.drawString ("N", 225, 235);
		c.drawString ("A", 245, 235);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTwelve = 12;
		c.getChar ();
	    }
	    else if (intUserClue == 13 && (userCrosswordGuess.toLowerCase ()).equals ("pokemon"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("P", 165, 335);
		c.drawString ("O", 185, 335);
		c.drawString ("K", 205, 335);
		c.drawString ("E", 225, 335);
		c.drawString ("M", 245, 335);
		c.drawString ("O", 265, 335);
		c.drawString ("N", 285, 335);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkThirteen = 13;
		c.getChar ();
	    }
	    else if (intUserClue == 14 && (userCrosswordGuess.toLowerCase ()).equals ("george"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("G", 165, 275);
		c.drawString ("E", 185, 275);
		c.drawString ("O", 205, 275);
		c.drawString ("R", 225, 275);
		c.drawString ("G", 245, 275);
		c.drawString ("E", 265, 275);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFourteen = 14;
		c.getChar ();
	    }
	    else if (intUserClue == 15 && (userCrosswordGuess.toLowerCase ()).equals ("jkrowling"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("J", 285, 255);
		c.drawString ("K", 305, 255);
		c.drawString ("R", 325, 255);
		c.drawString ("O", 345, 255);
		c.drawString ("W", 365, 255);
		c.drawString ("L", 385, 255);
		c.drawString ("I", 405, 255);
		c.drawString ("N", 425, 255);
		c.drawString ("G", 445, 255);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFifteen = 15;
		c.getChar ();
	    }
	    else if (intUserClue == 16 && (userCrosswordGuess.toLowerCase ()).equals ("sesamestreet"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 85, 195);
		c.drawString ("E", 105, 195);
		c.drawString ("S", 125, 195);
		c.drawString ("A", 145, 195);
		c.drawString ("M", 165, 195);
		c.drawString ("E", 185, 195);
		c.drawString ("S", 205, 195);
		c.drawString ("T", 225, 195);
		c.drawString ("R", 245, 195);
		c.drawString ("E", 265, 195);
		c.drawString ("E", 285, 195);
		c.drawString ("T", 305, 195);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSixteen = 16;
		c.getChar ();
	    }
	    //If user guessed clue wrong
	    else
	    {
		c.setColor (Color.red);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("NO! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		c.getChar ();
	    }
	}
	if (intUserTimerOption == 1) //If the user wanted to be timed
	{
	    finishTimer (); //Calls finishTimer() method
	}
	if (intUserTimerOption == 2) //If the user did not want to be timed
	{
	    finishNoTimer (); //Calls finishNoTimer() method
	}
    }


    public void puzzleTwo ()  //Famous people puzzle
    {
	crosswordFamousPeople (); //Calls crosswordFamousPeople() method
	cluesTwo (); //Calls cluesTwo() method
	enterWordTwo (); //Calls enterWordTwo()method
    }


    public void crosswordFamousPeople ()  //crosswordFamousPeople() method
    {
	c.clear ();
	//Border
	for (int i = 0 ; i < 5 ; i++)
	{
	    c.drawRect (0 + i, 0 + i, 475, 410);
	}
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 47));
	c.setColor (Color.red);
	c.drawString ("FAMOUS", 130, 40);
	c.drawString ("PEOPLE", 285, 73);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 8));
	c.setColor (Color.black);


	for (int x = 0 ; x < 240 ; x += 20) //if word is 12 letters long
	{
	    //vertical
	    c.drawRect (140, 115 + x, 20, 20); //Gordon Ramsay (11)
	    c.drawString ("11", 142, 125);

	    c.drawRect (320, 175 + x, 20, 20); //XXXTentacion (15)
	    c.drawString ("15", 322, 185);

	    c.drawRect (420, 175 + x, 20, 20); //Justin Bieber (16)
	    c.drawString ("16", 422, 185);



	    if (x < 220) //if word is 11 letters long
	    {
		//vertical
		c.drawRect (100, 35 + x, 20, 20); //Shakespeare (10)
		c.drawString ("10", 102, 45);
		//horizantal
		c.drawRect (200 + x, 135, 20, 20); //Kardashians (3)
		c.drawString ("3", 202, 145);
	    }

	    if (x < 180) //if word is 9 letters long
	    {
		//horizantal
		c.drawRect (20 + x, 155, 20, 20); //Rosa Parks (4)
		c.drawString ("4", 22, 165);
		c.drawRect (280 + x, 275, 20, 20); //Anne Frank (6)
		c.drawString ("6", 282, 285);
	    }

	    if (x < 160) //if word is 8 letters long
	    {
		//horizantal
		c.drawRect (260 + x, 95, 20, 20); //Einstein (2)
		c.drawString ("2", 262, 105);
		c.drawRect (180 + x, 175, 20, 20); //Terry Fox (5)
		c.drawString ("5", 182, 185);
	    }

	    if (x < 140) //if word is 7 letters long
	    {
		//horizantal
		c.drawRect (20 + x, 315, 20, 20); //Shakira (7)
		c.drawString ("7", 22, 325);


		//vertical
		c.drawRect (220, 175 + x, 20, 20); //Ronaldo (13)
		c.drawString ("13", 222, 185);
		c.drawRect (260, 75 + x, 20, 20); //Zendaya (14)
		c.drawString ("14", 262, 85);
	    }

	    if (x < 120) //if word is 6 letters long
	    {
		//vertical
		c.drawRect (180, 155 + x, 20, 20); //Stormi (12)
		c.drawString ("12", 182, 165);
	    }

	    if (x < 100) //if word is 5 letters long
	    {
		//vertical
		c.drawRect (40, 155 + x, 20, 20); //Obama (8)
		c.drawString ("8", 42, 165);
		//horizantal
		c.drawRect (60 + x, 75, 20, 20); //Drake (1)
		c.drawString ("1", 62, 85);
	    }

	    if (x < 80) //if word is 4 letters long
	    {
		//vertical
		c.drawRect (80, 315 + x, 20, 20); //Kobe (9)
		c.drawString ("9", 82, 325);
	    }
	}


	//Person icon
	c.setColor (Color.yellow);
	c.fillOval (220, 330, 50, 50); //face
	c.setColor (Color.white);
	c.fillOval (230, 340, 12, 12); //right eye
	c.fillOval (242, 340, 12, 12); //left eye
	c.setColor (Color.black);
	c.drawOval (220, 330, 50, 50); //face
	c.drawOval (230, 340, 12, 12); //right eye
	c.drawOval (242, 340, 12, 12); //left eye
	c.fillOval (230, 340, 8, 8); //right eye
	c.fillOval (242, 340, 8, 8); //left eye
	for (int i = 0 ; i < 3 ; i++)
	{
	    c.drawLine (240, 340 + i, 228, 335 + i); //eyebrow
	    c.drawLine (247, 340 + i, 260, 330 + i); //eyebrow
	}
	c.drawArc (230, 343, 20, 20, 350, -100);  //smile
    }




    public void cluesTwo ()  //cluesTwo() method
    {
	//Displaying clues for puzzle
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 20));
	c.setColor (Color.red);
	c.drawString ("DOWN", 500, 25);
	c.drawString ("ACROSS", 500, 230);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 11));
	c.setColor (Color.black);
	c.drawString ("1. OVO", 492, 40);
	c.drawString ("2. E = mc^2", 492, 55);
	c.drawString ("3. Family rich for", 492, 70);
	c.drawString ("   their wealth/drama", 492, 80);
	c.drawString ("4. Refused to give", 492, 95);
	c.drawString ("   up bus seat", 492, 110);
	c.drawString ("5. Students run for", 492, 125);
	c.drawString ("   him every year", 492, 135);
	c.drawString ("6. Holocaust diary", 492, 150);
	c.drawString ("7. Hips don't lie", 492, 165);
	c.drawString ("8. Obama's last name", 492, 245);
	c.drawString ("9. Name said before", 492, 260);
	c.drawString ("   shooting a basket", 492, 270);
	c.drawString ("10. Romeo & Juliet", 492, 285);
	c.drawString ("11. Idiot sandwich", 492, 300);
	c.drawString ("12. Kylie's daughter", 492, 315);
	c.drawString ("13. Suiiiii", 492, 330);
	c.drawString ("14. Tom Holland's gf", 492, 345);
	c.drawString ("15. Rapper with 10's", 492, 360);
	c.drawString ("16. Baby, baby, baby", 492, 375);
    }


    public void enterWordTwo ()  //enterWordTwo() method
    {
	//Resetting variables to zero each time method is called to allow while loop to run
	run = 0;
	total = 0;
	check = 0;
	checkTwo = 0;
	checkThree = 0;
	checkFour = 0;
	checkFive = 0;
	checkSix = 0;
	checkSeven = 0;
	checkEight = 0;
	checkNine = 0;
	checkTen = 0;
	checkEleven = 0;
	checkTwelve = 0;
	checkThirteen = 0;
	checkFourteen = 0;
	checkFifteen = 0;
	checkSixteen = 0;
	while (run != 16) //Will run until all 16 words are displayed on box grid
	{
	    validEntry = false;
	    c.setColor (Color.white);
	    c.fillRect (125, 425, 610, 10);
	    c.fillRect (0, 445, 650, 45);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 11));
	    c.setColor (Color.black);
	    c.drawString ("To give up or cheat, enter 'giveup' or 'cheat'", 300, 484);
	    c.drawString ("respectively when prompted 'What is your guess?:'", 300, 494);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
	    c.drawString ("Enter clue #:", 20, 434);
	    while (!validEntry) //If user enters invalid input, will keep asking for valid input
	    {
		try
		{
		    c.setColor (Color.black);
		    c.setCursor (22, 17);
		    userClue = c.readString (); //Getting option from user as a String
		    intUserClue = Integer.parseInt (userClue); //Converting userClue to an integer
		    if (intUserClue > 0 && intUserClue < 17) //If user entered an integer, but not from 1-16
		    {
			validEntry = true;
		    }
		    //If user enters a number they already guessed or cheated on
		    if ((intUserClue == 1 && check != 1) || (intUserClue == 2 && checkTwo != 2) || (intUserClue == 3 && checkThree != 3) || (intUserClue == 4 && checkFour != 4) || (intUserClue == 5 && checkFive != 5) || (intUserClue == 6 && checkSix != 6) || (intUserClue == 7 && checkSeven != 7) || (intUserClue == 8 && checkEight != 8) || (intUserClue == 9 && checkNine != 9) || (intUserClue == 10 && checkTen != 10) || (intUserClue == 11 && checkEleven != 11) || (intUserClue == 12 && checkTwelve != 12) || (intUserClue == 13 && checkThirteen != 13) || (intUserClue == 14 && checkFourteen != 14) || (intUserClue == 15 && checkFifteen != 15) || (intUserClue == 16 && checkSixteen != 16))
		    {
			validEntry = true;
		    }
		    else //If user entered any other kind of number
		    {
			c.setColor (Color.black);
			c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
			c.drawString ("Error, you have already guessed this", 20, 457);
			c.drawString ("number or have not entered a number", 20, 467);
			c.drawString ("from 1-16. Press any key to try again.", 20, 477);
			c.getChar ();
			c.setColor (Color.white);
			c.fillRect (125, 425, 610, 10);
			c.fillRect (0, 445, 300, 85);
			validEntry = false;
		    }
		}


		catch (NumberFormatException e)  //If user entered any other kind of input
		{
		    c.setColor (Color.black);
		    c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		    c.drawString ("Error, you have not entered a number", 20, 457);
		    c.drawString ("from 1-16. Press any key to try again.", 20, 467);
		    c.getChar ();
		    c.setColor (Color.white);
		    c.fillRect (125, 425, 610, 10);
		    c.fillRect (0, 445, 300, 85);
		}
	    }
	    c.drawString ("What is your guess?:", 20, 455);
	    c.setCursor (23, 24);
	    userCrosswordGuess = c.readLine (); //Getting user's guess
	    if ((userCrosswordGuess.toLowerCase ()).equals ("giveup")) //If user decides to give up
	    {
		break;
	    }
	    //If user decides to cheat on any of the words
	    if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 1)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("D", 65, 90);
		c.drawString ("R", 85, 90);
		c.drawString ("A", 105, 90);
		c.drawString ("K", 125, 90);
		c.drawString ("E", 145, 90);

		run++;
		check = 1;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 2)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));

		c.drawString ("E", 265, 110);
		c.drawString ("I", 285, 110);
		c.drawString ("N", 305, 110);
		c.drawString ("S", 325, 110);
		c.drawString ("T", 345, 110);
		c.drawString ("E", 365, 110);
		c.drawString ("I", 385, 110);
		c.drawString ("N", 405, 110);
		run++;
		checkTwo = 2;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 3)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("K", 205, 150);
		c.drawString ("A", 225, 150);
		c.drawString ("R", 245, 150);
		c.drawString ("D", 265, 150);
		c.drawString ("A", 285, 150);
		c.drawString ("S", 305, 150);
		c.drawString ("H", 325, 150);
		c.drawString ("I", 345, 150);
		c.drawString ("A", 365, 150);
		c.drawString ("N", 385, 150);
		c.drawString ("S", 405, 150);

		run++;
		checkThree = 3;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 4)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("R", 25, 170);
		c.drawString ("O", 45, 170);
		c.drawString ("S", 65, 170);
		c.drawString ("A", 85, 170);
		c.drawString ("P", 105, 170);
		c.drawString ("A", 125, 170);
		c.drawString ("R", 145, 170);
		c.drawString ("K", 165, 170);
		c.drawString ("S", 185, 170);
		run++;
		checkFour = 4;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 5)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("T", 185, 190);
		c.drawString ("E", 205, 190);
		c.drawString ("R", 225, 190);
		c.drawString ("R", 245, 190);
		c.drawString ("Y", 265, 190);
		c.drawString ("F", 285, 190);
		c.drawString ("O", 305, 190);
		c.drawString ("X", 325, 190);
		run++;
		checkFive = 5;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 6)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("A", 285, 290);
		c.drawString ("N", 305, 290);
		c.drawString ("N", 325, 290);
		c.drawString ("E", 345, 290);
		c.drawString ("F", 365, 290);
		c.drawString ("R", 385, 290);
		c.drawString ("A", 405, 290);
		c.drawString ("N", 425, 290);
		c.drawString ("K", 445, 290);

		run++;
		checkSix = 6;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 7)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 25, 330);
		c.drawString ("H", 45, 330);
		c.drawString ("A", 65, 330);
		c.drawString ("K", 85, 330);
		c.drawString ("I", 105, 330);
		c.drawString ("R", 125, 330);
		c.drawString ("A", 145, 330);
		run++;
		checkSeven = 7;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 8)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("O", 45, 170);
		c.drawString ("B", 45, 190);
		c.drawString ("A", 45, 210);
		c.drawString ("M", 45, 230);
		c.drawString ("A", 45, 250);
		run++;
		checkEight = 8;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 9)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("K", 85, 330);
		c.drawString ("O", 85, 350);
		c.drawString ("B", 85, 370);
		c.drawString ("E", 85, 390);

		run++;
		checkNine = 9;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 10)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));

		c.drawString ("S", 105, 50);
		c.drawString ("H", 105, 70);
		c.drawString ("A", 105, 90);
		c.drawString ("K", 105, 110);
		c.drawString ("E", 105, 130);
		c.drawString ("S", 105, 150);
		c.drawString ("P", 105, 170);
		c.drawString ("E", 105, 190);
		c.drawString ("A", 105, 210);
		c.drawString ("R", 105, 230);
		c.drawString ("E", 105, 250);
		run++;
		checkTen = 10;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 11)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("G", 145, 130);
		c.drawString ("O", 145, 150);
		c.drawString ("R", 145, 170);
		c.drawString ("D", 145, 190);
		c.drawString ("O", 145, 210);
		c.drawString ("N", 145, 230);
		c.drawString ("R", 145, 250);
		c.drawString ("A", 145, 270);
		c.drawString ("M", 145, 290);
		c.drawString ("S", 145, 310);
		c.drawString ("A", 145, 330);
		c.drawString ("Y", 145, 350);
		run++;
		checkEleven = 11;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 12)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 185, 170);
		c.drawString ("T", 185, 190);
		c.drawString ("O", 185, 210);
		c.drawString ("R", 185, 230);
		c.drawString ("M", 185, 250);
		c.drawString ("I", 185, 270);
		run++;
		checkTwelve = 12;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 13)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("R", 225, 190);
		c.drawString ("O", 225, 210);
		c.drawString ("N", 225, 230);
		c.drawString ("A", 225, 250);
		c.drawString ("L", 225, 270);
		c.drawString ("D", 225, 290);
		c.drawString ("O", 225, 310);
		run++;
		checkThirteen = 13;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 14)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));

		c.drawString ("Z", 265, 90);
		c.drawString ("E", 265, 110);
		c.drawString ("N", 265, 130);
		c.drawString ("D", 265, 150);
		c.drawString ("A", 265, 170);
		c.drawString ("Y", 265, 190);
		c.drawString ("A", 265, 210);
		run++;
		checkFourteen = 14;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 15)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("X", 325, 190);
		c.drawString ("X", 325, 210);
		c.drawString ("X", 325, 230);
		c.drawString ("T", 325, 250);
		c.drawString ("E", 325, 270);
		c.drawString ("N", 325, 290);
		c.drawString ("T", 325, 310);
		c.drawString ("A", 325, 330);
		c.drawString ("C", 325, 350);
		c.drawString ("I", 325, 370);
		c.drawString ("O", 325, 390);
		c.drawString ("N", 325, 410);
		run++;
		checkFifteen = 15;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 16)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("J", 425, 190);
		c.drawString ("U", 425, 210);
		c.drawString ("S", 425, 230);
		c.drawString ("T", 425, 250);
		c.drawString ("I", 425, 270);
		c.drawString ("N", 425, 290);
		c.drawString ("B", 425, 310);
		c.drawString ("I", 425, 330);
		c.drawString ("E", 425, 350);
		c.drawString ("B", 425, 370);
		c.drawString ("E", 425, 390);
		c.drawString ("R", 425, 410);
		run++;
		checkSixteen = 16;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }

	    //If user guesses any of the words correctly
	    else if (intUserClue == 1 && (userCrosswordGuess.toLowerCase ()).equals ("drake"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("D", 65, 90);
		c.drawString ("R", 85, 90);
		c.drawString ("A", 105, 90);
		c.drawString ("K", 125, 90);
		c.drawString ("E", 145, 90);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		check = 1;
		c.getChar ();
	    }
	    else if (intUserClue == 2 && (userCrosswordGuess.toLowerCase ()).equals ("einstein"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("E", 265, 110);
		c.drawString ("I", 285, 110);
		c.drawString ("N", 305, 110);
		c.drawString ("S", 325, 110);
		c.drawString ("T", 345, 110);
		c.drawString ("E", 365, 110);
		c.drawString ("I", 385, 110);
		c.drawString ("N", 405, 110);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTwo = 2;
		c.getChar ();
	    }
	    else if (intUserClue == 3 && (userCrosswordGuess.toLowerCase ()).equals ("kardashians"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("K", 205, 150);
		c.drawString ("A", 225, 150);
		c.drawString ("R", 245, 150);
		c.drawString ("D", 265, 150);
		c.drawString ("A", 285, 150);
		c.drawString ("S", 305, 150);
		c.drawString ("H", 325, 150);
		c.drawString ("I", 345, 150);
		c.drawString ("A", 365, 150);
		c.drawString ("N", 385, 150);
		c.drawString ("S", 405, 150);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkThree = 3;
		c.getChar ();
	    }
	    else if (intUserClue == 4 && (userCrosswordGuess.toLowerCase ()).equals ("rosaparks"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("R", 25, 170);
		c.drawString ("O", 45, 170);
		c.drawString ("S", 65, 170);
		c.drawString ("A", 85, 170);
		c.drawString ("P", 105, 170);
		c.drawString ("A", 125, 170);
		c.drawString ("R", 145, 170);
		c.drawString ("K", 165, 170);
		c.drawString ("S", 185, 170);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFour = 4;
		c.getChar ();
	    }
	    else if (intUserClue == 5 && (userCrosswordGuess.toLowerCase ()).equals ("terryfox"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("T", 185, 190);
		c.drawString ("E", 205, 190);
		c.drawString ("R", 225, 190);
		c.drawString ("R", 245, 190);
		c.drawString ("Y", 265, 190);
		c.drawString ("F", 285, 190);
		c.drawString ("O", 305, 190);
		c.drawString ("X", 325, 190);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFive = 5;
		c.getChar ();
	    }
	    else if (intUserClue == 6 && (userCrosswordGuess.toLowerCase ()).equals ("annefrank"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("A", 285, 290);
		c.drawString ("N", 305, 290);
		c.drawString ("N", 325, 290);
		c.drawString ("E", 345, 290);
		c.drawString ("F", 365, 290);
		c.drawString ("R", 385, 290);
		c.drawString ("A", 405, 290);
		c.drawString ("N", 425, 290);
		c.drawString ("K", 445, 290);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSix = 6;
		c.getChar ();
	    }
	    else if (intUserClue == 7 && (userCrosswordGuess.toLowerCase ()).equals ("shakira"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 25, 330);
		c.drawString ("H", 45, 330);
		c.drawString ("A", 65, 330);
		c.drawString ("K", 85, 330);
		c.drawString ("I", 105, 330);
		c.drawString ("R", 125, 330);
		c.drawString ("A", 145, 330);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSeven = 7;
		c.getChar ();
	    }
	    else if (intUserClue == 8 && (userCrosswordGuess.toLowerCase ()).equals ("obama"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("O", 45, 170);
		c.drawString ("B", 45, 190);
		c.drawString ("A", 45, 210);
		c.drawString ("M", 45, 230);
		c.drawString ("A", 45, 250);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkEight = 8;
		c.getChar ();
	    }
	    else if (intUserClue == 9 && (userCrosswordGuess.toLowerCase ()).equals ("kobe"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("K", 85, 330);
		c.drawString ("O", 85, 350);
		c.drawString ("B", 85, 370);
		c.drawString ("E", 85, 390);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkNine = 9;
		c.getChar ();
	    }
	    else if (intUserClue == 10 && (userCrosswordGuess.toLowerCase ()).equals ("shakespeare"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 105, 50);
		c.drawString ("H", 105, 70);
		c.drawString ("A", 105, 90);
		c.drawString ("K", 105, 110);
		c.drawString ("E", 105, 130);
		c.drawString ("S", 105, 150);
		c.drawString ("P", 105, 170);
		c.drawString ("E", 105, 190);
		c.drawString ("A", 105, 210);
		c.drawString ("R", 105, 230);
		c.drawString ("E", 105, 250);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTen = 10;
		c.getChar ();
	    }
	    else if (intUserClue == 11 && (userCrosswordGuess.toLowerCase ()).equals ("gordonramsay"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("G", 145, 130);
		c.drawString ("O", 145, 150);
		c.drawString ("R", 145, 170);
		c.drawString ("D", 145, 190);
		c.drawString ("O", 145, 210);
		c.drawString ("N", 145, 230);
		c.drawString ("R", 145, 250);
		c.drawString ("A", 145, 270);
		c.drawString ("M", 145, 290);
		c.drawString ("S", 145, 310);
		c.drawString ("A", 145, 330);
		c.drawString ("Y", 145, 350);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkEleven = 11;
		c.getChar ();
	    }
	    else if (intUserClue == 12 && (userCrosswordGuess.toLowerCase ()).equals ("stormi"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 185, 170);
		c.drawString ("T", 185, 190);
		c.drawString ("O", 185, 210);
		c.drawString ("R", 185, 230);
		c.drawString ("M", 185, 250);
		c.drawString ("I", 185, 270);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTwelve = 12;
		c.getChar ();
	    }
	    else if (intUserClue == 13 && (userCrosswordGuess.toLowerCase ()).equals ("ronaldo"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("R", 225, 190);
		c.drawString ("O", 225, 210);
		c.drawString ("N", 225, 230);
		c.drawString ("A", 225, 250);
		c.drawString ("L", 225, 270);
		c.drawString ("D", 225, 290);
		c.drawString ("O", 225, 310);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkThirteen = 13;
		c.getChar ();
	    }
	    else if (intUserClue == 14 && (userCrosswordGuess.toLowerCase ()).equals ("zendaya"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("Z", 265, 90);
		c.drawString ("E", 265, 110);
		c.drawString ("N", 265, 130);
		c.drawString ("D", 265, 150);
		c.drawString ("A", 265, 170);
		c.drawString ("Y", 265, 190);
		c.drawString ("A", 265, 210);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFourteen = 14;
		c.getChar ();
	    }
	    else if (intUserClue == 15 && (userCrosswordGuess.toLowerCase ()).equals ("xxxtentacion"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("X", 325, 190);
		c.drawString ("X", 325, 210);
		c.drawString ("X", 325, 230);
		c.drawString ("T", 325, 250);
		c.drawString ("E", 325, 270);
		c.drawString ("N", 325, 290);
		c.drawString ("T", 325, 310);
		c.drawString ("A", 325, 330);
		c.drawString ("C", 325, 350);
		c.drawString ("I", 325, 370);
		c.drawString ("O", 325, 390);
		c.drawString ("N", 325, 410);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFifteen = 15;
		c.getChar ();
	    }
	    else if (intUserClue == 16 && (userCrosswordGuess.toLowerCase ()).equals ("justinbieber"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("J", 425, 190);
		c.drawString ("U", 425, 210);
		c.drawString ("S", 425, 230);
		c.drawString ("T", 425, 250);
		c.drawString ("I", 425, 270);
		c.drawString ("N", 425, 290);
		c.drawString ("B", 425, 310);
		c.drawString ("I", 425, 330);
		c.drawString ("E", 425, 350);
		c.drawString ("B", 425, 370);
		c.drawString ("E", 425, 390);
		c.drawString ("R", 425, 410);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSixteen = 16;
		c.getChar ();
	    }
	    //If user guesses clue wrong
	    else
	    {
		c.setColor (Color.red);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("NO! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		c.getChar ();
	    }
	}
	if (intUserTimerOption == 1) //If user wanted to be timed
	{
	    finishTimer (); //Calls finishTimer() method
	}
	if (intUserTimerOption == 2) //If user did not want to be timed
	{
	    finishNoTimer (); //Calls finishNotTimer() method
	}
    }



    public void puzzleThree ()
    {
	crosswordAnimals ();
	cluesThree ();
	enterWordThree ();
    }


    public void crosswordAnimals ()
    {
	c.clear ();
	//Border
	for (int i = 0 ; i < 5 ; i++)
	{
	    c.drawRect (0 + i, 0 + i, 475, 405);
	}
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 50));
	c.setColor (Color.red);
	c.drawString ("ANIMALS", 120, 50);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 8));
	c.setColor (Color.black);

	////////////////////////////////////////////
	//Snake
	for (int i = 60 ; i < 160 ; i += 20)
	{
	    c.drawRect (140, i, 20, 20);
	    c.drawString ("1", 142, 70);
	}
	//Cat
	for (int i = 60 ; i < 120 ; i += 20)
	{
	    c.drawRect (i, 220, 20, 20);
	    c.drawString ("10", 62, 230);
	}
	//Turkey
	for (int i = 60 ; i < 180 ; i += 20)
	{
	    c.drawRect (i, 140, 20, 20);
	    c.drawString ("11", 62, 150);
	}
	//Pig
	for (int i = 160 ; i < 220 ; i += 20)
	{
	    c.drawRect (40, i, 20, 20);
	    c.drawString ("3", 42, 170);
	}
	//Pigeon
	for (int i = 20 ; i < 140 ; i += 20)
	{
	    c.drawRect (i, 180, 20, 20);
	    c.drawString ("12", 22, 190);
	}
	//Peacock
	for (int i = 200 ; i < 340 ; i += 20)
	{
	    c.drawRect (140, i, 20, 20);
	    c.drawString ("4", 142, 210);
	}
	//Cheetah
	for (int i = 220 ; i < 360 ; i += 20)
	{
	    c.drawRect (240, i, 20, 20);
	    c.drawString ("5", 242, 230);
	}
	//Bear
	for (int i = 220 ; i < 300 ; i += 20)
	{
	    c.drawRect (320, i, 20, 20);
	    c.drawString ("6", 322, 230);
	}
	//Horse
	for (int i = 240 ; i < 320 ; i += 20)
	{
	    c.drawRect (i, 240, 20, 20);
	    c.drawString ("13", 242, 250);
	}
	//Rooster
	for (int i = 140 ; i < 280 ; i += 20)
	{
	    c.drawRect (100, i, 20, 20);
	    c.drawString ("2", 102, 150);
	}
	//Cow
	for (int i = 280 ; i < 340 ; i += 20)
	{
	    c.drawRect (i, 360, 20, 20);
	    c.drawString ("7", 282, 370);
	}
	//Crocodile
	for (int i = 80 ; i < 260 ; i += 20)
	{
	    c.drawRect (i, 260, 20, 20);
	    c.drawString ("14", 82, 270);
	}
	//Dog
	for (int i = 260 ; i < 320 ; i += 20)
	{
	    c.drawRect (180, i, 20, 20);
	    c.drawString ("8", 182, 270);
	}
	//Human
	for (int i = 80 ; i < 180 ; i += 20)
	{
	    c.drawRect (i, 100, 20, 20);
	    c.drawString ("9", 82, 110);
	}
	//Seagull
	for (int i = 200 ; i < 340 ; i += 20)
	{
	    c.drawRect (i, 320, 20, 20);
	    c.drawString ("15", 202, 330);
	}
	//Lion
	for (int i = 320 ; i < 400 ; i += 20)
	{
	    c.drawRect (300, i, 20, 20);
	    c.drawString ("16", 302, 330);
	}


	//Animal icon
	c.setColor (Color.blue);
	c.fillOval (360, 325, 80, 40);
	c.fillArc (360, 305, 30, 40, 90, 180);
	c.fillOval (420, 305, 40, 40);
	int animalX[] = {425, 430, 442, 423};
	int animalY[] = {287, 290, 315, 325};
	int animalXY = 4;
	c.fillPolygon (animalX, animalY, animalXY);
	for (int i = 0 ; i < 5 ; i += 1)
	{
	    c.drawLine (370 + i, 350, 360 + i, 385); //leg 1
	    c.drawLine (390 + i, 355, 385 + i, 385); //leg 2
	    c.drawLine (422 + i, 350, 430 + i, 380); //leg 3
	    c.drawLine (402 + i, 350, 410 + i, 385); //leg 4
	}
	c.setColor (Color.white);
	c.fillOval (440, 315, 15, 15);
	c.setColor (Color.black);
	c.fillOval (447, 320, 8, 8);
    }


    public void cluesThree ()
    {
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 20));
	c.setColor (Color.red);
	c.drawString ("DOWN", 500, 25);
	c.drawString ("ACROSS", 500, 255);
	c.setFont (new Font ("MonoSpaced", Font.PLAIN, 11));
	c.setColor (Color.black);
	c.drawString ("1. Highly-feared", 500, 40);
	c.drawString ("   animal", 500, 55);
	c.drawString ("2. Wakes up people", 500, 70);
	c.drawString ("   early", 500, 85);
	c.drawString ("3. Goes oink oink", 500, 100);
	c.drawString ("4. Has pretty", 500, 115);
	c.drawString ("   feathers", 500, 130);
	c.drawString ("5. Fastest Animal", 500, 145);
	c.drawString ("6. Hibernates in", 500, 160);
	c.drawString ("   winter", 500, 175);
	c.drawString ("7. Eats a lot of ", 500, 190);
	c.drawString ("   grass", 500, 205);
	c.drawString ("8. Man's best friend", 500, 220);
	c.drawString ("9. Species of people", 500, 235);
	c.drawString ("10. Scrathes people", 500, 270);
	c.drawString ("11. Eaten on ", 500, 285);
	c.drawString ("    Thanksgiving", 500, 295);
	c.drawString ("12. Used to carry", 500, 310);
	c.drawString ("    letters", 500, 325);
	c.drawString ("13. Back is riden on", 500, 340);
	c.drawString ("14. Lacoste", 500, 355);
	c.drawString ("15. Found in Beaches", 500, 370);
	c.drawString ("16. King of the ", 500, 385);
	c.drawString ("    Jungle", 500, 400);
    }


    public void enterWordThree ()
    {
	//Resetting variables to zero each time method is called to allow while loop to run
	run = 0;
	total = 0;
	check = 0;
	checkTwo = 0;
	checkThree = 0;
	checkFour = 0;
	checkFive = 0;
	checkSix = 0;
	checkSeven = 0;
	checkEight = 0;
	checkNine = 0;
	checkTen = 0;
	checkEleven = 0;
	checkTwelve = 0;
	checkThirteen = 0;
	checkFourteen = 0;
	checkFifteen = 0;
	checkSixteen = 0;
	while (run != 16)
	{
	    validEntry = false;
	    c.setColor (Color.white);
	    c.fillRect (125, 425, 610, 10);
	    c.fillRect (0, 445, 650, 45);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 11));
	    c.setColor (Color.black);
	    c.drawString ("To give up or cheat, enter 'giveup' or 'cheat'", 300, 484);
	    c.drawString ("respectively when prompted 'What is your guess?:'", 300, 494);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 13));
	    c.drawString ("Enter clue #:", 20, 434);
	    while (!validEntry) //If user enters invalid input, will keep asking for valid input
	    {
		try
		{
		    c.setColor (Color.black);
		    c.setCursor (22, 17);
		    userClue = c.readString (); //Getting option from user as a String
		    intUserClue = Integer.parseInt (userClue); //Converting userMainOption to an integer
		    if (intUserClue > 0 && intUserClue < 17) //If user entered an integer, but not 1, 2, or 3
		    {
			validEntry = true;
		    }
		    if ((intUserClue == 1 && check != 1) || (intUserClue == 2 && checkTwo != 2) || (intUserClue == 3 && checkThree != 3) || (intUserClue == 4 && checkFour != 4) || (intUserClue == 5 && checkFive != 5) || (intUserClue == 6 && checkSix != 6) || (intUserClue == 7 && checkSeven != 7) || (intUserClue == 8 && checkEight != 8) || (intUserClue == 9 && checkNine != 9) || (intUserClue == 10 && checkTen != 10) || (intUserClue == 11 && checkEleven != 11) || (intUserClue == 12 && checkTwelve != 12) || (intUserClue == 13 && checkThirteen != 13) || (intUserClue == 14 && checkFourteen != 14) || (intUserClue == 15 && checkFifteen != 15) || (intUserClue == 16 && checkSixteen != 16))
		    {
			validEntry = true;
		    }
		    else //If user entered any other kind of number
		    {
			c.setColor (Color.black);
			c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
			c.drawString ("Error, you have already guessed this", 20, 457);
			c.drawString ("number or have not entered a number", 20, 467);
			c.drawString ("from 1-16. Press any key to try again.", 20, 477);
			c.getChar ();
			c.setColor (Color.white);
			c.fillRect (125, 425, 610, 10);
			c.fillRect (0, 445, 300, 85);
			validEntry = false;
		    }
		}


		catch (NumberFormatException e)  //If user entered any other kind of input
		{
		    c.setColor (Color.black);
		    c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		    c.drawString ("Error, you have not entered a number", 20, 457);
		    c.drawString ("from 1-16. Press any key to try again.", 20, 467);
		    c.getChar ();
		    c.setColor (Color.white);
		    c.fillRect (125, 425, 610, 10);
		    c.fillRect (0, 445, 300, 85);
		}
	    }
	    c.drawString ("What is your guess?:", 20, 455);
	    c.setCursor (23, 24);
	    userCrosswordGuess = c.readLine ();
	    if ((userCrosswordGuess.toLowerCase ()).equals ("giveup"))
	    {
		break;
	    }
	    if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 1)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 145, 75);
		c.drawString ("N", 145, 95);
		c.drawString ("A", 145, 115);
		c.drawString ("K", 145, 135);
		c.drawString ("E", 145, 155);
		run++;
		check = 1;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 2)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("R", 105, 155);
		c.drawString ("O", 105, 175);
		c.drawString ("O", 105, 195);
		c.drawString ("S", 105, 215);
		c.drawString ("T", 105, 235);
		c.drawString ("E", 105, 255);
		c.drawString ("R", 105, 275);
		run++;
		checkTwo = 2;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 3)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("P", 45, 175);
		c.drawString ("I", 45, 195);
		c.drawString ("G", 45, 215);
		run++;
		checkThree = 3;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 4)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("P", 145, 215);
		c.drawString ("E", 145, 235);
		c.drawString ("A", 145, 255);
		c.drawString ("C", 145, 275);
		c.drawString ("O", 145, 295);
		c.drawString ("C", 145, 315);
		c.drawString ("K", 145, 335);
		run++;
		checkFour = 4;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 5)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 245, 235);
		c.drawString ("H", 245, 255);
		c.drawString ("E", 245, 275);
		c.drawString ("E", 245, 295);
		c.drawString ("T", 245, 315);
		c.drawString ("A", 245, 335);
		c.drawString ("H", 245, 355);
		run++;
		checkFive = 5;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 6)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("B", 325, 235);
		c.drawString ("E", 325, 255);
		c.drawString ("A", 325, 275);
		c.drawString ("R", 325, 295);
		run++;
		checkSix = 6;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 7)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 285, 375);
		c.drawString ("O", 305, 375);
		c.drawString ("W", 325, 375);
		run++;
		checkSeven = 7;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 8)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("D", 185, 275);
		c.drawString ("O", 185, 295);
		c.drawString ("G", 185, 315);
		run++;
		checkEight = 8;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 9)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("H", 85, 115);
		c.drawString ("U", 105, 115);
		c.drawString ("M", 125, 115);
		c.drawString ("A", 145, 115);
		c.drawString ("N", 165, 115);
		run++;
		checkNine = 9;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 10)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 65, 235);
		c.drawString ("A", 85, 235);
		c.drawString ("T", 105, 235);
		run++;
		checkTen = 10;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 11)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("T", 65, 155);
		c.drawString ("U", 85, 155);
		c.drawString ("R", 105, 155);
		c.drawString ("K", 125, 155);
		c.drawString ("E", 145, 155);
		c.drawString ("Y", 165, 155);
		run++;
		checkEleven = 11;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 12)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("P", 25, 195);
		c.drawString ("I", 45, 195);
		c.drawString ("G", 65, 195);
		c.drawString ("E", 85, 195);
		c.drawString ("O", 105, 195);
		c.drawString ("N", 125, 195);
		run++;
		checkTwelve = 12;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 13)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("H", 245, 255);
		c.drawString ("O", 265, 255);
		c.drawString ("R", 285, 255);
		c.drawString ("S", 305, 255);
		c.drawString ("E", 325, 255);
		run++;
		checkThirteen = 13;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 14)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 85, 275);
		c.drawString ("R", 105, 275);
		c.drawString ("O", 125, 275);
		c.drawString ("C", 145, 275);
		c.drawString ("O", 165, 275);
		c.drawString ("D", 185, 275);
		c.drawString ("I", 205, 275);
		c.drawString ("L", 225, 275);
		c.drawString ("E", 245, 275);
		run++;
		checkFourteen = 14;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 15)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 205, 335);
		c.drawString ("E", 225, 335);
		c.drawString ("A", 245, 335);
		c.drawString ("G", 265, 335);
		c.drawString ("U", 285, 335);
		c.drawString ("L", 305, 335);
		c.drawString ("L", 325, 335);
		run++;
		checkFifteen = 15;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    else if ((userCrosswordGuess.toLowerCase ()).equals ("cheat") && intUserClue == 16)
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("L", 305, 335);
		c.drawString ("I", 305, 355);
		c.drawString ("O", 305, 375);
		c.drawString ("N", 305, 395);
		run++;
		checkSixteen = 16;
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("PRESS ANY KEY TO GUESS AGAIN!", 20, 475);
		c.getChar ();
	    }
	    //if user enters without cheating
	    else if (intUserClue == 1 && (userCrosswordGuess.toLowerCase ()).equals ("snake"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 145, 75);
		c.drawString ("N", 145, 95);
		c.drawString ("A", 145, 115);
		c.drawString ("K", 145, 135);
		c.drawString ("E", 145, 155);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		check = 1;
		c.getChar ();
	    }
	    else if (intUserClue == 2 && (userCrosswordGuess.toLowerCase ()).equals ("rooster"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("R", 105, 155);
		c.drawString ("O", 105, 175);
		c.drawString ("O", 105, 195);
		c.drawString ("S", 105, 215);
		c.drawString ("T", 105, 235);
		c.drawString ("E", 105, 255);
		c.drawString ("R", 105, 275);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTwo = 2;
		c.getChar ();
	    }
	    else if (intUserClue == 3 && (userCrosswordGuess.toLowerCase ()).equals ("pig"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("P", 45, 175);
		c.drawString ("I", 45, 195);
		c.drawString ("G", 45, 215);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkThree = 3;
		c.getChar ();
	    }
	    else if (intUserClue == 4 && (userCrosswordGuess.toLowerCase ()).equals ("peacock"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("P", 145, 215);
		c.drawString ("E", 145, 235);
		c.drawString ("A", 145, 255);
		c.drawString ("C", 145, 275);
		c.drawString ("O", 145, 295);
		c.drawString ("C", 145, 315);
		c.drawString ("K", 145, 335);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFour = 4;
		c.getChar ();
	    }
	    else if (intUserClue == 5 && (userCrosswordGuess.toLowerCase ()).equals ("cheetah"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 245, 235);
		c.drawString ("H", 245, 255);
		c.drawString ("E", 245, 275);
		c.drawString ("E", 245, 295);
		c.drawString ("T", 245, 315);
		c.drawString ("A", 245, 335);
		c.drawString ("H", 245, 355);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFive = 5;
		c.getChar ();
	    }
	    else if (intUserClue == 6 && (userCrosswordGuess.toLowerCase ()).equals ("bear"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("B", 325, 235);
		c.drawString ("E", 325, 255);
		c.drawString ("A", 325, 275);
		c.drawString ("R", 325, 295);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSix = 6;
		c.getChar ();
	    }
	    else if (intUserClue == 7 && (userCrosswordGuess.toLowerCase ()).equals ("cow"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 285, 375);
		c.drawString ("O", 305, 375);
		c.drawString ("W", 325, 375);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSeven = 7;
		c.getChar ();
	    }
	    else if (intUserClue == 8 && (userCrosswordGuess.toLowerCase ()).equals ("dog"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("D", 185, 275);
		c.drawString ("O", 185, 295);
		c.drawString ("G", 185, 315);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkEight = 8;
		c.getChar ();
	    }
	    else if (intUserClue == 9 && (userCrosswordGuess.toLowerCase ()).equals ("human"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("H", 85, 115);
		c.drawString ("U", 105, 115);
		c.drawString ("M", 125, 115);
		c.drawString ("A", 145, 115);
		c.drawString ("N", 165, 115);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkNine = 9;
		c.getChar ();
	    }
	    else if (intUserClue == 10 && (userCrosswordGuess.toLowerCase ()).equals ("cat"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 65, 235);
		c.drawString ("A", 85, 235);
		c.drawString ("T", 105, 235);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTen = 10;
		c.getChar ();
	    }
	    else if (intUserClue == 11 && (userCrosswordGuess.toLowerCase ()).equals ("turkey"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("T", 65, 155);
		c.drawString ("U", 85, 155);
		c.drawString ("R", 105, 155);
		c.drawString ("K", 125, 155);
		c.drawString ("E", 145, 155);
		c.drawString ("Y", 165, 155);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkEleven = 11;
		c.getChar ();
	    }
	    else if (intUserClue == 12 && (userCrosswordGuess.toLowerCase ()).equals ("pigeon"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("P", 25, 195);
		c.drawString ("I", 45, 195);
		c.drawString ("G", 65, 195);
		c.drawString ("E", 85, 195);
		c.drawString ("O", 105, 195);
		c.drawString ("N", 125, 195);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkTwelve = 12;
		c.getChar ();
	    }
	    else if (intUserClue == 13 && (userCrosswordGuess.toLowerCase ()).equals ("horse"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("H", 245, 255);
		c.drawString ("O", 265, 255);
		c.drawString ("R", 285, 255);
		c.drawString ("S", 305, 255);
		c.drawString ("E", 325, 255);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkThirteen = 13;
		c.getChar ();
	    }
	    else if (intUserClue == 14 && (userCrosswordGuess.toLowerCase ()).equals ("crocodile"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("C", 85, 275);
		c.drawString ("R", 105, 275);
		c.drawString ("O", 125, 275);
		c.drawString ("C", 145, 275);
		c.drawString ("O", 165, 275);
		c.drawString ("D", 185, 275);
		c.drawString ("I", 205, 275);
		c.drawString ("L", 225, 275);
		c.drawString ("E", 245, 275);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFourteen = 14;
		c.getChar ();
	    }
	    else if (intUserClue == 15 && (userCrosswordGuess.toLowerCase ()).equals ("seagull"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("S", 205, 335);
		c.drawString ("E", 225, 335);
		c.drawString ("A", 245, 335);
		c.drawString ("G", 265, 335);
		c.drawString ("U", 285, 335);
		c.drawString ("L", 305, 335);
		c.drawString ("L", 325, 335);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkFifteen = 15;
		c.getChar ();
	    }
	    else if (intUserClue == 16 && (userCrosswordGuess.toLowerCase ()).equals ("lion"))
	    {
		c.setColor (Color.green);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 18));
		c.drawString ("L", 305, 335);
		c.drawString ("I", 305, 355);
		c.drawString ("O", 305, 375);
		c.drawString ("N", 305, 395);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("YES! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		total++;
		run++;
		checkSixteen = 16;
		c.getChar ();
	    }
	    else
	    {
		c.setColor (Color.red);
		c.setFont (new Font ("MonoSpaced", Font.BOLD, 12));
		c.drawString ("NO! PRESS ANY KEY TO TRY AGAIN!", 20, 475);
		c.getChar ();
	    }
	}
	//Depending on if the user wanted to be timed or not, will display corresponding finish screen
	if (intUserTimerOption == 1)
	{
	    finishTimer ();
	}
	if (intUserTimerOption == 2)
	{
	    finishNoTimer ();
	}
    }



    public void finishTimer ()  //finishTimer() method
    {
	elapsedTime = System.currentTimeMillis () - startTime; //Calculates time it took user to complete crossword
	elapsedSeconds = elapsedTime / 1000; //Converts time (milliseconds) to seconds
	secondsDisplay = elapsedSeconds % 60; //Converts time (seconds) into seconds that can be understood by the user
	elapsedMinutes = elapsedSeconds / 60; //Converts time (seconds) into minutes
	minutesDisplay = elapsedMinutes % 60; //Converts time (minutes) into minutes that can be understood by the user
	intSecondsDisplay = (int) secondsDisplay; //Converts secondsDisplay to an integer
	intMinutesDisplay = (int) minutesDisplay; //Converts minutesDisplay to an integer
	c.clear (); //Clears screen
	c.setColor (Color.black);
	//Background
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}
	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 22)); //Setting font
	//Congratulating user and displaying their results
	c.drawString ("You finished the crossword puzzle!", 95, 200);
	c.drawString ("Your time is " + intMinutesDisplay + " minutes and " + intSecondsDisplay + " seconds.", 80, 230);
	c.drawString ("Your score is " + total + "/16.", 95, 260);
	c.drawString ("What is your name?: ", 95, 315);
	c.setCursor (16, 45);
	userName = c.readLine (); //Getting user's name
	name [s] = userName;
	time [s] = intMinutesDisplay + ":" + intSecondsDisplay;
	s++;
	c.drawString ("Press any key to go back to the main menu!", 55, 350);
	highscores (); //Recording their data to txt file for leaderboard by calling highscores() method
	c.getChar (); //Getting user to enter a key to return to the main menu
	mainMenu (); //Calls mainMenu() method

    }


    public void finishNoTimer ()  //finishNoTimer() method
    {
	c.clear (); //Clears screen
	c.setColor (Color.black);
	//Background
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}
	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}
	//Congratulating user and displaying their results
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 22)); //Setting font
	c.drawString ("You finished the crossword puzzle!", 95, 230);
	c.drawString ("Your score is " + total + "/16.", 95, 260);
	c.drawString ("What is your name?: ", 95, 315);
	c.setCursor (16, 45);
	userName = c.readLine (); //Getting user's name
	c.drawString ("Press any key to go back to the main menu!", 55, 350);
	c.getChar (); //Getting user to enter a key to return to the main menu
	mainMenu (); //Calls mainMenu() method
    }



    public void highscores ()
    {
	try //Accesses txt file storing scores to display them
	{
	    BufferedReader br = new BufferedReader (new FileReader ("crosswordHighscores.txt"));  //file initialization
	    int place = -1;
	    for (int i = 0 ; i < intScores.length ; i++)
	    {
		scores [i] = br.readLine ();
		intScores [i] = Integer.parseInt (scores [i]);
	    }
	    br.close ();
	    PrintWriter pw = new PrintWriter (new FileWriter ("crosswordHighscores.txt"));
	    for (int i = 0 ; i < intScores.length ; i++)
	    {
		if (intScores [i] <= total && intScores [i + 1] >= total)
		{
		    place = i;
		}
		if (intScores [12] <= total)
		{
		    place = 12;
		    break;
		}
	    }
	    for (int i = 0 ; i < intScores.length ; i++)
	    {
		if (place >= 0)
		{
		    if (i < place && place != 12)
		    {
			intScores [i] = intScores [i + 1];
		    }
		    if (i == place)
		    {
			intScores [i] = total;
		    }
		}
		scores [i] = Integer.toString (intScores [i]);
		pw.println (scores [i]);
	    }
	    pw.close ();
	    pw = new PrintWriter (new FileWriter ("crosswordHighscoresName.txt"));
	    for (int i = intScores.length - 1 ; i >= 0 ; i--)
	    {
		pw.println (name [i]);
	    }
	    pw.close ();
	    pw = new PrintWriter (new FileWriter ("crosswordHighscoresTime.txt"));
	    for (int i = intScores.length - 1 ; i >= 0 ; i--)
	    {
		pw.println (time [i]);
	    }
	    pw.close ();
	}




	catch (FileNotFoundException ex)
	{
	    System.out.println ("This file does not exist"); //your message to the user
	    System.err.println (ex.getMessage ());            //specifies the file not found
	}


	catch (IOException ex)
	{
	    System.out.println ("Problem reading file"); // your message to the user
	    System.err.println (ex.getMessage ());            //specifies the error
	}


	catch (NumberFormatException ex)
	{
	    System.out.println ("Error input"); // your message to the user
	    System.err.println (ex.getMessage ());            //specifies the error
	}
    }


    public void leaderboard ()  //leaderboard() method
    {
	c.clear ();
	String lines = "";
	int numLines = 0;
	int displayY = 110;
	int displayZ = 470;
	int displayV = 470;
	String line;
	c.setColor (Color.black);
	//Background
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}


	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}


	c.setFont (new Font ("MonoSpaced", Font.BOLD, 50));
	c.setColor (Color.red);
	c.drawString ("Leaderboard", 175, 60);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 20));
	c.setColor (Color.black);
	for (int i = 1 ; i <= 13 ; i++) //Displays rankings (numbers only)
	{
	    c.drawString ("" + i + ".", 80, displayY);
	    displayY += 30;
	}


	displayY = 470;
	try //Accesses txt file storing timed scores to display them
	{
	    BufferedReader fileRead = new BufferedReader (new FileReader ("crosswordHighscores.txt"));

	    while ((lines = fileRead.readLine ()) != null) //read the file for as long as there are  text lines in the file
	    {
		c.drawString ("" + lines, 370, displayY); //outputs read values
		displayY -= 30;
	    }
	    fileRead.close ();

	    fileRead = new BufferedReader (new FileReader ("crosswordHighscoresName.txt"));

	    while ((lines = fileRead.readLine ()) != null) //read the file for as long as there are  text lines in the file
	    {
		c.drawString ("" + lines, 130, displayZ); //outputs read values
		displayZ -= 30;
	    }
	    fileRead.close ();

	    fileRead = new BufferedReader (new FileReader ("crosswordHighscoresTime.txt"));

	    while ((lines = fileRead.readLine ()) != null) //read the file for as long as there are  text lines in the file
	    {
		c.drawString ("" + lines, 250, displayV); //outputs read values
		displayV -= 30;
	    }
	    fileRead.close ();
	}


	catch (FileNotFoundException ex)
	{
	    System.out.println ("This file does not exist"); //your message to the user
	    System.err.println (ex.getMessage ());            //specifies the file not found
	}


	catch (IOException ex)
	{
	    System.out.println ("Problem reading file"); // your message to the user
	    System.err.println (ex.getMessage ());            //specifies the error

	}


	c.drawString ("Enter any key to return to main menu.", 105, 495);
	c.getChar (); //Waiting until user enters any key
	mainMenu (); //Calls mainMenu method
    }



    public void goodbye ()  //goodbye() method
    {
	c.clear (); //Clears screen
	c.setColor (Color.black);
	//Background
	for (int i = -5 ; i < 640 ; i += 30)
	{
	    c.drawLine (0, i, 640, i);
	}


	for (int i = 30 ; i < 640 ; i += 200)
	{
	    c.fillOval (10, i, 25, 25);
	}


	//Thanks user for trying out our program
	c.setColor (Color.black);
	c.setFont (new Font ("MonoSpaced", Font.BOLD, 22)); //Setting font
	c.drawString ("Thank you for trying out our program.", 95, 230);
	c.drawString ("This program was made by: Eathan Rajendram", 55, 260);
	c.drawString ("& Ovya Saseelan", 240, 290);
	pauseProgram (); //Calls pauseProgram() method
    }


    public void pauseProgram ()  //pauseProgram() method
    {
	try
	{
	    Thread.sleep (2000); //Delays program so user can see goodbye screen
	}


	catch (Exception e)
	{
	}
    }


    public Crossword ()  //Class constructor
    {
	c = new Console ("Crosswords");
    }


    public static void main (String[] args)  //Main method of a java application
    {
	Crossword r = new Crossword (); //Creates new instance variable and constructs new object of Crossword
	r.splashscreen (); //Executes splashscreen() method
	r.intro (); //Executes intro() method
	r.mainMenu (); //Executes mainMenu() method
    }
}






