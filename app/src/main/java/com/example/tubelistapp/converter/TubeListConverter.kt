package com.example.tubelistapp.converter

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import com.example.common.state.CommonResultConverter
import com.example.domain.usecase.GetTubeUseCase
import com.example.tubelistapp.ui.compose.TubeList.Tube
import com.example.tubelistapp.ui.compose.TubeList.TubeListModel
import javax.inject.Inject


class TubeListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetTubeUseCase.Response, TubeListModel>() {
    override fun convertSuccess(
        data: GetTubeUseCase.Response
    ): TubeListModel{
        return TubeListModel(
            items = data.status?.map {
                Tube(
                    created = it?.created,
                    id = it?.id,
                    modeName = it?.modeName,
                    modified = it?.modified,
                    name = it?.name
                )
            } ?: listOf()

        )

    }

}
