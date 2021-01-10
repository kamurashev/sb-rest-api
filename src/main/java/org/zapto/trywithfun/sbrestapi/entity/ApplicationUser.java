package org.zapto.trywithfun.sbrestapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.zapto.trywithfun.sbrestapi.entity.auditing.Auditable;
import org.zapto.trywithfun.sbrestapi.entity.validation.Age;
import org.zapto.trywithfun.sbrestapi.entity.validation.UniqueEmail;
import org.zapto.trywithfun.sbrestapi.entity.validation.UniqueLogin;
import org.zapto.trywithfun.sbrestapi.entity.validation.groups.Create;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ApiModel
@Table(name = "users", uniqueConstraints = {@UniqueConstraint (name = "LOGIN_UNIQUE", columnNames = "login"),
                                            @UniqueConstraint (name = "EMAIL_UNIQUE", columnNames = "email")})
public class ApplicationUser extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull(groups = Create.class)
    @Size(min = 3, max = 30)
    @UniqueLogin(groups = Create.class)
    @ApiModelProperty(
            example = "alexunique",
            notes = "Skipped during update",
            required = true)
    private String login;

    @NotNull(groups = Create.class)
    @Size(min = 8, max = 255)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(
            example = "alexunique123$",
            notes = "Not required for update",
            required = true)
    private String password;

    @NotNull(groups = Create.class)
    @Email
    @UniqueEmail
    @ApiModelProperty(
            example = "foo.bar@somehost.some",
            notes = "Must be well formed, unique email, not required for update",
            required = true)
    private String email;

    @ApiModelProperty(example = "alex")
    private String firstName;

    @ApiModelProperty(example = "alexon")
    private String lastName;

    @Age(min = 16, max = 120)
    @ApiModelProperty(example = "1999-12-31", notes = "Must be from 16 to 120 years old")
    private LocalDate birthday;

    @NotNull(groups = Create.class)
    @Enumerated(EnumType.STRING)
    private Role role;
}
