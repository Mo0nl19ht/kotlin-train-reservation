package miniproject.train.controller

import miniproject.train.dto.ReservationMakeDTO
import miniproject.train.service.PaymentService
import miniproject.train.service.ReservationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/payments")
class PaymentController(
    private val paymentService: PaymentService
) {
    @PutMapping("/confirm/{paymentId}")
    fun confirmPayment(@PathVariable paymentId: Long): Long? = paymentService.confirmPayment(paymentId)

    @PutMapping("/refund/{paymentId}")
    fun refundPayment(@PathVariable paymentId: Long): Long? = paymentService.refundPayment(paymentId)

}