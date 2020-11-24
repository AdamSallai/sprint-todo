package com.codecool.springtodo.repository;

import com.codecool.springtodo.entity.Todo;
import com.codecool.springtodo.service.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByStatus(Status status);

    @Transactional
    @Modifying
    @Query("update Todo t set t.status = 'ACTIVE', t.completed = false where t.status = 'COMPLETE'")
    void updateAllStatusesToActive();

    @Transactional
    @Modifying
    @Query("update Todo t set t.status = 'COMPLETE', t.completed = true where t.status = 'ACTIVE'")
    void updateAllStatusesToComplete();
}
