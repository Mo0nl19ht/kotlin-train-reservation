package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.TrainCategory
import miniproject.train.enum.TrainDirection
import java.time.LocalTime

@Entity
@Table(name = "train")
class Train(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    @Column(nullable = false)
    var departTime: LocalTime,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var trainCategory: TrainCategory,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var trainDirection: TrainDirection

//    //@OrderBy("order asc")


) : BaseEntity()

