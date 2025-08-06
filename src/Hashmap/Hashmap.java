package Hashmap;

import java.util.*;

public class Hashmap {
    List<Object> map;
    int size = 18279;

    public Hashmap(Object object){
        this.map = new ArrayList<>(size);
        for(int i=0;i<this.size;i++){
            this.map.add(null);
        }
        Map<String,String> newMap = new HashMap<>();
        List<String> list = new LinkedList<>();
        Queue<String> q = new PriorityQueue<>();
        list.add("123");
        list.size();
        list.get(1);
        list.set(2,"234");
    }

    public void put(String key, Object value){
        int keyHash = this.hashFunction(key);
        if(keyHash == -1){
            System.out.println("Key length not support" + key);
        }

        this.map.set(keyHash, value);
    }

    public Object get(String key){
        int keyHash = this.hashFunction(key);
        if(keyHash == -1){
            System.out.println("Not a valid key");
            return null;
        }
        return this.map.get(keyHash);
    }

    public void remove(String key){
        int keyHash = this.hashFunction(key);
        if(keyHash == -1){
            System.out.println("Not a valid key");
            return;
        }

        this.map.set(keyHash,null);
    }

    private int hashFunction(String key){
        if(key.length()>3)
            return -1;//Not supported;

       int keyHashValue = 0;
       for(int i=key.length()-1;i>=0;i--){
           int index = (key.length()-1 - i);
           keyHashValue += (int) ((key.charAt(i)-'a'+1)*Math.pow(26,index));
       }
       return keyHashValue;
    }
}
