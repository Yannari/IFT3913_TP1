package egon;
import java.util.*;
public class test {


    public static void main(String[] args) {


    
        ArrayList<ArrayList<Integer>> f=new ArrayList<>(5) ;
        for(int i=0; i < 5; i++) {
            f.add(new ArrayList());
        }
        f.get(0).add(1);
        f.get(0).add(2);
        f.get(1).add(3);
        f.get(1).add(4);
        Integer[][] ff=new Integer [4][4];
        ff[0][0]=4;
        ff[0][1]=2;
        ff[0][2]=6;
        ff[0][3]=1;
        ff[1][3]=1;
        Arrays.sort(ff[0],Collections.reverseOrder());
        for(Integer[] nums: ff)
        {
            for(Integer num: nums)
            {
                System.out.println(num);
            }
        }
        
        
    }
    
}
