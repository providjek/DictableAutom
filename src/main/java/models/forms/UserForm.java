package models.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.FormAbstract;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm extends FormAbstract {
    private String fName;
    private String lName;
    private String address;
    private String phone;
    private String bilingAddres;
    private String deliveryAddres;
    private String title;

}
