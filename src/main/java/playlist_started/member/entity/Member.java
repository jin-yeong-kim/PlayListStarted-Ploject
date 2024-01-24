package playlist_started.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import playlist_started.audit.Auditable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 25, nullable = false, unique = true)
    private String memberAccessId;

    @Column(length = 25, nullable = false, unique = true)
    private String memberEmail;

    @Column(length = 16, nullable = false, unique = true)
    private String memberName;

    @Column(length = 100, nullable = false)
    private String memberPwd;

    @Enumerated(EnumType.STRING)
    private MemberState memberState = MemberState.ACTIVE;

    @Column
    private String refreshToken;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Column
    private Boolean oauthMember;

    public enum MemberState {
        ACTIVE("일반 상태"),
        UNACTIVE("휴면 상태");

        @Getter
        private String state;

        MemberState(String state) {this.state = state;}
    }

}
