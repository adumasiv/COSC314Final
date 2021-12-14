public class Talk implements Comparable<Talk>
{
int startTime;
int endTime;
String person;

public Talk(int start, int end, String name) 
{
    startTime = start;
    endTime = end;
    person = name;
}
  

public int compareTo(Talk other)
{
    if (this.endTime > other.endTime)
{
    return 1; 
}
else if (this.endTime < other.endTime) 
{
    return -1; 
}
else
{
    return 0; 
}
}
  

public String toString()
{

    String startTime2 = Integer.toString(startTime);
    String endTime2 = Integer.toString(endTime);
    
    while (startTime2.length() < 4)
    {
        String tmp = "0" + startTime2;
        startTime2 = tmp;
    }
    
    while (endTime2.length() < 4)
    {
        String tmp = "0" + endTime2;
        endTime2 = tmp;
    }
    
    String title = person + " is from " + startTime2 + " to " + endTime2;
    return title;
}
  

public int getStartTime()
{
    return startTime;
}
  

public int getEndTime()
{
    return endTime;
}

}