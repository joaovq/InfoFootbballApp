package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

enum class Status(val value: String) {
    SCHEDULED("SCHEDULED"),
    LIVE("LIVE"),
    IN_PLAY("IN PLAY"),
    PAUSED("HALF TIME"),
    TIMED("TIMED"),
    FINISHED("FINISHED"),
    POSTPONED("POSTPONED"),
    SUSPENDED("SUSPENDED"),
    CANCELED("CANCELED")
}
