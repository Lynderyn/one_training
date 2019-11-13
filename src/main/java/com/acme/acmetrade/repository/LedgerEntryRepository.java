package com.acme.acmetrade.repository;

import com.acme.acmetrade.domain.LedgerEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LedgerEntryRepository extends CrudRepository<LedgerEntry, String> {
}
