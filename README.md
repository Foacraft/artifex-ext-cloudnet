# artifex-ext-cloudnet
Make the Artifex support cloudnet api.

API E.g:
```kotlin
val eventGroup = CloudEventGroup()

eventGroup.on<ChannelMessageReceiveEvent> { e ->
    if (e.channel() != CHANNEL_ID || e.message() != CHANNEL_UPDATE_TELEPORTED_LOCATION) {
        return@on
    }
    val player = e.content().readString()
    val world = e.content().readString()
    val x = e.content().readDouble()
    val y = e.content().readDouble()
    val z = e.content().readDouble()
    val yaw = e.content().readFloat()
    val pitch = e.content().readFloat()
    val location = Location(Bukkit.getWorld(world), x, y, z, yaw, pitch)
    if (Bukkit.getOnlinePlayers().any { it.uniqueId.toString() == player }) {
        submit { Bukkit.getPlayer(UUID.fromString(player))!!.teleport(location) }
        return@on
    }
    waitTeleport.put(UUID.fromString(player), location)
    e.content().release()
}

// finally unregister the all of eventGroup when script is releasing.
eventGroup.unregisters()
```