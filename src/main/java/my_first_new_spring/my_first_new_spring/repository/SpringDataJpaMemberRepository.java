package my_first_new_spring.my_first_new_spring.repository;

import my_first_new_spring.my_first_new_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

}
