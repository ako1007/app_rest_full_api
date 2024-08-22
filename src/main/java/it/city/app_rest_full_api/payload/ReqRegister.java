package it.city.app_rest_full_api.payload;

import com.sun.istack.internal.NotNull;
import it.city.app_rest_full_api.entity.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReqRegister {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
    @NotNull
    private Gender gender;
}
