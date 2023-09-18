package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.Service.MemberService;
import spring.repository.JdbcMemberRepository;
import spring.repository.JdbcTemplateMemberRepository;
import spring.repository.MemberRepository;
import spring.repository.MemoryMemberRepository;

import javax.sql.DataSource;

@Configuration
public class springConfig {

    private DataSource dataSource;

    public springConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}