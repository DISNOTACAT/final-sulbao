package com.finalproject.sulbao.cart.repository;

import com.finalproject.sulbao.cart.domain.Carts;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Carts, Integer> {

    List<Carts> findByUserId(String userId, Sort cartCode);
    Long deleteByCartCode(Long cartCode);

    Optional<Carts> findByCartCode(Long cartCode);

    List<Carts> findByCartCodeIn(List<Long> cartCodes, Sort cartCode);

    @Query(value = "SELECT SUM(total_price) FROM tbl_cart WHERE cart_code IN (:cartCodes)", nativeQuery = true)
    int findTotalPurchasePriceByCartCodeIn(List<Long> cartCodes);
}