import java.util.ArrayList;

public class TurnDriver{
    public static void main(String[] args){

        ArrayList<Turnable> turnable_things = new ArrayList<Turnable>();

        Turnable p  = new Pancake(60);
        Turnable b  = new Book(250);
        Turnable l  = new Leaf(4);
        Turnable pc = new PlayingCard(false);
        Turnable b2 = new Book(12);
        Turnable s  = new Switch(false);

        turnable_things.add(p);
        turnable_things.add(b);
        turnable_things.add(l);
        turnable_things.add(pc);
        turnable_things.add(b2);
        turnable_things.add(s);

        for(Turnable t : turnable_things){
            System.out.println(t);
            t.turn();
            System.out.println(t);
        }
    }
}

