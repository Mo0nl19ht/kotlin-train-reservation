package miniproject.train.repository

import miniproject.train.enum.TrainCategory
import miniproject.train.model.Station
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface StationRepository : JpaRepository<Station, Long> {
    fun findByNameAndTrainCategory(name: String, trainCategory: TrainCategory) : Station
    @Query(
        "select s from Station s " +
                "where s.trainCategory = :category " +
                "and s.stationOrder between :departure and :arrival"
    )
    fun findVisitStations(@Param("category")trainCategory: TrainCategory,
                          @Param("departure")departureStationOrder: Int,
                          @Param("arrival")arrivalStationOrder: Int): MutableList<Station>
}