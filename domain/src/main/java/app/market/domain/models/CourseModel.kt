package app.market.domain.models

import app.market.domain.adapter_delegate.DisplayableItem

data class CourseModel(
    val id: String,
    val picture: Int,
    val isFavorite: Boolean,
    val rating: Float,
    val publishedDate: String,
    val courseTitle: String,
    val description: String,
    val price: Float,
): DisplayableItem
