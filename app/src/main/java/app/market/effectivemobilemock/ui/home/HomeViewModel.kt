package app.market.effectivemobilemock.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.market.domain.adapter_delegate.DisplayableItem
import app.market.domain.models.CourseModel
import app.market.domain.models.HomeHeaderModel
import app.market.effectivemobilemock.ui.usecases.CourseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val coursesUseCase: CourseUseCase
) : ViewModel() {

    private val _courses = MutableLiveData<List<DisplayableItem>>()
    val courses: LiveData<List<DisplayableItem>> = _courses

    fun getCourses() {
        viewModelScope.launch(Dispatchers.IO) {
            val data = coursesUseCase.getCourses()

        }
    }


    private val _displayedItems = MutableLiveData<List<DisplayableItem>>()
    val displayableItems: LiveData<List<DisplayableItem>> = _displayedItems

    fun createDummyDisplayableItems() {
        val displayableItems = ArrayList<DisplayableItem>()
        displayableItems.add(
            HomeHeaderModel(
                "Go", true, "By Date added", listOf(
                    CourseModel("1", 0, true, 4.9F, "May 20", "Title 1", "Description 1", 1000F),
                    CourseModel("2", 0, false, 3.9F, "May 10", "Title 2", "Description 2", 1500F),
                    CourseModel("3", 0, true, 4.2F, "June 20", "Title 3", "Description 3", 1400F),
                    CourseModel(
                        "4",
                        0,
                        false,
                        4.5F,
                        "September 13",
                        "Title 4",
                        "Description 4",
                        2000F
                    ),
                    CourseModel(
                        "5",
                        0,
                        true,
                        2.9F,
                        "December 31",
                        "Title 5",
                        "Description 5",
                        2400F
                    ),
                    CourseModel("6", 0, true, 3.5F, "May 20", "Title 6", "Description 6", 15000F),
                    CourseModel(
                        "7",
                        0,
                        false,
                        4.0F,
                        "September 20",
                        "Title 7",
                        "Description 7",
                        1850F
                    ),
                    CourseModel("8", 0, true, 4.4F, "May 10", "Title 8", "Description 18", 1010F),
                    CourseModel(
                        "9",
                        0,
                        false,
                        3.9F,
                        "December 20",
                        "Title 9",
                        "Description 9",
                        5000F
                    ),
                    CourseModel(
                        "10",
                        0,
                        true,
                        4.1F,
                        "September 20",
                        "Title 10",
                        "Description 10",
                        1000F
                    ),
                )
            )
        )
        _displayedItems.postValue(displayableItems)
    }
}