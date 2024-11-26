package app.market.data.repository

import app.market.domain.models.CourseModel

interface CourseRepository {
    suspend fun getCourses(): List<CourseModel>
}

class CourseRepositoryImpl
//@Inject constructor(private val api: CourseApi)
    : CourseRepository {
    override suspend fun getCourses(): List<CourseModel> {

        return emptyList()
    }
}