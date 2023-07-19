package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.ReservationStatus
import miniproject.train.enum.SeatCategory
import miniproject.train.enum.TrainCategory
import miniproject.train.enum.TrainDirection
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

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
    var reservationStatus: ReservationStatus = ReservationStatus.WAITING,

    var departDate: LocalDate

) : BaseEntity(){

    val defaultFee = 10000

    fun addReservedSeats(reservedSeats: List<ReservedSeat>){
        this.reservedSeats.addAll(reservedSeats)
    }

    fun addPayment(payment: Payment){
        this.payment = payment
    }

    fun changeStatus(status: ReservationStatus){
        reservationStatus = status
    }

    fun getDepartDateTime() : LocalDateTime {
        val honamMaxStationOrder = 6
        val gyeonbuMaxStationOrder = 6
        var departTime = train.departTime
        var extraTime =  departureStation.stationOrder -1
        if (train.trainDirection == TrainDirection.UP){
            extraTime = when(train.trainCategory) {
                TrainCategory.HONAM -> honamMaxStationOrder - departureStation.stationOrder
                TrainCategory.GYEONGBU -> gyeonbuMaxStationOrder - departureStation.stationOrder
            }
        }
        departTime = departTime.plusHours(extraTime.toLong())
        return departDate.atTime(departTime)
    }


    fun cancel(){
        // 예약된 좌석 삭제
        reservedSeats.clear()
        changeStatus(ReservationStatus.CANCEL)
        payment?.cancel()
    }

    fun refund() {
        // 예약된 좌석 삭제
        reservedSeats.clear()
        changeStatus(ReservationStatus.REFUND)
    }

    fun confirm() {
        changeStatus(ReservationStatus.DONE)
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


}
