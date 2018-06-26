import java.util.ArrayList;
import java.util.Arrays;
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length < 2){
            return;
        }
        int temp = array[0];
        for(int i = 1; i < array.length; i++){
            temp = temp^array[i];
        }

        int index = getIndex(temp);
        ArrayList<Integer> list1 = new ArrayList();
        ArrayList<Integer> list2 = new ArrayList();
        int k = 1;
        for(int i = 0; i < index; i++){
            k = k << 1;
        }
        for(int i = 0; i < array.length; i++){
            if((array[i]&k)==0){
                list1.add(array[i]);
            }else{
                list2.add(array[i]);
            }
        }

        num1[0] = list1.get(0);
        for(int i = 1; i < list1.size(); i++){
            num1[0] = num1[0]^list1.get(i);
        }
        num2[0] = list2.get(0);
        for(int i = 1; i < list2.size(); i++){
            num2[0] = num2[0]^list2.get(i);
        }
    }

    public int getDiff(ArrayList<Integer> array){
        int temp = array.get(0);
        for(int i = 1; i < array.size(); i++){
            temp = temp^array.get(i);
        }
        return temp;
    }

    public int getIndex(int a){
        int index = 0;
        while((a&1)==0){
            a = a >> 1;
            index++;
        }
        return index;
    }
}