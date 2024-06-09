package com.example.tubelistapp.ui.compose.TubeList

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.common.state.CommonScreen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun TubeListScreen(
    viewModel: TubeViewModel,
    navController: NavHostController
) {
    LaunchedEffect(Unit) {
        viewModel.submitAction(TubeListUiAction.Load)
    }


    viewModel.uiStateFlow.collectAsState().value.let{ state->
        CommonScreen(state = state) {
            Column {
                TubeList(it) { item ->
                    viewModel.submitAction(
                        TubeListUiAction.OnStatusItemClick(
                            item.created,
                            item.id,
                            item.name,
                            item.modified,
                            item.modeName
                        )
                    )
                }

            }

        }
    }

    LaunchedEffect(Unit) {
        viewModel.singleEventFlow.collectLatest {
            when (it) {
                is TubeListUiSingleEvent.OpenDetailsScreen -> {
                    Log.i("ROUTE", it.navRoute)
                    navController.navigate(it.navRoute)
                }
            }
        }
    }
}

@Composable
fun TubeList(
    model: TubeListModel,
    onItemClick: (Tube) -> Unit
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(model.items) { tube ->
            TubeItem(tubeItem = tube, onItemClick = onItemClick)
        }
    }
}

@Composable
fun TubeItem(tubeItem: Tube, onItemClick: (Tube) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable { onItemClick (tubeItem) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "${tubeItem.name}")
        }

    }
}