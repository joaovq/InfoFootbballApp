package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

enum class Status(val value: String) {
    SCHEDULED("LIVE"),
    LIVE("SCHEDULED"),
    IN_PLAY("IN PLAY"),
    PAUSED("PAUSED"),
    FINISHED("FINISHED"),
    POSTPONED("POSTPONED"),
    SUSPENDED("SUSPENDED"),
    CANCELED("CANCELED")
}
