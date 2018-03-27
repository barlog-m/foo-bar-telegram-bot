package app.model.telegram

sealed class ReplyMarkup

data class InlineKeyboardMarkup(
    val inline_keyboard: List<List<InlineKeyboardButton>>
) : ReplyMarkup()

data class ReplyKeyboardMarkup(
    val keyboard: List<List<KeyboardButton>>,
    val resize_keyboard: Boolean?,
    val one_time_keyboard: Boolean?,
    val selective: Boolean?
) : ReplyMarkup()

data class ReplyKeyboardRemove(
    val remove_keyboard: Boolean = true,
    val selective: Boolean?
) : ReplyMarkup()

data class ForceReply(
    val force_reply: Boolean = true,
    val selective: Boolean?
) : ReplyMarkup()
