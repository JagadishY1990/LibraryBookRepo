package com.genpact.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
	
	@Autowired
	LibraryRepository libraryRepo;
	
	public List<Library> getAllLibrarys() {
		return (List<Library>) libraryRepo.findAll();
	}
	
	public Optional<Library> getLibraryById(String id) {
		return libraryRepo.findById(id);
	}
	
	public void addLibrary(Library Library) {
		libraryRepo.save(Library);
	}
	
	public void updateLibrary(Library Library,String id) {
		libraryRepo.save(Library);
	}
	
	public void deleteLibrary(String id) {
		libraryRepo.deleteById(id);
	}

}
