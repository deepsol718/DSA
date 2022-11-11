public class Player implements Comparable<Player> {
    private String playerName;
    private Integer noOfGoals;
    private Double average;

    public Player(String playerName, Integer noOfGoals, Double average) {
        super();
        this.playerName = playerName;
        this.noOfGoals = noOfGoals;
        this.average = average;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getNoOfGoals() {
        return noOfGoals;
    }

    public void setNoOfGoals(Integer noOfGoals) {
        this.noOfGoals = noOfGoals;
    }
    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }
    @Override
    public String toString(){
        return this.playerName;
    }
    @Override
    public int compareTo(Player o) {
        if (this.noOfGoals > o.noOfGoals) return -1;
        if (this.noOfGoals < o.noOfGoals) return 1;
        else{
            if (this.average > o.average) return -1;
            if (this.average < o.average) return 1;
            else{
                return (this.playerName.compareTo(o.playerName));
            }
        }
        //return -1;
    }
}
