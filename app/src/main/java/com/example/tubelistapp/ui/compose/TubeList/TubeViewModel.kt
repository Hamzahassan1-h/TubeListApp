package com.example.tubelistapp.ui.compose.TubeList

import androidx.lifecycle.viewModelScope
import com.example.common.nav.TubeListInput
import com.example.common.routes.TubeListNavRoutes
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.GetTubeUseCase
import com.example.tubelistapp.converter.TubeListConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TubeViewModel @Inject constructor(
    private val useCase: GetTubeUseCase,
    private val converter: TubeListConverter
): MviViewModel<TubeListModel, UiState<TubeListModel>, TubeListUiAction, TubeListUiSingleEvent>() {
    override fun initState(): UiState<TubeListModel> = UiState.Loading

    override fun handleAction(action: TubeListUiAction) {
        when (action) {
            is TubeListUiAction.Load -> {
                loadHistory()
            }
            is TubeListUiAction.OnStatusItemClick -> {
                submitSingleEvent(
                    TubeListUiSingleEvent.OpenDetailsScreen(
                        TubeListNavRoutes.Details.routeForHistory(
                            TubeListInput(
                                action.created,
                                action.id,
                                action.modeName,
                                action.modified,
                                action.name
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadHistory() {
        viewModelScope.launch {
            useCase.execute(GetTubeUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }


}