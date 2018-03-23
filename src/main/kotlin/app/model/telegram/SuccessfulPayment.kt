package app.model.telegram

data class SuccessfulPayment(
    val currency: String,
    val total_amount: Int,
    val invoice_payload: String,
    val shipping_option_id: String?,
    val order_info: OrderInfo?,
    val telegram_payment_charge_id: String,
    val provider_payment_charge_id: String
)
