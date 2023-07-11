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

    var returnFee: Int?,

    @Enumerated(EnumType.STRING)
    var paymentStatus: PaymentStatus = PaymentStatus.WAITING

) : BaseEntity()