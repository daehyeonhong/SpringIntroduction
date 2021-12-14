package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
}
