import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.NoSuchElementException;

public class Scheduler
{

    public static ArrayList<Talk> makeTalks(String file)
    throws IOException
    {
    ArrayList<Talk> talks = new ArrayList<Talk>();
    File inFile = new File(file);
    Scanner input = new Scanner(inFile);
    
    try
    {
    while (input.hasNextLine())
    {
    String name = input.next(); 
    String start = input.next();
    int startTime = Integer.parseInt(start); 
    String end = input.next(); 
    int endTime = Integer.parseInt(end); 
    

    if (endTime < startTime || endTime > 2359 || startTime > 2359
    || startTime % 100 > 59 || endTime % 100 > 59)
    {
    System.out.println("Sorry, there was an error of an invalid time.");
    }
    else
    {
    Talk oneTalk = new Talk(startTime, endTime, name);
    talks.add(oneTalk);
    }
    }
    }
    
    catch (NumberFormatException nf)
    {
    System.out.println("Sorry, your times are not formatted correctly.");
    talks = new ArrayList<Talk>();
    return talks;
    }
    catch (NoSuchElementException ns)
    {
    System.out.println("Sorry, there was an issue when calling an element");
    talks = new ArrayList<Talk>();
    return talks;
    }
    finally
    {
    input.close();
    return talks;
    }
    }
    

    public static ArrayList<Talk> scheduleTalks(ArrayList<Talk> talks)
    {

    Collections.sort(talks);
    
    ArrayList<Talk> scheduled = new ArrayList<Talk>();
    int index = 0;
    if (talks.size() > 0)
    {
    scheduled.add(talks.get(0)); 
    
    for (int i = 1; i < talks.size(); i++)
    {
    Talk current = talks.get(i);
    Talk compare = scheduled.get(index);
    

    if (compare.getEndTime() <= current.getStartTime())
    {
    scheduled.add(current);
    index++;
    }
    }
    }
    
    return scheduled;   
    }
    
}