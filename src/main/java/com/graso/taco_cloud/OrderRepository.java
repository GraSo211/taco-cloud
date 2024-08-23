
package com.graso.taco_cloud;

import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
    /*TacoOrder save(TacoOrder tacoOrder);*/
}
