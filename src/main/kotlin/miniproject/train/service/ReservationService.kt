package miniproject.train.service

import miniproject.train.dto.ReservationMakeDTO
import miniproject.train.model.Payment
import miniproject.train.model.Reservation
import miniproject.train.model.ReservedSeat
import miniproject.train.repository.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ReservationService (
    private val reservationRepository: ReservationRepository,
    private val userRepository: UserRepository,
    private val stationRepository: StationRepository,
    private val trainRepository: TrainRepository,
    private val seatRepository: SeatRepository

){
    fun make_reservation(reservationMakeDTO: ReservationMakeDTO) : Long? {
        var user =  userRepository.findById(reservationMakeDTO.userId).get()
        var train = trainRepository.findById(reservationMakeDTO.trainId).get()
        var departureStation = stationRepository.findByNameAndTrainCategory(reservationMakeDTO.departureStation, train.trainCategory)
        var arrivalStation = stationRepository.findByNameAndTrainCategory(reservationMakeDTO.arrivalStation, train.trainCategory)
        var visitStations = stationRepository.findVisitStations(train.trainCategory, departureStation.stationOrder, arrivalStation.stationOrder)
        // 도착 역 에서는 다시 탈 수 있으므로 제외한다
        visitStations.remove(departureStation)

        var reservation = Reservation(
            user = user,
            departureStation = departureStation,
            arrivalStation = arrivalStation,
            train = train,
        )

        var reservedSeats = mutableListOf<ReservedSeat>()
        reservationMakeDTO.seats.map{
            // 예매 내역에서 seat 정보를 가져온다
            seatRepository.findByCarNumberAndSeatNumber(it.carNumber, it.seatNumber)
        }.forEach {
            // 해당 예매 내역의 일정이 진행되는 동안 방문하는역에서 seat을 예약시킨다
            for (visitStation in visitStations){
                reservedSeats.add(
                    ReservedSeat(
                        reservation = reservation,
                        train = train,
                        seat = it,
                        station = visitStation
                    )
                )
            }
        }
        reservation.addReservedSeats(reservedSeats)
        // 결제 정보를 추가한다
        var payment = Payment(
            reservation = reservation,
            totalFee = reservation.calculateTotalFee())
        reservation.addPayment(payment)

        return reservationRepository.save(reservation).id
    }
}