package org.zapto.trywithfun.sbrestapi.entity;

import lombok.Value;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class ApplicationUserDVO {
    String login;
    String email;
    String firstName;
    String lastName;
    LocalDate birthday;
    Role role;
    LocalDateTime lastModified;
    String lastModifiedBy;
    LocalDateTime created;
    String createdBy;
}