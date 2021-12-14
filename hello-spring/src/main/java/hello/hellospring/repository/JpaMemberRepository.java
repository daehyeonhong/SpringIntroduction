package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager entityManager;

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) throws SQLException {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Member.class, id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return entityManager
                .createQuery("SELECT M FROM Member M WHERE M.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList()
                .stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return entityManager.createQuery("SELECT M FROM Member M", Member.class).getResultList();
    }

}
