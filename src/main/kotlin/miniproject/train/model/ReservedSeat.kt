package miniproject.train.model

import jakarta.persistence.*

@Entity
@Table(name = "reserved_seat")
class ReservedSeat(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    var reservation: Reservation,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id")
    var train: Train,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    var seat: Seat,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    var station: Station

) : BaseEntity()