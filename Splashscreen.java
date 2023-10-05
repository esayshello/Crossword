/*  Name: Eathan Rajendram and Ovya Saseelan
    Date: Jan 18 2022
    Teacher: Ms. Basaraba
    Description: Making an animated splashscreen for our game at the start
*/

import java.awt.*;
import hsa.Console;
import java.lang.*;     // to access Thread class

public class Splashscreen extends Thread
{
    private Console c;

    public void splashscreen ()
    {
	Color darkred = new Color (139, 0, 0); //local colour var. for background

	for (int x = 0 ; x < 350 ; x += 10) //loop used for animate the background
	{
	    c.setColor (darkred);
	    c.fillRect (0, 0, 0 + x, 500);
	    c.fillRect (640 - x, 0, 500, 500);
	    try    //used to delay the animation
	    {
		Thread.sleep (200);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int i = -50 ; i < 600 ; i += 30) //Text goes down
	{
	    c.setColor (darkred);
	    c.fillRect (0,0,640,500);
	    c.setColor (darkred);
	    c.setColor (Color.white);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 90)); //Setting font
	    c.drawString ("CROSSWORDS", 50, i);
	    c.drawString ("CROSSWORDS", 50, i+100);
	    c.drawString ("CROSSWORDS", 50, i+200);
	    c.drawString ("CROSSWORDS", 50, i+300);
	    c.drawString ("CROSSWORDS", 50, i+400);
	    try    //used to delay the animation
	    {
		Thread.sleep (200);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int i = -50 ; i < 700 ; i += 30) //Text goes left to right
	{
	    c.setColor (darkred);
	    c.fillRect (0,0,640,500);
	    c.setColor (darkred);
	    c.setColor (Color.white);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 70)); //Setting font
	    c.drawString ("CROSSWORDS", i, 70);
	    c.drawString ("CROSSWORDS", i, 170);
	    c.drawString ("CROSSWORDS", i, 270);
	    c.drawString ("CROSSWORDS", i, 370);
	    c.drawString ("CROSSWORDS", i, 470);
	    try    //used to delay the animation
	    {
		Thread.sleep (200);
	    }
	    catch (Exception e)
	    {
	    }
	}
	for (int i = 660 ; i > -500 ; i -= 30) //Text goes right to left
	{
	    c.setColor (darkred);
	    c.fillRect (0,0,640,500);
	    c.setColor (darkred);
	    c.setColor (Color.white);
	    c.setFont (new Font ("MonoSpaced", Font.BOLD, 70)); //Setting font
	    c.drawString ("CROSSWORDS", i, 70);
	    c.drawString ("CROSSWORDS", i, 170);
	    c.drawString ("CROSSWORDS", i, 270);
	    c.drawString ("CROSSWORDS", i, 370);
	    c.drawString ("CROSSWORDS", i, 470);
	    try    //used to delay the animation
	    {
		Thread.sleep (200);
	    }
	    catch (Exception e)
	    {
	    }
	}
    }


    public Splashscreen (Console con)
    {
	c = con;
    }


    public void run ()
    {
	splashscreen ();
    }
}



