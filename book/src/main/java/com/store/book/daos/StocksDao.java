package com.store.book.daos;

import com.store.book.domains.entity.Stocks;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StocksDao extends JpaRepository<Stocks, Long> {
    @Modifying
    @Query("update Stocks s set s.amount = s.amount + :amount where s.books.id = :bookId")
    void increaseStock(@Param("bookId") Long bookId, @Param("amount") Integer amount);

    @Modifying
    @Query("update Stocks s set s.amount = s.amount - :amount where s.books.id = :bookId")
    void decreaseStock(@Param("bookId") Long bookId, @Param("amount") Integer amount);

    @Modifying
    @Query("update Stocks s set s.amount = :amount where s.books.id = :bookId")
    void setStock(@Param("bookId") Long bookId, @Param("amount") Integer amount);
}
