package Hashmap;

public class Main {

    public static void main(String[] args){
        Hashmap hashmap = new Hashmap(new Object());
        hashmap.put("abc",123);
        hashmap.put("abc",3);
        System.out.println("value of abc " + hashmap.get("abc"));
        hashmap.remove("abc");
        System.out.println("value of abc " + hashmap.get("abc"));
        System.out.println("value of cde " + hashmap.get("cde"));

        hashmap.put("a",123);
        hashmap.put("z",4);
        hashmap.put("aa",5);
        System.out.println("value of zzz " + hashmap.get("zzz"));
        hashmap.put("zzz",16);
        System.out.println("value of zzz " + hashmap.get("zzz"));
    }
}
