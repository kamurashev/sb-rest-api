package org.zapto.trywithfun.sbrestapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.zapto.trywithfun.sbrestapi.entity.auditing.Auditable;
import org.zapto.trywithfun.sbrestapi.entity.validation.Age;
import org.zapto.trywithfun.sbrestapi.entity.validation.UniqueEmail;
import org.zapto.trywithfun.sbrestapi.entity.validation.UniqueLogin;
import org.zapto.trywithfun.sbrestapi.entity.validation.groups.Create;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint (name = "LOGIN_UNIQUE", columnNames = "login"),
                                            @UniqueConstraint (name = "EMAIL_UNIQUE", columnNames = "email")})
public class ApplicationUser extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotNull(groups = Create.class)
    @Length(min = 3, max = 30)
    @UniqueLogin(groups = Create.class)
    private String login;

    @NotNull(groups = Create.class)
    @Length(min = 8, max = 255)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull(groups = Create.class)
    @Email
    @UniqueEmail
    private String email;

    private String firstName;

    private String lastName;

    @Age(min = 16, max = 120)
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Role role;
}
