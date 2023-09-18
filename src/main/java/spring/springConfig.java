package spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.Service.MemberService;
import spring.repository.MemberRepository;
import spring.repository.MemoryMemberRepository;

@Configuration
public class springConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}