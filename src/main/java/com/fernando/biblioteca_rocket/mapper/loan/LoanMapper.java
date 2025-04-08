package com.fernando.biblioteca_rocket.mapper.loan;

import com.fernando.biblioteca_rocket.model.loan.Loan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LoanMapper {

    @Insert("INSERT INTO loans (id_book, id_student, loan_date, return_date) VALUES (#{idBook}, #{idStudent}, #{loanDate}, #{returnDate})")
    void insertLoan(Loan loan);

    @Select("SELECT ID_LOAN, ID_BOOK, ID_STUDENT, LOAN_DATE, RETURN_DATE " +
            "FROM LOANS WHERE ID_LOAN = #{idLoan}")
    @Results({
            @Result(property = "idLoan", column = "ID_LOAN"),
            @Result(property = "idBook", column = "ID_BOOK"),
            @Result(property = "idStudent", column = "ID_STUDENT"),
            @Result(property = "loanDate", column = "LOAN_DATE"),
            @Result(property = "returnDate", column = "RETURN_DATE"),
            @Result(property = "book", column = "ID_BOOK",
                    one = @One(select = "com.fernando.biblioteca_rocket.mapper.book.BookMapper.getBookById")),
            @Result(property = "student", column = "ID_STUDENT",
                    one = @One(select = "com.fernando.biblioteca_rocket.mapper.student.StudentMapper.getStudentById"))
    })
    Loan getLoanById(Long idLoan);


    @Select("SELECT ID_LOAN, ID_BOOK, ID_STUDENT, LOAN_DATE, RETURN_DATE FROM LOANS")
    @Results({
            @Result(property = "idLoan", column = "ID_LOAN"),
            @Result(property = "idBook", column = "ID_BOOK"),
            @Result(property = "idStudent", column = "ID_STUDENT"),
            @Result(property = "loanDate", column = "LOAN_DATE"),
            @Result(property = "returnDate", column = "RETURN_DATE"),
            @Result(property = "book", column = "ID_BOOK",
                    one = @One(select = "com.fernando.biblioteca_rocket.mapper.book.BookMapper.getBookById")),
            @Result(property = "student", column = "ID_STUDENT",
                    one = @One(select = "com.fernando.biblioteca_rocket.mapper.student.StudentMapper.getStudentById"))
    })
    List<Loan> getAllLoans();

    @Update("UPDATE LOANS SET ID_BOOK = #{idBook}, ID_STUDENT = #{idStudent}, LOAN_DATE = #{loanDate}, RETURN_DATE = #{returnDate} WHERE ID_LOAN = #{idLoan}")
    void updateLoan(Loan loan);

    @Delete("DELETE FROM LOANS WHERE ID_LOAN = #{idLoan}")
    void deleteLoan(@Param("idLoan") Long idLoan);


}
