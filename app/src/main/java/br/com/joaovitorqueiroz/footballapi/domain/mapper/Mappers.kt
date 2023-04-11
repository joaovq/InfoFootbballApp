package br.com.joaovitorqueiroz.footballapi.domain.mapper

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match

fun List<Match?>?.toMapperCompetition() = this?.map { it?.competition }?.toSet()
