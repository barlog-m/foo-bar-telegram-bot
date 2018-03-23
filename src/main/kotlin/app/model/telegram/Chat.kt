package app.model.telegram

data class Chat(
    val id: Int,
    val type: String,
    val title: String?,
    val username: String?,
    val first_name: String?,
    val last_name: String?,
    val all_members_are_administrators: Boolean?,
    val photo: ChatPhoto?,
    val description: String?,
    val invite_link: String?,
    val pinned_message: Message?,
    val sticker_set_name: String?,
    val can_set_sticker_set: Boolean?
)
