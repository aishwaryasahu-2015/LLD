package CodeSignalPractice;

import java.util.*;


class IntegerContainerImpl implements IntegerContainer {
    HashMap<Integer,Integer> container;
    int totalCount;
    public IntegerContainerImpl() {
        this.container = new HashMap<>();
        this.totalCount = 0;
    }

    public int add(int value) {
        int count = this.container.getOrDefault(value, 0);
        this.container.put(value,count++);
        this.totalCount++;
        return this.totalCount;
    }

    public boolean delete(int value) {
        if(!this.container.containsKey(value))
            return false;
        int count = this.container.get(value);
        count--;
        if(count==0)
            this.container.remove(value);
        else
            this.container.put(value,count);
        this.totalCount--;
        return true;
    }

    // TODO: implement interface methods here
}

