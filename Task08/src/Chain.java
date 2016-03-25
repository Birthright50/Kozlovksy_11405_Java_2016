import java.util.ArrayList;

/**
 * Created by Birthright on 29.11.2015.
 */
public class Chain {

    private ArrayList<Stone> stones;

    public StoneColor getState() {
        return state;
    }

    public void setState(StoneColor state) {
        this.state = state;
    }

    public ArrayList<Stone> getStones() {
        return stones;
    }

    public void setStones(ArrayList<Stone> stones) {
        this.stones = stones;
    }

    private StoneColor state;

    public Chain() {
        stones = new ArrayList<>();
    }

    public boolean getLiberties() {
        for (Stone stone : stones) {
            if (stone.getLiberties() > 0) {
                return true;
            }
        }
        return false;
    }

    public void addStone(Stone stone) {
        stone.setChain(this);
        stones.add(stone);
    }

    public void join(Chain chain) {
        int size = chain.stones.size();
        for (int i = 0; i < size; i++) {
            addStone(chain.stones.get(i));
        }

    }

}
