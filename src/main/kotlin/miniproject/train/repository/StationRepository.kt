package miniproject.train.repository

import miniproject.train.model.Seat
import miniproject.train.model.Station
import org.springframework.data.jpa.repository.JpaRepository

interface StationRepository : JpaRepository<Station, Long> {

}