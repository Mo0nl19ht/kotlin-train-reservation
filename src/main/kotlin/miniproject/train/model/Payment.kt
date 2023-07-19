package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.PaymentStatus

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

    var returnFee: Int? = null,

    @Enumerated(EnumType.STRING)
    var paymentStatus: PaymentStatus = PaymentStatus.WAITING

) : BaseEntity() {

    fun changeStatus(status: PaymentStatus){
        paymentStatus = status
    }
    fun cancel() {
        changeStatus(PaymentStatus.CANCEL)
    }
}