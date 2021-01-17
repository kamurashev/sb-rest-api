package org.zapto.trywithfun.sbrestapi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class ApplicationUserDVO implements Serializable {

    @ApiModelProperty(example = "user")
    String login;

    @ApiModelProperty(example = "user@somehost.some")
    String email;

    @ApiModelProperty(example = "user")
    String firstName;

    @ApiModelProperty(example = "poor")
    String lastName;

    LocalDate birthday;

    Role role;

    LocalDateTime lastModified;

    @ApiModelProperty(example = "some_username")
    String lastModifiedBy;

    LocalDateTime created;

    @ApiModelProperty(example = "some_admin_username")
    String createdBy;
}