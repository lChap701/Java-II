public class WorkingDog extends Dog implements Worker, Play
{
    private int hoursOfTraining;
    public void setHoursOfTraining(int hrs)
    {
        hoursOfTraining = hrs;
    }
    public int getHoursOfTraining()
    {
        return hoursOfTraining;
    }
    public void work()
    {
        //speak();      //not exactly sure what they wanted to accomplish here
        System.out.println("I am a dog who works");
        System.out.println("I have " + hoursOfTraining +
                " hours of professional training!");
    }

    public void plays(){
        System.out.println("I like to run and jump.");
    }
}
