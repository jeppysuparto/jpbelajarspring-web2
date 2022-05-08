package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JeppyTest {

    public static void main(String args[]){
        List<String> list = new ArrayList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");

        String strTest2 = "Test2";
        /*Iterator<String> listTest = list.iterator();
        while(listTest.hasNext()){
            String str = (String)listTest.next();
            if(str.equals(strTest2)){
                System.out.println("------: " + str);
                break;
            }
        }
        List<String> streamList = list.stream()          // convert list to stream
                .filter(lineJep -> strTest2.equals(lineJep) )     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List
        streamList.forEach(System.out::println);
        */
        Map<String,String> map = new HashMap<>();
        map.put("1", "Test1");
        map.put("2", "Test2");
        map.put("3", "Test3");

        /*String resu = map.entrySet().stream()
                .filter(lineJep -> strTest2.equals(lineJep.getValue()))
                .map(lineJep -> lineJep.getKey())
                .collect(Collectors.joining());
        System.out.println("--------: " + resu);
        */
        Mobil mob = new Mobil();
        mob.setRoda("4");

        String expectedRoda = "roda";
        try {
            Field field = Mobil.class.getDeclaredField(expectedRoda);
            field.setAccessible(true);
            String rd = (String)field.get(mob);
            System.out.println("--------: " + rd);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static boolean filterTest(String param, String expectedStr){
        return param.equals(expectedStr);
    }
}
