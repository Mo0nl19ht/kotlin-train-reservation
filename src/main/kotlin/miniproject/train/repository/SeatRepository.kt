package miniproject.train.repository

import miniproject.train.model.Seat
import miniproject.train.model.Train
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository : JpaRepository<Seat, Long> {

}