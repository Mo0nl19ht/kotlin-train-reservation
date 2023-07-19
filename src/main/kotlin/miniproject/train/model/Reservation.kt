package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.ReservationStatus
import miniproject.train.enum.SeatCategory

@Entity
@Table(name = "reservation")
class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departure_station_id")
    var departureStation: Station,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arrival_station_id")
    var arrivalStation: Station,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id")
    var train: Train,

    @OneToMany(mappedBy = "reservation", cascade = [CascadeType.ALL], orphanRemoval = true)
    var reservedSeats: MutableList<ReservedSeat> = mutableListOf(),

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var payment: Payment? = null,

    @Enumerated(EnumType.STRING)
    var reservationStatus: ReservationStatus = ReservationStatus.WAITING

) : BaseEntity(){

    val defaultFee = 10000

    fun addReservedSeats(reservedSeats: List<ReservedSeat>){
        this.reservedSeats.addAll(reservedSeats)
    }

    fun changeStatus(status: ReservationStatus){
        reservationStatus = status
    }

    fun cancelReservation(){
        // 예약된 좌석 삭제
        reservedSeats.clear()
        changeStatus(ReservationStatus.CANCEL)
        payment?.cancelPayment()
    }

    fun calculateTotalFee() : Int{
        return reservedSeats.map{
            when(it.seat.seatCategory) {
                SeatCategory.STANDING -> defaultFee * 0.8
                SeatCategory.BACKWARD -> defaultFee * 0.9
                SeatCategory.SPECIAL -> defaultFee * 1.5
                SeatCategory.FORWARD -> defaultFee
            }
        }.fold(0) { total, fee ->
            total + fee.toInt()
        }
    }

    fun addPayment(payment: Payment){
        this.payment = payment
    }
}
