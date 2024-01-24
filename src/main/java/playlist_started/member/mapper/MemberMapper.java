package playlist_started.member.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import playlist_started.member.dto.MemberPatchDto;
import playlist_started.member.dto.MemberPostDto;
import playlist_started.member.dto.MemberResponseDto;
import playlist_started.member.entity.Member;

@Mapper(componentModel = "string", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
}
