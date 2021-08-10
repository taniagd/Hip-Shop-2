package hipshop.services;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import hipshop.models.Card;
import hipshop.models.HipHopBranch;
import hipshop.models.Member;
import hipshop.repositories.MemberRepository;



@Service
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberRepository memberRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.memberRepository = memberRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	/*
	 * Gets all the members available
	 *  getMembers()
	 */
	
	public ArrayList<Member> getMembers(){
		return (ArrayList<Member>) memberRepository.findAll();
	}
	
	/*
	 * Save user and checks in the DB if the username is already 
	 *  taken
	 *  saveUser(Member user) 
	 */
	public Member saveUser(Member user) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String address = user.getAddress();
		String email = user.getEmail();
		String password = user.getPassword();
		String phoneNumber = user.getPhoneNumber();
		String username = user.getUsername();
		String role = user.getRole();
		
		Member usernameAvaliability = memberRepository.findByUsername(username);
		
		if(usernameAvaliability != null && usernameAvaliability.getUsername().contentEquals(username)) {
			return user;
		}else if(username != null && password != null) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			return memberRepository.save(user);
		}else {			
			return user;
		}
	}
	
	/*
	 * Finds all members based in the field 'role'
	 */
	public ArrayList<Member> getUsersByRole(String role){
		return  memberRepository.findByRole(role);
	}
	
	/*
	 * Finds a Member by id
	 * getUserById(Long id)
	 */
	public Optional<Member> getUserById(Long id) {
		return memberRepository.findById(id);
	}
	
	/*
	 * Deletes a Member by id
	 * deleteUser(Long id) 
	 */
	public boolean deleteUser(Long id) {
		try {
			memberRepository.deleteById(id);
			return true;
		}catch(Exception error){
			return false;
		}
	}
	
	/*
	 * Get all vendors
	 * getVendors()
	 */
	public ArrayList<Member> getVendors() {
		return memberRepository.findByRole("VENDOR");
	}
	
	/*
	 * Finds members by first name
	 * getUserByName(String firstName)
	 */
	public ArrayList<Member> getUserByName(String firstName){
		return memberRepository.findByFirstName(firstName);
	}
	
	/*
	 * 
	 */
	public ArrayList<Member> getVendorsByBranch(String name){
		HipHopBranch hipHopBranch = null;
		if(name.contentEquals("RapFreestyle")) {
			hipHopBranch = HipHopBranch.RapFreestyle;
		}else if(name.contentEquals("Breaking")){
			hipHopBranch = HipHopBranch.Breaking;
		}else if(name.contentEquals("DjBeatmakers")) {
			hipHopBranch = HipHopBranch.DJBeatmaker;
		}else if(name.contentEquals("Graffiti")) {
			hipHopBranch = HipHopBranch.Graffiti;
		}else {
			return getVendors();
		}
		
		
		return memberRepository.findByBranch(hipHopBranch);
	}
	
	/*
	 * Requirements for loading JWT  
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByUsername(username);
		if (member == null) {
			throw new UsernameNotFoundException(username);
		}
		if(member.getRole() == null) {
			member.setRole("USER");
		}
		return new org.springframework.security.core.userdetails.User(member.getUsername(),
				member.getPassword(), getAuthorities(member.getRole()));
	}
    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }
}
