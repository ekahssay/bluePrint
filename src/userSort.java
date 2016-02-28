import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
 * Created by endrias on 2/28/2016.
 * */


public class userSort {
    ArrayList<card> cards;
    HashMap<card,ArrayList<card>> cardComparsions;
    displayInterface display;

    public userSort(ArrayList<card> cards){
        this.cards = cards;
        this.display = display;
        cards = modfiedMergeSort(cards);
        display.display(cards);
    }

    private ArrayList<card> modfiedMergeSort(ArrayList <card> sort) {
        if(sort.size() == 0 || sort.size() ==1){
            return sort;
        }
        ArrayList<card> leftHalf = new ArrayList<card>();
        ArrayList<card> rightHalf = new ArrayList<card>();
        int leftHalfSize = sort.size()/2;
        int rightHalfSize = sort.size() - leftHalfSize;
        for(int i = 0; i< leftHalfSize; i++)
        {
            leftHalf.add(sort.get(i));
        }
        for(int i =leftHalfSize; i<sort.size(); i++){
            rightHalf.add(sort.get(i));
        }
        leftHalf = modfiedMergeSort(leftHalf);
        rightHalf = modfiedMergeSort(rightHalf);
        return combine(leftHalf,rightHalf);
    }

    private ArrayList<card> combine(ArrayList<card> leftHalf, ArrayList<card> rightHalf) {
        ArrayList<card> combined = new ArrayList<card> ();
        int i = 0;
        int j = 0;
        Random color = new Random();
        while(i < leftHalf.size() && j <rightHalf.size()){
            card leftCard = leftHalf.get(i);
            card rightCard  = rightHalf.get(j);
            int red = color.nextInt(266);
            int blue = color.nextInt(266);
            int green = color.nextInt(266);
            int compare = display.compare(leftCard.index, rightCard.index);
            Color generate = new Color(red,blue,green);
            if(compare < 0 ){
                combined.add(rightCard);
                rightCard.color = generate;
                i++;
            }
            if(compare > 0 ){
                combined.add(leftCard);
                leftCard.color = generate;
            }
            if(compare == 0){
                leftCard.color = generate;
                leftCard.color = generate;
                combined.add(leftCard);
                combined.add(rightCard);
            }
        }
    }

    private void mergeSorted(int lower, int middle, int higher) {
        for()
    }
}
