package apple.string;

import java.util.ArrayList;
import java.util.List;

public class AppleMusicSequence {

    public static void main(String[] args) {

        String[] data = {"daniel,ShapeOfYou,1519753867",
                "daniel,Perfect,1519753868",
                "martin,ShapeOfYou,1519753869",
                "daniel,Thunder,1519753870",
                "martin,ShapeOfYou,1519753871",
                "martin,Despacito,1519753872",
                "martin,ShapeOfYou,1519753873",
                "martin,Perfect,1519753874",
                "daniel,Despacito,1519753875",
                "martin,Thunder,1519753875"};

        AppleMusicSequence a = new AppleMusicSequence();
        List<String> ans = a.findMostFrequentSequence(data);
        System.out.println(ans);
    }


    public List<String> findMostFrequentSequence(String[] data) {




        List<String> ans = new ArrayList<>(3);
        return ans;
    }
}
