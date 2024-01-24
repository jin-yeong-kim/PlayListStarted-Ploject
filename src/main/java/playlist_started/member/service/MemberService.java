package playlist_started.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import playlist_started.exception.BusinessLogicException;
import playlist_started.exception.ExceptionCode;
import playlist_started.member.entity.Member;
import playlist_started.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    public Member createMember(Member member) {
        verifyExistsEmail(member.getMemberEmail());

        String encryptedPassword = passwordEncoder.encode(member.getMemberPwd());
        member.setMemberPwd(encryptedPassword);

        List<String> roles = authorityUtils.createRoles(member.getMemberEmail());
        member.setRoles(roles);

        member.setOauthMember(false);

        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        Member findMember = findVerifiedMemberId(member.getMemberId());

        Optional.ofNullable(member.getMemberName())
                .ifPresent(findMember::setMemberName);

        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId) {
        return findVerifiedMemberId(memberId);
    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMemberId(memberId);

        memberRepository.delete(findMember);
    }

    private Member findVerifiedMemberId(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        return optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }

    private void verifyExistsEmail(String memberEmail) {
        Optional<Member> member = memberRepository.findByMemberEmail(memberEmail);
        if (member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

    public Member findVerifiedMemberEmail(String memberEmail) {
        Optional<Member> optionalMember = memberRepository.findByMemberEmail(memberEmail);
        return optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
    }
}

