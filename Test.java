import java.util.ArrayList;
import java.io.*;

public class Test{

public static void main(String[] args)
{

    //Use a command line argument to call talks.txt file


    if (args.length>0)
    {
    try
    {
    ArrayList<Talk> talks = Scheduler.makeTalks(args[0]); 


    ArrayList<Talk> scheduledTalks=Scheduler.scheduleTalks(talks);


    for (Talk talk:scheduledTalks){
    System.out.println(talk);
    }
    }   
    catch(IOException e)
    {   
    System.out.println("There is a problem with the file you specified");
    }

    }
    else
    {
    System.out.println("You must specify a file name at the command line");
    }
    }

}