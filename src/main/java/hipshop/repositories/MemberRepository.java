package hipshop.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hipshop.models.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member,Long>{
	public abstract ArrayList<Member> findByFirstName(String firstName);
	Member findByUsername(String username);
	public abstract ArrayList<Member> findByRole(String role);
}
