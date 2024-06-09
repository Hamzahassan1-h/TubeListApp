package com.example.tubelistapp.ui.compose.TubeList

import com.example.common.state.UiSingleEvent

open class TubeListUiSingleEvent : UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String) : TubeListUiSingleEvent()
}