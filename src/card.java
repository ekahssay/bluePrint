package bluePrint.src;
import java.awt.*;

/**
 * Created by endrias on 2/28/2016.
 */
public class Card {
    public String pros;
    public String cons;
    public String name;
    public Color color;
    public int index;
    public Card(String pros, String cons, String name, int index ) {
        this.name = name;
        this.pros = pros;
        this.cons = cons;
        this.index = index;
    }
}
