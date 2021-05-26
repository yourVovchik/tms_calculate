package by.project.spring.calculate.model.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    @NotNull
    @NotBlank
    private String login;
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;

}
