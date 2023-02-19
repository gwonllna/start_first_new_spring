package my_first_new_spring.my_first_new_spring.service;

import my_first_new_spring.my_first_new_spring.domain.Member;
import my_first_new_spring.my_first_new_spring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public String join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findById(member.getId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public String login(String memberId, String memberPassword) {
        Optional<Member> member = memberRepository.findById(memberId);
        if (!member.isPresent()) {
            return "login";
        } else if (!member.get().getPassword().equals(memberPassword)) {
            return "login";
        } else {
            return memberId;
        }
    }
}
