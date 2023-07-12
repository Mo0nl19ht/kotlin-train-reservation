package miniproject.train.model

import jakarta.persistence.*

@Entity
@Table(name = "user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(nullable = false)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String,

//    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL])
//    var reservations: MutableList<Reservation> = mutableListOf()

    ) : BaseEntity()