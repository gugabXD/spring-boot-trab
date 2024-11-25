package com.asscache.tfinal;

import org.springframework.data.repository.CrudRepository;

public interface AssinaturaRepository extends CrudRepository<Assinatura,Long> {
    Assinatura findByCode(Long code);
    Assinatura save(Assinatura assinatura);
}
