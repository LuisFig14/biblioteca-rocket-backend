CREATE TABLE loans (
    id_loan NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    id_book NUMBER NOT NULL,
    id_student NUMBER NOT NULL,
    loan_date DATE NOT NULL,
    return_date DATE,

    CONSTRAINT fk_loans_book
        FOREIGN KEY (id_book)
        REFERENCES books(id_book),

    CONSTRAINT fk_loans_student
        FOREIGN KEY (id_student)
        REFERENCES students(id_student)
);