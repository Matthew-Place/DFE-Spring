package com.qa.dfe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // enables http endpoints
@CrossOrigin
public class DFEController {

	private List<Marsupial> marsupials = new ArrayList<>();

	// if spring receives a GET request at /hello
	// call vv THIS vv method
	@GetMapping("/hello")
	public String hello() {
		return "Hello, DFE!";
	}

	@GetMapping("/goodbye")
	public String bye() {
		return "So long!";
	}

	@GetMapping("/getMarsupial/{id}")
	public Marsupial getMarsupialByIndex(@PathVariable Integer id) {

		return this.marsupials.get(id);
	}

	@GetMapping("/getAllMarsupials")
	public List<Marsupial> getAllMarsupials() {

		return this.marsupials;
	}

	@PostMapping("/createMarsupial")
	public Marsupial createMarsupial(@RequestBody Marsupial marsupial) {
		System.out.println("CREATED MARSUPIAL: " + marsupial);
		this.marsupials.add(marsupial);
		return this.marsupials.get(this.marsupials.size() - 1);
	}

	@PutMapping("/updateMarsupial/{id}")
	public Marsupial updateMarsupial(@RequestBody Marsupial marsupial, @PathVariable Integer id) {
		System.out.println("UPDATED MARSUPIAL: " + marsupial);
		System.out.println("ID: " + id);
		return this.marsupials.set(id, marsupial); // replaces the marsupial at that index
	}

	@DeleteMapping("/removeMarsupial/{id}")
	public String deleteMarsupial(@PathVariable Integer id) {
		Marsupial toDelete = this.marsupials.get(id);
		this.marsupials.remove(toDelete);
		return "Deleted: " + toDelete;
	}
}
