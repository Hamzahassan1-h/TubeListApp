package com.example.common.routes

import android.net.Uri
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.common.nav.TubeListInput

//class TubeListNavRoutes {
//}
sealed class TubeListNavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Details : TubeListNavRoutes(
        route = "$ROUTE_HISTORY_DETAILS/{$ARG_HISTORY_DATA}",
        arguments = listOf(
            navArgument(ARG_HISTORY_DATA) { type = NavType.StringType }
        )
    ) {
        fun routeForHistory(input: TubeListInput): String {
            val json = Uri.encode(input.toJson())
            return "$ROUTE_HISTORY_DETAILS/$json"
        }

        fun fromEntry(entry: NavBackStackEntry): TubeListInput {
            val json = entry.arguments?.getString(ARG_HISTORY_DATA) ?: ""
            return TubeListInput.fromJson(json)
        }
    }

    companion object {
        const val ROUTE_HISTORY_DETAILS = "historyDetails"
        const val ARG_HISTORY_DATA = "historyData"
    }
}
