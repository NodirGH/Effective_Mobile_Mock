package app.market.effectivemobilemock.ui.usecases

import app.market.data.repository.CourseRepository
import app.market.domain.models.CourseModel
import javax.inject.Inject

interface CourseUseCase {
    suspend fun getCourses(): List<CourseModel>
}

class CourseUseCaseImpl @Inject constructor(
    private val courseRepository: CourseRepository
) : CourseUseCase {
    override suspend fun getCourses(): List<CourseModel> {
        return courseRepository.getCourses()
    }
}