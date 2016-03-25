package our_classes;

/**
 * Created by Peter on 08.02.2016.
 */
public class SomeEngine implements Engine {
    int hp;
    int torque;
    boolean boost;

    public SomeEngine(int hp, int torque, boolean boost) {
        this.hp = hp;
        this.torque = torque;
        this.boost = boost;
    }

    public int getHp() {
        return hp;
    }

    public int getTorque() {
        return torque;
    }

    private String current_act;

    public String getCurrent_act() {
        return current_act;
    }

    @Override

    public void runEngine() {
        current_act = "engine is on";
        System.out.println(current_act);
    }

    @Override
    public void stopEngine() {
        current_act = "engine is off";
        System.out.println(current_act);
    }

    @Override
    public void boost(boolean on) {
       if(boost){
           if(!on){
               hp *= 0.7;
               torque *= 0.8;
           }
       }
        else{
           if(on){
               hp /=0.7;
               torque /=0.8;
           }
       }
    }
}
