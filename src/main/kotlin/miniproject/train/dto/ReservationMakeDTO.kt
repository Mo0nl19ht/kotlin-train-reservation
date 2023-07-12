package miniproject.train.dto

import miniproject.train.model.Reservation

data class ReservationMakeDTO (
    var departureStation: String,
    var arrivalStation: String,
    var userId: Long,
    var trainId: Long,
    var seats: List<ReservationSeatDTO>
)
