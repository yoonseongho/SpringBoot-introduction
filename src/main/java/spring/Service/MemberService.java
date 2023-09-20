package spring.Service;

import org.springframework.transaction.annotation.Transactional;
import spring.domain.Member;
import spring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    long start = System.currentTimeMillis();

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    try {
                        throw new IllegalAccessException("이미 존재하는 회원입니다.");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}