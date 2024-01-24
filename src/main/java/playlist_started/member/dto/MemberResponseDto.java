package playlist_started.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import playlist_started.member.entity.Member;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {
    private Long memberId;
    private String memberAccessId;
    private String memberEmail;
    private String memberName;
    private Boolean oauthMember;
    private Member.MemberState memberState;
}
