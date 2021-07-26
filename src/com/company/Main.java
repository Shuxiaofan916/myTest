package com.company;

import com.sun.deploy.util.StringUtils;
import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    // 别跑  堆内存溢出警告
//    private void doNotStop(){
//        while(true){
//
//        }
//    }
//
//    public void createThread(){
//        while(true){
//            Thread thread = new Thread(()->
//                 doNotStop();
//            });
//        }
//
//    }
    static class Student{
        Integer age;
        String name;

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Student(Integer age, String name) {
            this.age = age;
            this.name = name;

        }
    }
    static void newStudent(Student a3){
        //a3.setAge(24);
        //a3.setName("浩二");

        a3=new Student(24,"浩二");
        System.out.println(a3.toString());
    }

    public static void main(String[] args) {
        String s;
        System.out.println("s="+s);
    }

    //时间操作
    private static void extracted() throws InterruptedException, ParseException {
        Date date = new Date();
        //System.out.println(date.toString());
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //String data = simpleDateFormat.format(date);
        //System.out.println(data.toString());
        //SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd mm:hh");
        //String format = simpleDateFormat1.format(date);
        //Date parse = simpleDateFormat1.parse(format);
        //System.out.println(format.toString());
        //System.out.println(parse.toString());
        long time = date.getTime();
        System.out.println(time);
        Thread.sleep(1000);
        Date date1 = new Date();
        long time1 = date1.getTime();
        System.out.println(time1);
        long time2=time1-time;
        System.out.println(time2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        String format = simpleDateFormat.format(time2);
        Date parse = simpleDateFormat.parse(format);
        System.out.println(parse);
    }

    public static int[] twoSum(int[] numbers, int target) {
        //暴力破解 适合无序状态时候的时候进行查询
        //for(int i=0;i<numbers.length;i++){
        //    for(int j=i+1;j<numbers.length;j++){
        //        if((numbers[i]+numbers[j])==target){
        //            int[] a={i,j};
        //            return a;
        //        }
        //    }
        //}

        //如果知道是有序的 可以使用二分查找法
        int num;
        int left=1;
        int right=numbers.length-1;
        int mid=numbers.length/2;
        for(int i=0;i<numbers.length;i++){
            num=target-numbers[i];
            while(mid>left){
                if (numbers[mid]<num){
                    left=mid;
                    mid=(mid+right)/2;
                }else if(numbers[mid]>num){
                    right=mid;
                    mid=(mid+left)/2;
                }else {
                    int[] a={++i,++mid};
                    return a;
                }
            }
        }
        return null;

    }

    public static int removeDuplicates(int[] nums) {
        int index=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[index-2]){
                nums[index++]=nums[i];
            }
        }
        return index;
    }

    public static void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                nums[nums.length-1]=0;
                i--;
            }
        }
        System.out.println(nums);
    }

    public int hIndex(int[] citations) {
        if (citations.length == 0){
            return 0;
        }

        return 1;

    }

    public int majorityElement(int[] nums) {
        if(nums.length<2){
            return -1;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1;i<nums.length;i++){
         //   arrayList.add(a);

        }
        return 1;

    }
}
