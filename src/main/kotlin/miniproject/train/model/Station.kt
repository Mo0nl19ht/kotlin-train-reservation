package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.TrainCategory

@Entity
@Table(name = "station")
class Station(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var trainCategory: TrainCategory,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false)
    var stationOrder: Int

) : BaseEntity()