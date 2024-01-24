package playlist_started.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import playlist_started.member.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberEmail(String email);

    Member findByMemberId(Long memberId);
}
