package spring.Service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.domain.Member;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTests {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {

        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원예외() {

        // given
        Member member1 = new Member();
        member1.setName("Spring");

        Member member2 = new Member();
        member2.setName("Spring");

        // when
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}