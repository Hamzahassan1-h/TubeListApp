package com.example.tubelistapp.ui.compose.TubeList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.common.nav.TubeListInput

@Composable
fun TubeDetailScreen(TubeListInput: TubeListInput) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "id: ${TubeListInput.id}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "name: ${TubeListInput.name}",
            style = MaterialTheme.typography.bodyMedium
        )

        Text(
            text = "Modified: ${TubeListInput.modified}",
            style = MaterialTheme.typography.bodyMedium
        )

    }
}