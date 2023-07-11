package miniproject.train.model

import jakarta.persistence.*
import miniproject.train.enum.TrainCategory
import java.time.LocalDateTime

@Entity
@Table(name = "train")
class Train(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null,

    @Column(nullable = false)
    var departTime: LocalDateTime,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var trainCategory: TrainCategory,

//    @Column(nullable = false, unique = true)
//    @OneToMany(mappedBy = "train", cascade = [CascadeType.ALL])
//    //@OrderBy("order asc")
//    var seats: MutableList<Seat> = ArrayList(),

) : BaseEntity()

