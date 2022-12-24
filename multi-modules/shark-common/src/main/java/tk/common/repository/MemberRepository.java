package tk.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.common.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
