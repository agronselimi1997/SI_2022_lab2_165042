import java.util.ArrayList;
import java.util.List;

public class SILab2 {

    public static List<String> function(List<String> list) {
        if (list.size() <= 0) { //1
            throw new IllegalArgumentException("List length should be greater than 0");//2
        }
        int n = list.size();
        int rootOfN = (int) Math.sqrt(n);
        if (rootOfN * rootOfN  != n) {//3
            throw new IllegalArgumentException("List length should be a perfect square");//4
        }
        List<String> numMines = new ArrayList<>();
        for (int i = 0;//5.1
             i < n;//5.2
             i++//5.3
        )
        {
            if (!list.get(i).equals("#")) {//6
                int num = 0;
                if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) )

                {//7
                    if ( (i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#")) )
                    {//8
                        num += 2;//9
                    }
                    else {//10
                        num  += 1;//11
                    }
                }
                if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")){//12
                    num++;//13
                }
                if (i + rootOfN < n && list.get(i + rootOfN).equals("#")){//14
                    num++;//15
                }
                numMines.add(String.valueOf(num));//16
            }
            else {//17
                numMines.add(list.get(i));//18
            }
        }
        return numMines;//19
    }//20
}
