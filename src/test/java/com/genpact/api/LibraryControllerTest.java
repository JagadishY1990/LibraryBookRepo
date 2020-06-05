package com.genpact.api;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class LibraryControllerTest {

	@InjectMocks
	LibraryService libraryService = new LibraryService();
	
	@Test
	void testGetAllLibrarys() {
		List<Library> lib = loadLibrary();
		when(libraryService.getAllLibrarys()).thenReturn(lib);
		assertTrue(!lib.isEmpty());
	}
	
	private List<Library> loadLibrary(){
		List<Library> lib = new ArrayList<>();
		
		Library library = new Library();
		library.setId("1");
		library.setName("Lib1");
		
		return lib;
	}

}
