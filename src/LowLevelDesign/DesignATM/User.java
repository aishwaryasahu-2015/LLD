package LowLevelDesign.DesignATM;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    Card card;
    UserBankAccount bankAccount;
}
