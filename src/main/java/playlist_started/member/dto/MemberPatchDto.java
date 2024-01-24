package playlist_started.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import playlist_started.member.entity.Member;

@Getter
@AllArgsConstructor
public class MemberPatchDto {
    private long memberId;
    private String memberAccessId;
    private String memberEmail;
    private String memberName;
    private String memberPwd;
    private Boolean oauthMember;
    private Member.MemberState memberState;

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
}
