package com.example.tubelistapp.ui.compose.TubeList

import com.example.common.state.UiAction
//class TubeListUiAction {
//}
sealed class TubeListUiAction: UiAction {

    data object Load: TubeListUiAction()

    data class OnStatusItemClick(
        val created: String?,
        val id: String?,
        val modeName: String?,
        val modified: String?,
        val name: String?
    ) : TubeListUiAction()
}