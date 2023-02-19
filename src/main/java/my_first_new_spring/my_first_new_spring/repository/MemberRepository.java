package my_first_new_spring.my_first_new_spring.repository;

import my_first_new_spring.my_first_new_spring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(String id);
}
