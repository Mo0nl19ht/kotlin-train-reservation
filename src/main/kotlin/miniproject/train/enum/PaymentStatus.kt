package miniproject.train.enum

enum class PaymentStatus(val status: String) {
    WAITING("결제 대기"),
    DONE("결제 완료"),
    CANCEL("결제 취소"),
    FAIL("결제 실패")
}