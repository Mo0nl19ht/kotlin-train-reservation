package miniproject.train

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class TrainApplication

fun main(args: Array<String>) {
    runApplication<TrainApplication>(*args)
}
