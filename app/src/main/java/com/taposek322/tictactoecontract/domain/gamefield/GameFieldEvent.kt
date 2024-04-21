package com.taposek322.tictactoecontract.domain.gamefield

data class GameFieldEvent(
    val position:Int,
    val action:ActionsValue?
)
