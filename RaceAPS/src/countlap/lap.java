package countlap;

public class lap {
    private String RaceName;
    private Double FirstLap;
    private Double SecondLap;
    private Double TotalTime;

    public lap(String RaceName, Double FirstLap, Double SecondLap, Double TotalTime){
        this.RaceName = RaceName;
        this.FirstLap = FirstLap;
        this.SecondLap = SecondLap;
        this.TotalTime = TotalTime;
    }
    public String getRaceName(){
        return this.RaceName;
    }
    public Double getFirstLap(){
        return this.FirstLap;
    }
    public Double getSecondLap(){
        return this.SecondLap;
    }
    public Double getTotalTime(){
        return this.TotalTime;
    }
    
}
