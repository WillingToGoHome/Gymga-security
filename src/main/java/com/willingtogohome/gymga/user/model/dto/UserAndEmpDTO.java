package com.willingtogohome.gymga.user.model.dto;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserAndEmpDTO {

    private int userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String userRole;
    private String userPic;
    private String userGender;
    private Date userBirth;
    private String userAddress;
    private String userEtc;
    private int userStaff;
    private User2DTO empCategory;
}
