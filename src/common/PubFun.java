package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PubFun {

    public static List randomList(List<String> pDataList){
        System.out.println("前：");
        for(int i=0;i<pDataList.size();i++){
            System.out.print(pDataList.get(i)+" | ");
        }
        System.out.println("");
        System.out.println("后：");
        Collections.shuffle(pDataList);
        for(int i=0;i<pDataList.size();i++) {
            System.out.print(pDataList.get(i) + " | ");
        }
        return pDataList;
    }
}
