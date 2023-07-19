package miniproject.train.service

import miniproject.train.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class PaymentService (
    private val paymentRepository: PaymentRepository
){
    @Transactional
    fun confirmPayment(paymentId: Long): Long? {
        var payment  = paymentRepository.findById(paymentId).get()
        payment.confirm()

        return paymentRepository.save(payment).id
    }

    @Transactional
    fun refundPayment(paymentId: Long): Long? {
        var payment  = paymentRepository.findById(paymentId).get()
        payment.refund()

        return 1
    }
}