package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable

enum class Status(val value: String) : Serializable {
    SCHEDULED("SCHEDULED"),
    LIVE("LIVE"),
    IN_PLAY("IN PLAY"),
    PAUSED("HALF TIME"),
    TIMED("TIMED"),
    FINISHED("FINISHED"),
    POSTPONED("POSTPONED"),
    SUSPENDED("SUSPENDED"),
    CANCELED("CANCELED"),
}
