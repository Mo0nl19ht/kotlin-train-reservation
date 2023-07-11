package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.SeatCategory

@Entity
@Table(name = "reservation")
class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_station_id")
    var departureStation: Station,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_station_id")
    var arrivalStation: Station,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id")
    var train: Train,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    var seat: Seat,

    @OneToOne(cascade = [CascadeType.ALL])
    var payment: Payment?

) : BaseEntity()