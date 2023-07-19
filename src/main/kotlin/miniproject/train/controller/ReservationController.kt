package miniproject.train.controller

import miniproject.train.dto.ReservationMakeDTO
import miniproject.train.service.ReservationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/reservations")
class ReservationController(
    private val reservationService: ReservationService
) {
    @PostMapping("")
    fun createReservation(@RequestBody reservationMakeDTO: ReservationMakeDTO): Long?
        = reservationService.makeReservation(reservationMakeDTO)


    @PutMapping("/cancel/{reservationId}")
    fun cancelReservation(@PathVariable reservationId: Long): Long? = reservationService.cancelReservation(reservationId)


}