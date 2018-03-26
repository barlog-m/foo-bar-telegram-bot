package app

import app.model.telegram.Update
import java.util.concurrent.ThreadLocalRandom

fun randomUpdate() = Update(
    update_id = ThreadLocalRandom.current().nextInt(1, 65535),
    message = null,
    edited_message = null,
    channel_post = null,
    edited_channel_post = null,
    inline_query = null,
    chosen_inline_result = null,
    callback_query = null,
    shipping_query = null,
    pre_checkout_query = null
)
