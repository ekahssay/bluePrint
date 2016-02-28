import java.awt.*;

/**
 * Created by endrias on 2/28/2016.
 */
public class Card {
    public String value;
    public String name;
    public Color color;
    public int index;
    public Card(String value, String name, int index ) {
        this.value = value;
        this.name = name;
        this.index = index;
    }
}
