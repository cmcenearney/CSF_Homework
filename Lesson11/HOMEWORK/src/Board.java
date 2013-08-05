import java.util.ArrayList;

public class Board {

    public boolean first_play_uses_value1;
    public ArrayList<Domino> state_of_play = new ArrayList<Domino>();
    public ArrayList<Domino> bag = new ArrayList<Domino>();

    public Board (ArrayList<Domino> bag, boolean first_play_uses_value1){
        this.first_play_uses_value1 = first_play_uses_value1;
        this.bag = bag;
    }

    public void resetBag(){
        for (Domino d : bag){
            d.Free();
        }
    }

    public  ArrayList<Domino> getFreeDominos(){
        ArrayList<Domino> freeDominos = new ArrayList<Domino>();
        for (Domino d : bag){
            if ( d.getFree() ) {
                freeDominos.add(d);
            }
        }
        return freeDominos;
    }

    public ArrayList<Domino> potentialMatches(){
        int val = state_of_play.get(state_of_play.size()-1).getFreeValue();
        ArrayList<Domino> potentialMatches = new ArrayList<Domino>();
        for (Domino d: getFreeDominos()) {
            if (d.getFree()){
                if (d.getValue1() == val || d.getValue2()==val){
                    potentialMatches.add(d);
                }
            }
        }
        return potentialMatches;
    }

    public void enactBoard(){
        resetBag();
        if (this.first_play_uses_value1){
            this.state_of_play.get(0).play(1);
        }
        else {
            this.state_of_play.get(0).play(2);
        }
        for (int i = 1; i < this.state_of_play.size()-1; i++){
            if ( !this.state_of_play.get(i-1).match(this.state_of_play.get(i)) ) {
                return;
            }
        }
    }


}
