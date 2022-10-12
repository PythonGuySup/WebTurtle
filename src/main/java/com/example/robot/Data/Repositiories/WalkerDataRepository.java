package com.example.robot.Data.Repositiories;

import com.example.robot.Logic.Walker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalkerDataRepository extends CrudRepository<Walker, Long> {
}
