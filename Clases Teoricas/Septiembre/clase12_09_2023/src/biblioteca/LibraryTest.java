package biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class LibraryTest {

  @Test public void testNewLibraryHasNoAuthors() {
    assertTrue( new Library().searchAvailableByAuthor( "Anonimous" ).isEmpty() );
  }

  @Test public void testNewLibraryHasNoGenres() {
    assertTrue( new Library().searchAvailableByGenre( "SiFy" ).isEmpty() );
  }

  @Test public void testNewLibraryHasNoStock() {
    assertEquals( 0, new Library().available() );
  }

  @Test public void testLibraryWhitABookHasStock() {
    assertEquals( 1, libraryWithABook().available() );
  }



  @Test public void testLibraryWhitABookFindsItsGenre() {
    assertTrue( libraryWithABook().searchAvailableByGenre( java4Dummies().getGenre() ).contains( java4Dummies() ) );
  }



  @Test public void testLibraryWhitABookFindsItsAuthor() {
    assertTrue( libraryWithABook().searchAvailableByAuthor( java4Dummies().getAuthor() ).contains( java4Dummies() ) );
  }

  @Test public void testLibraryWhitABookRemoved() {
    Library library = libraryWithABook();

    assertEquals( 1, library.available() );

    library.removeBook( java4Dummies() );
    assertEquals( 0, library.available() );
  }

  @Test public void testLibraryWhitNoBooktoRemove() {
    Library library = new Library();
    
    
    try {
      library.removeBook( java4Dummies() );
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "cannot remove, book not registered", e.getMessage() );
    }
  }
  
  @Test public void testLibraryWhitTwiceABook() {
    Library library = libraryWithABook();
        
    try {
      library.addBook( java4Dummies() );
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "book already registered", e.getMessage() );
      assertEquals( 1, library.available() );
    }
  }

  @Test public void testFiltersAuthorsOnLibrary() {
    Library library = libraryWithABook();
    library.addBook( new Book( "Chamond Liu", "pythonForDummies", "IT" ) );
    library.addBook( new Book( "Martin Fowler", "TolkienUniverse", "SiFi" ) );

    assertEquals( 3, library.available() );
    assertTrue( library.searchAvailableByAuthor( "Martin Fowler" ).contains( java4Dummies() ) );
    assertTrue( library.searchAvailableByAuthor( "Martin Fowler" ).contains( new Book( "Martin Fowler", "TolkienUniverse", "SiFi" ) ) );
    assertFalse( library.searchAvailableByAuthor( "Martin Fowler" ).contains( new Book( "Chamond Liu", "pythonForDummies", "IT" ) ) );
  }

  @Test public void testFiltersGenreOnLibrary() {
    Library library = libraryWithABook();
    library.addBook( new Book( "Chamond Liu", "pythonForDummies", "IT" ) );
    library.addBook( new Book( "Martin Fowler", "TolkienUniverse", "SiFi" ) );

    assertEquals( 3, library.available() );
    assertTrue( library.searchAvailableByGenre( "IT" ).contains( java4Dummies() ) );
    assertTrue( library.searchAvailableByGenre( "IT" ).contains( new Book( "Chamond Liu", "pythonForDummies", "IT" ) ) );
    assertFalse( library.searchAvailableByGenre( "IT" ).contains( new Book( "Martin Fowler", "TolkienUniverse", "SiFi" ) ) );
  }

  // nuevo feature, alquiler de libros!
  
  @Test public void testSucessfulRent() {
    Library library = libraryWithABook();
    
    library.rentBook( java4Dummies() );
    
    assertEquals( 0, library.available() );
  }

  @Test public void testUnexistentRent() {
    Library library = new Library();
        
    try {
      library.rentBook( java4Dummies() );
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "book unavailable", e.getMessage() );
    }
  }

  @Test public void testRentTwice() {
    Library library = libraryWithABook();
    
    library.rentBook( java4Dummies() );
      
    try {
      library.rentBook( java4Dummies() );
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "book unavailable", e.getMessage() );
    }
  }

  @Test public void testRestoreRented() {
    Library library = libraryWithABook();
    
    library.rentBook( java4Dummies() );

    library.returnBook( java4Dummies() );
      
    assertEquals( 1, library.available() );
  }

  @Test public void testRestoreUnrented() {
    Library library = libraryWithABook();
    
    try {
      library.returnBook( java4Dummies() );
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "book not rented", e.getMessage() );
    }
     
    assertEquals( 1, library.available() );
  }

  @Test public void testLibraryWhitARentedBookRemoved() {
    Library library = libraryWithABook();

    library.rentBook( java4Dummies() );

    library.removeBook( java4Dummies() );
    try {
      library.returnBook( java4Dummies() );
      fail( "Ups" );
    } catch (Exception e) {
      assertEquals( "book not rented", e.getMessage() );
    } 
  }
  private Book java4Dummies() {
		return new Book( "Martin Fowler", "Java4Dummies", "IT" );
	}
  private Library libraryWithABook() {
		Library library = new Library();
	    library.addBook( java4Dummies() );
		return library;
	}
}
