//package com.me.kije.promptproject.form;
//
//
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Size;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class UserCreateForm {
//
//    @Size(min = 5, max = 20)
//    @NotEmpty(message = "ID는 필수 항목입니다.")
//    private String userName;
//
//    @Size(min = 5, max = 20)
//    @NotEmpty(message = "닉네임은 필수 항목입니다.")
//    private String nickName;
//
//    @NotEmpty(message = "비밀번호를 입력하세요")
//    private String password1;
//
//    @NotEmpty(message = "비밀번호를 확인하세요")
//    private String password2;
//
//    @NotEmpty(message = "Email은 필수 항목입니다.")
//    @Email
//    private String email;
//
//}
