package app.model.telegram

data class Venue(
    val location: Location,
    val title: String,
    val address: String,
    val foursquare_id: String?
)
