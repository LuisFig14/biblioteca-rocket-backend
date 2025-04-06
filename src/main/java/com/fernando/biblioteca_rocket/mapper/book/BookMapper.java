package com.fernando.biblioteca_rocket.mapper.book;

import com.fernando.biblioteca_rocket.model.book.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Insert("INSERT INTO BOOKS (title, author, genre, isbn, stock) VALUES (#{title}, #{author}, #{genre}, #{isbn}, #{stock})")
    void createBook(Book book);

    @Select("SELECT ID_BOOK AS idBook, TITLE, AUTHOR, GENRE, ISBN, STOCK FROM BOOKS WHERE ID_BOOK = #{idBook}")
    Book getBookById (@Param("idBook") Long idBook);

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
