package com.example.demo.notes.test;

/**
 * Created by zhangkai on 2018/9/20.
 */

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。**/
public class Test02 {


    public static void main(String[] args) {

        int result = reverse(1534236469);

    }


    public static int reverse(int x) {
        final Integer max =1024*1024*1024*2-1;
        final Integer min = -1024*1024*1024*2;
        int result = 0;
        String [] strArray = String.valueOf(x).split("");
        String newString = "";
        for(int i= strArray.length-1; i>0; i--){
            if(i ==strArray.length-1){
                if(strArray[i].equals("0")){
                    continue;
                }else{
                    newString +=strArray[i];
                }
            }else{
                newString +=strArray[i];
            }
        }

        String index0 = strArray[0];
        try {
            if("-".equals(index0)){
                result = 0-Integer.parseInt(newString);
            }else{
                result = Integer.parseInt(newString+index0);
            }
        }catch (Exception e){
            System.out.println(newString);
            return 0;
        }


        if(result>min && result<max){
            return result;
        }

        return 0;
    }

}
