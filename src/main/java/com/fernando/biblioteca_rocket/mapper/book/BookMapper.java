package com.fernando.biblioteca_rocket.mapper.book;

import com.fernando.biblioteca_rocket.model.book.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Insert("INSERT INTO BOOKS (title, author, genre, isbn, stock) VALUES (#{title}, #{author}, #{genre}, #{isbn}, #{stock})")
    void createBook(Book book);

    @Select("SELECT * FROM BOOKS WHERE ID_BOOK = #{idBook}")
    @Results({
            @Result(property = "idBook", column = "ID_BOOK"),
            @Result(property = "title", column = "TITLE"),
            @Result(property = "author", column = "AUTHOR"),
            @Result(property = "genre", column = "GENRE"),
            @Result(property = "isbn", column = "ISBN"),
            @Result(property = "stock", column = "STOCK")
    })
    Book getBookById(Long idBook);

    @Select("SELECT * FROM BOOKS")
    @Results({@Result(property = "idBook", column = "ID_BOOK")})
    List<Book> getAllBooks ();

    @Update(
            "UPDATE BOOKS SET " +
                    "TITLE = #{title}, " +
                    "AUTHOR = #{author}, " +
                    "GENRE = #{genre}, " +
                    "ISBN = #{isbn}, " +
                    "STOCK = #{stock} " +
                    "WHERE ID_BOOK = #{idBook}"
    )
    void updateBook(Book book);

    @Delete("DELETE FROM BOOKS WHERE ID_BOOK = #{idBook}")
    void deleteBook(Long idBook);

}
