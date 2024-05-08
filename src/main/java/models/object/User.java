package models.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String fName;
    private String lName;
    private String address;
    private String phone;
    private String bilingAddres;
    private String deliveryAddres;
    private String title;

}
