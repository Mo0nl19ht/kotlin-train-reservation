package miniproject.train

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrainApplication

fun main(args: Array<String>) {
    runApplication<TrainApplication>(*args)
}
