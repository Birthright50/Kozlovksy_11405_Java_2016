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

    @Override
    public void runEngine() {
        System.out.println("engine is on");
    }

    @Override
    public void stopEngine() {
        System.out.println("engine is off");
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
