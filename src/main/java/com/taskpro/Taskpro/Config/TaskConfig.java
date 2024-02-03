package com.taskpro.Taskpro.Config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.taskpro.Taskpro.Entity.Status;
import com.taskpro.Taskpro.Entity.Task;
import com.taskpro.Taskpro.Repo.TaskRepository;

@Configuration

public class TaskConfig {
	@Bean
	CommandLineRunner  commandLineRunner(TaskRepository repository) {
		return args ->{
			Task first = new Task(1, "First",
                    "manger et faire du sport",
                    Status.TODO,
                    LocalDate.of(2023, Month.JANUARY, 29), 
                    LocalDate.of(2024, Month.JANUARY, 29)
                    );
			Task second = new Task(1, "second",
                    "lire et aller au cinema",
                    Status.IN_PROGRESS,
                    LocalDate.of(2023, Month.FEBRUARY, 12), 
                    LocalDate.of(2025, Month.MARCH, 29)
                    );
			repository.saveAll(List.of(first, second));
			
		};
		
	}

}
