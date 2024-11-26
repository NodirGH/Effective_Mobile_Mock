package app.market.effectivemobilemock.ui.adapter_delegate

import app.market.domain.models.CourseModel

object MockData {

    fun homeData(): List<CourseModel> {
        return listOf(
            CourseModel(
                "1",
                0,
                true,
                4.2F,
                "May 24",
                "Android developer",
                "Description 1: Good for you",
                44.2F
            ),
            CourseModel(
                "2",
                0,
                false,
                4.9F,
                "June 24",
                "Flutter developer",
                "Description 2: Good enough for you",
                24.2F
            ),
            CourseModel(
                "3",
                0,
                true,
                4.0F,
                "April 12",
                "OIS developer",
                "Description 3: Good for IOS Developer",
                44.2F
            ),
            CourseModel(
                "4",
                0,
                true,
                3.9F,
                "September 30",
                "UI/UX designer",
                "Description 4: Good for you",
                44.2F
            ),
            CourseModel(
                "5",
                0,
                false,
                5.0F,
                "July 3",
                "Android developer",
                "Description 5: Excellent for you",
                56.7F
            ),
        )
    }

    fun mockData(): List<String>{
         return listOf(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
            "Unknown"
        )
    }
}