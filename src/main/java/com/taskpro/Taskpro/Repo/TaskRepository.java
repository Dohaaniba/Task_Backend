package com.taskpro.Taskpro.Repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taskpro.Taskpro.Entity.Task;

public interface TaskRepository extends JpaRepository<Task , Integer> {

	@Modifying
    @Query("UPDATE Task t SET t.status = :status WHERE t.id IN :taskIds")
    void saveAll(@Param("taskIds") List<Long> taskIds, @Param("status") String status);
	
	Optional<Task> findByTitle( String title);
	

}
