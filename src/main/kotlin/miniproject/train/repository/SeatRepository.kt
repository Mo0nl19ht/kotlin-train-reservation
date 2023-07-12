package miniproject.train.repository

import miniproject.train.model.Seat
import org.springframework.data.jpa.repository.JpaRepository

interface SeatRepository : JpaRepository<Seat, Long> {
    fun findByCarNumberAndSeatNumber(carNumber: Int, seatNumber: String) : Seat
}