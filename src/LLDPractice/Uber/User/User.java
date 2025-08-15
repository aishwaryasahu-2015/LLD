package LLDPractice.Uber.User;

import lombok.Getter;

@Getter
public abstract class User {
    String id;
    String name;

    public User(String id, String name){
        this.id = id;
        this.name = name;
    }
}
