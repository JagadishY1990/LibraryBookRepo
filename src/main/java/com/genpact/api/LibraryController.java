package com.genpact.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LibraryController {
	
	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/library")
	public List<Library> getAllLibrarys() {
		return libraryService.getAllLibrarys();
	}
	
	@GetMapping("/library/{id}")
	public Optional<Library> getLibraryById(@PathVariable String id) {
		return libraryService.getLibraryById(id);
	}
	
	@PostMapping("/addLibrary")
	public void addLibrary(@RequestBody Library Library) {
		libraryService.addLibrary(Library);
	}
	
	@PutMapping("/updateLibrary/{id}")
	public void updateLibrary(@RequestBody Library Library,@PathVariable String id) {
		libraryService.updateLibrary(Library, id);
	}
	
	@DeleteMapping("/deleteLibrary/{id}")
	public void deleteLibrary(@PathVariable String id) {
		libraryService.deleteLibrary(id);
	}
	
	@RequestMapping(value="/retrieveAndaddLibrarys", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Library> retrieveAndaddLibrarys(@RequestBody Library Library) {
		libraryService.addLibrary(Library);
		return getAllLibrarys();
	}
	
	@RequestMapping(value="/retrieveAndupdateLibrarys", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Library> retrieveAndupdateLibrarys(@RequestBody Library Library) {
		libraryService.updateLibrary(Library, Library.getId());
		return getAllLibrarys();
	}
	
	@RequestMapping(value="/retrieveAnddeleteLibrary", method= {RequestMethod.GET,RequestMethod.POST})
	public List<Library> retrieveAnddeleteLibrary(@RequestParam String id) {
		libraryService.deleteLibrary(id);
		return getAllLibrarys();
	}

}
