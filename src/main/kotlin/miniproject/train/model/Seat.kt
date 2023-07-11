package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.SeatCategory
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

//@MappedSuperclass
//abstract class Seat(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    val id: Long = 0,
//
//) : BaseEntity()

@Entity
@Table(name = "seat")
class Seat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(nullable = false)
    var carNumber: Int,

    @Column(nullable = false)
    var seatNumber: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var seatCategory: SeatCategory

) : BaseEntity()



//@Entity
//@Table(name = "seat")
//class Seat2(
//    carNumber: Int,
//    seatCategory: SeatCategory,
//    seatNumber: String
//) : BaseEntity(){
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    val id: Long? = null
//
//    @Column(nullable = false)
//    var carNumber = carNumber
//
//    @Column(nullable = false)
//    var seatNumber = seatNumber
//
//    @Column(nullable = false)
//    var seatCategory = seatCategory
//}