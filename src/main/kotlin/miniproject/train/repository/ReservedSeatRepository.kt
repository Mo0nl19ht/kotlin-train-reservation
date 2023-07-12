package miniproject.train.repository

import miniproject.train.model.Payment
import miniproject.train.model.ReservedSeat
import org.springframework.data.jpa.repository.JpaRepository

interface ReservedSeatRepository : JpaRepository<ReservedSeat, Long> {
}