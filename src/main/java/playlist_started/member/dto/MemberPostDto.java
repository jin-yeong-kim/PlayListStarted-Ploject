package playlist_started.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class MemberPostDto {
    @NotBlank(message = "아이디에 공백은 허용되지 않습니다.")
    private String memberAccessId;
    @NotBlank(message = "이메일을 입력해주세요")
    @Email
    private String memberEmail;
    @NotEmpty(message = "닉네임을 입력해주세요")
    private String memberName;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String memberPwd;
}
