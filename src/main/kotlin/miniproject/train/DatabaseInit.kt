package miniproject.train

import jakarta.transaction.Transactional
import miniproject.train.enum.SeatCategory
import miniproject.train.enum.TrainCategory
import miniproject.train.enum.TrainDirection
import miniproject.train.model.Seat
import miniproject.train.model.Station
import miniproject.train.model.Train
import miniproject.train.model.User
import miniproject.train.repository.SeatRepository
import miniproject.train.repository.StationRepository
import miniproject.train.repository.TrainRepository
import miniproject.train.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.LocalTime


@Component
class DatabaseInit : CommandLineRunner {

    @Autowired
    lateinit var seatRepository: SeatRepository

    @Autowired
    lateinit var stationRepository: StationRepository

    @Autowired
    lateinit var trainRepository: TrainRepository

    @Autowired
    lateinit var userRepository: UserRepository

    @Throws(Exception::class)
    @Transactional
    override fun run(vararg args: String) {
        // User DB Init
        userRepository.save(User(name="예완", email = "mm@kia.com"))

        // Station DB Init
        stationRepository.save(Station(
            name = "서울",
            trainCategory = TrainCategory.GYEONGBU,
            stationOrder = 1))
        stationRepository.save(Station(
            name = "대전",
            trainCategory = TrainCategory.GYEONGBU,
            stationOrder = 2))
        stationRepository.save(Station(
            name = "대구",
            trainCategory = TrainCategory.GYEONGBU,
            stationOrder = 3))
        stationRepository.save(Station(
            name = "경주",
            trainCategory = TrainCategory.GYEONGBU,
            stationOrder = 4))
        stationRepository.save(Station(
            name = "울산",
            trainCategory = TrainCategory.GYEONGBU,
            stationOrder = 5))
        stationRepository.save(Station(
            name = "부산",
            trainCategory = TrainCategory.GYEONGBU,
            stationOrder = 6))

        stationRepository.save(Station(
            name = "서울",
            trainCategory = TrainCategory.HONAM,
            stationOrder = 1))
        stationRepository.save(Station(
            name = "오송",
            trainCategory = TrainCategory.HONAM,
            stationOrder = 2))
        stationRepository.save(Station(
            name = "익산",
            trainCategory = TrainCategory.HONAM,
            stationOrder = 3))
        stationRepository.save(Station(
            name = "정읍",
            trainCategory = TrainCategory.HONAM,
            stationOrder = 4))
        stationRepository.save(Station(
            name = "광주",
            trainCategory = TrainCategory.HONAM,
            stationOrder = 5))
        stationRepository.save(Station(
            name = "목포",
            trainCategory = TrainCategory.HONAM,
            stationOrder = 6))

        // Train DB Init
        trainRepository.save(Train(
            departTime = LocalTime.of(5,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.DOWN,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(9,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.DOWN,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(13,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.DOWN,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(17,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.DOWN,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(21,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.DOWN,
        ))

        trainRepository.save(Train(
            departTime = LocalTime.of(5,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.UP,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(9,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.UP,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(13,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.UP,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(17,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.UP,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(21,0),
            trainCategory = TrainCategory.GYEONGBU,
            trainDirection = TrainDirection.UP,
        ))

        trainRepository.save(Train(
            departTime = LocalTime.of(6,0),
            trainCategory = TrainCategory.HONAM,
            trainDirection = TrainDirection.DOWN,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(11,0),
            trainCategory = TrainCategory.HONAM,
            trainDirection = TrainDirection.DOWN,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(16,0),
            trainCategory = TrainCategory.HONAM,
            trainDirection = TrainDirection.DOWN,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(21,0),
            trainCategory = TrainCategory.HONAM,
            trainDirection = TrainDirection.DOWN,
        ))

        trainRepository.save(Train(
            departTime = LocalTime.of(6,0),
            trainCategory = TrainCategory.HONAM,
            trainDirection = TrainDirection.UP,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(11,0),
            trainCategory = TrainCategory.HONAM,
            trainDirection = TrainDirection.UP,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(16,0),
            trainCategory = TrainCategory.HONAM,
            trainDirection = TrainDirection.UP,
        ))
        trainRepository.save(Train(
            departTime = LocalTime.of(21,0),
            trainCategory = TrainCategory.HONAM,
            trainDirection = TrainDirection.UP,
        ))

        // Seat DB Init
        for(i: Int in 1..18) {
            if (i in 3..5){
                for (j: Int in 1..12) {
                    seatRepository.save(
                        Seat(
                            carNumber = i,
                            seatNumber = j.toString() + "A",
                            seatCategory = SeatCategory.SPECIAL
                        )
                    )
                    seatRepository.save(
                        Seat(
                            carNumber = i,
                            seatNumber = j.toString() + "B",
                            seatCategory = SeatCategory.SPECIAL
                        )
                    )
                    seatRepository.save(
                        Seat(
                            carNumber = i,
                            seatNumber = j.toString() + "C",
                            seatCategory = SeatCategory.SPECIAL
                        )
                    )
                }
                continue
            }

            for (j: Int in 1..8){
                seatRepository.save(
                    Seat(
                        carNumber = i,
                        seatNumber = j.toString() + "A",
                        seatCategory = SeatCategory.FORWARD
                    )
                )
                seatRepository.save(
                    Seat(
                        carNumber = i,
                        seatNumber = j.toString() + "B",
                        seatCategory = SeatCategory.FORWARD
                    )
                )
                seatRepository.save(
                    Seat(
                        carNumber = i,
                        seatNumber = j.toString() + "C",
                        seatCategory = SeatCategory.FORWARD
                    )
                )
                seatRepository.save(
                    Seat(
                        carNumber = i,
                        seatNumber = j.toString() + "D",
                        seatCategory = SeatCategory.FORWARD
                    )
                )
            }
            for (j: Int in 9..16){
                seatRepository.save(
                    Seat(
                        carNumber = i,
                        seatNumber = j.toString() + "A",
                        seatCategory = SeatCategory.BACKWARD
                    )
                )
                seatRepository.save(
                    Seat(
                        carNumber = i,
                        seatNumber = j.toString() + "B",
                        seatCategory = SeatCategory.BACKWARD
                    )
                )
                seatRepository.save(
                    Seat(
                        carNumber = i,
                        seatNumber = j.toString() + "C",
                        seatCategory = SeatCategory.BACKWARD
                    )
                )
                seatRepository.save(
                    Seat(
                        carNumber = i,
                        seatNumber = j.toString() + "D",
                        seatCategory = SeatCategory.BACKWARD
                    )
                )
            }
        }
    }
}