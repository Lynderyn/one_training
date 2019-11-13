package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.Trader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderRepository extends CrudRepository<Trader, String> {
    public Trader findOneById(String id);
    public boolean existsById(String id);
}
