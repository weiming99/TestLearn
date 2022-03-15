package test;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author chen
 * @crete 2021-08-26-21:24
 */
public class TestHashMap {

    public static void main(String[] args) {
        lamdaTest();
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(new Integer(-1));
//        integers.add(new Integer(0));
//        integers.add(new Integer(1));
//        System.out.println("JSON.toJSONString(streamTest(integers)) = " + JSON.toJSONString(streamTest(integers)));
//        System.out.println("findMaxChar(\"aaabbbcccccc\") = " + findMaxChar("aaabbbcccccc"));
//        System.out.println(JSON.toJSONString(getIntegerSection(new String[]{"a", "b", "c", "d"}, new String[]{"c", "e", "d"})));
    }


    public static void lamdaTest(){
        LinkedList<String> strings = new LinkedList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        Consumer<List> printList = TestHashMap::printList;
        printList.accept(strings);
    }
    public static  void  printList(List list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static List<Long> streamTest(List<Integer> integers){
        //第一种
        ArrayList<Long> longs = new ArrayList<>();
        integers.stream().filter(u->u!=null?u.intValue()>0:false).forEach(u->longs.add(new Long(u.intValue())));
        //第二中
        List<Long> collect = integers.stream().filter(u -> u != null ? u.intValue() >= 0 : false).map(u -> new Long(u)).collect(Collectors.toList());
        return longs;
    }

    public static char findMaxChar(String str){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            Integer integer = hashMap.get(c);
            hashMap.put(c,integer==null?new Integer(1):integer+1);
        }
        return hashMap.keySet().stream().max(Comparator.comparing(hashMap::get)).get();
    }

    public static String[] getIntegerSection(String[] s1,String[] s2){
        ArrayList<String> strings = new ArrayList<>();
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        for (String s : s1) {
            stringStringHashMap.put(s,null);
        }
        for (String s : s2) {
            if (stringStringHashMap.containsKey(s)) {
                strings.add(s);
            }
        }
        return strings.toArray(new String[0]);
    }

}
