package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     * 회원 저장
     * @param member
     * @return : {@link Long}
     */
    public Long join(Member member) throws SQLException {
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    /**
     * 전체 회원 조회
     * @return : {@link Member}
     */
    public List<Member> findMembers() {
        return repository.findAll();
    }

    /**
     * 회원 조회
     * @param memberId
     * @return : {@link Member}
     */
    public Optional<Member> findOne(Long memberId) {
        return repository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

}
