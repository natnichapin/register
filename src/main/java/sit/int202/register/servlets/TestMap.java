package sit.int202.register.servlets;

import java.util.*;

public class TestMap {
    public static  void main(String[] args){
        Map<Integer, List<String>> map = new HashMap(32,0.5f);
        //เก็บเป็น Object เท่านั้น ซึ่งเป็น object อะไรก็ได้ ต่อให้เป็น primitive ก็จะแปลงเป็น object เอง เช่น 9 แปลงเป็น Integer เอง
        //ตัวแปรเดี่ยว อยู่ที่ String[0] เสมอ
        List<String> a1 = new ArrayList<>(); //<> generic
        a1.add("INT101");//add
        a1.add("INT102");
        a1.add("INT103");
        map.put(1,a1); //เอาข้อมูลไปเก็บ โดยใช้ hash table
        a1 = new ArrayList<>(); //สร้างใหม่
        a1.add("INT201");
        a1.add("INT202");
        a1.add("INT203");
        map.put(2,a1);

        a1 = new ArrayList<>();
        a1.add("INT901");
        a1.add("INT902");
        a1.add("INT903");
        map.put(9,a1);
                // () : define capacity otherwise it used 16
                //ได้แค่ 2^ ใส่ 50 จะจองให้ 64
                //เก็บเป็น list ที่มี String

       List<String> tmp =  map.get(9);
        System.out.println(tmp);
        a1.forEach(x-> System.out.println("Subject is "+x)); //list can be used for-each
        map.values(); // array value
        map.keySet();//array key
        map.entrySet();
        Set<Map.Entry<Integer,List<String>>> entries = map.entrySet();
        //Entry is inner class in Map class
        for(Map.Entry<Integer,List<String>> e : entries) {
            //System.out.println("Key : "+ e.getKey()+", Value : "+e.getValue());
            System.out.println("Semester"+e.getKey());
            e.getValue().forEach(v-> System.out.println("\t"+v));

        }
    }
}