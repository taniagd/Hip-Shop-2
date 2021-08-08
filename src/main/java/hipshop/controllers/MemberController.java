package hipshop.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hipshop.models.Member;
import hipshop.services.MemberService;


@RestController
@RequestMapping("/user")
public class MemberController {

	/*
	 * Dependency injection by constructor
	 */
	
	private MemberService memberService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public MemberController(MemberService memberService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.memberService = memberService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	/*
	 * Method to get the list of all users available
	 * This list is restricted just to ADMIN role 
	 * getUsers()
	 */
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ADMIN')")
	public ArrayList<Member> getAllMembers(){
		return memberService.getMembers();
	}
	
	/*
	 * Method to get all vendors available 
	 */
	@GetMapping
	public ArrayList<Member> getVendors(){
		return memberService.getVendors();
	}
	
	/*
	 * Method for saving new members, by default all of them will have
	 *  the role of USER by default and will hashed the password automatically
	 *  saveUser(Member member)
	 */
	
	@PostMapping
	public Member saveUser(@RequestBody Member member) {
		member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
		return memberService.saveUser(member);
	}
	
	/*
	 * Finds members by id
	 * getUserById(Long id)
	 */
	@GetMapping(path = "/{id}")
	public Optional<Member> getUserById(@PathVariable("id") Long id){
		return memberService.getUserById(id);
	}
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable("id")Long id) {
		boolean ok = memberService.deleteUser(id);
		if(ok) {
			return "Se eliminó el usuario";
		}else {
			return "No se pudo eliminar el usuario";
		}
	}
	
	@GetMapping("/query")
	public ArrayList<Member> getUsersByName(@RequestParam(value = "name", defaultValue="")String name){
		return memberService.getUserByName(name); 
	}
	
}
