package com.example.common.navRoutes

import androidx.navigation.NamedNavArgument
import com.example.common.routes.TubeListNavRoutes

sealed class navRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : navRoutes(ROUTE_HOME)
    data object Tube : navRoutes(
        TubeListNavRoutes.Details.route, TubeListNavRoutes.Details.arguments
    )


    companion object {

        const val ROUTE_HOME = "HomeScreen"
        const val ROUTE_TUBE = "TubeLists"

    }
}