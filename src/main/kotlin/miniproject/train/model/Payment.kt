package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.PaymentStatus
import miniproject.train.enum.SeatCategory
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.chrono.ChronoLocalDateTime
import kotlin.time.Duration

@Entity
@Table(name = "payment")
class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @OneToOne
    var reservation: Reservation,

    var totalFee: Int,

    var refundFell: Int? = null,

    var paymentConfirmTime: LocalDateTime? = null,

    @Enumerated(EnumType.STRING)
    var paymentStatus: PaymentStatus = PaymentStatus.WAITING

) : BaseEntity() {

    fun changeStatus(status: PaymentStatus){
        paymentStatus = status
    }

    fun confirm(){
        paymentConfirmTime = LocalDateTime.now()
        changeStatus(PaymentStatus.DONE)
        reservation.confirm()
    }

    fun cancel() {
        changeStatus(PaymentStatus.CANCEL)
    }

    fun refund(){
        calculateRefundFee()
        changeStatus(PaymentStatus.REFUND)
    }
    /*
    출발 24시간 전 : 400원
    - 출발 24시간 전 ~ 출발 12시간 전 : 전체 금액의 10%
    - 출발 12시간 전 ~ 출발 6시간 전 : 전체 금액의 20%
    - 출발 6시간 전 ~ 출발 시간 : 전체 금액의 30% - 출발 이후 : 전체 금액의 50%
    출발 이후 : 전체 금액의 50%
    */
    fun calculateRefundFee(){
//        fun isPromotionTarget(remainTime: LocalDateTime) = when {
//            remainTime < ChronoLocalDateTime. -> false
//            rates > 3 -> false
//            rates == 3 -> true
//            else -> addToCart && rates == 2
//        }

        val departDateTime = reservation.getDepartDateTime()
//        Duration.between(currentDateTime, targetDateTime)

    }
}