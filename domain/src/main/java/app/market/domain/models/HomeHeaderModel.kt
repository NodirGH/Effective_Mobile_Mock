package app.market.domain.models

import app.market.domain.adapter_delegate.DisplayableItem

data class HomeHeaderModel(
    val searchCourse: String = "",
    val isFilterClicked: Boolean = false,
    val filterType: String = "",
    val courses: List<CourseModel> = emptyList()
): DisplayableItem
