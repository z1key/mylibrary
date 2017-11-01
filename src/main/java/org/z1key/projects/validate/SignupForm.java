package org.z1key.projects.validate;

import org.hibernate.validator.constraints.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.z1key.projects.entity.Role;
import org.z1key.projects.entity.User;

import javax.validation.constraints.Pattern;

@FieldMatch(first = "password", second = "verifyPassword", message = "Passwords are different.")
public class SignupForm {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
    private static final String EMAIL_MESSAGE = "{email.constraint}";
    private static final String PASSWORD_MESSAGE = "{password.constraint}";

    @NotBlank
    @Length(min = 5, max = 25)
    @Pattern(regexp = "^[A-Za-z\\d]+$", message = "{login.constraint}")
    private String login;

    @NotBlank(message = NOT_BLANK_MESSAGE)
    @Email(message = EMAIL_MESSAGE)
//    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{email.constraint}")
    private String email;

    @NotBlank(message = SignupForm.NOT_BLANK_MESSAGE)
    @Length(min = 6, max = 40)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]+$", message = PASSWORD_MESSAGE)
    private String password;

    private String verifyPassword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public User createAccount() {
        return new User(getLogin(), passwordEncoder.encode(getPassword()), getEmail(), Role.ROLE_USER);
    }
}
