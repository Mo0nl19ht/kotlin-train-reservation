package miniproject.train.dto

import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

data class ReservationSeatDTO (
    var carNumber: Int,
    var seatNumber: String,
)