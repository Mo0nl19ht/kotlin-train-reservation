package miniproject.train.repository

import miniproject.train.model.Train
import org.springframework.data.jpa.repository.JpaRepository

interface TrainRepository : JpaRepository<Train, Long> {

}