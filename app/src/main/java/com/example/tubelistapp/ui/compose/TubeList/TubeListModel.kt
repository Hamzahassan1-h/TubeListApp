package com.example.tubelistapp.ui.compose.TubeList

data class TubeListModel(
    val items: List<Tube> = listOf()
)

data class Tube(
    val created: String?,
    val id: String?,
    val modeName: String?,
    val modified: String?,
    val name: String?
)
