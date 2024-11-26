package app.market.effectivemobilemock.di.domain

import app.market.data.repository.CourseRepository
import app.market.effectivemobilemock.ui.usecases.CourseUseCase
import app.market.effectivemobilemock.ui.usecases.CourseUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideCourseUseCase(
        courseRepository: CourseRepository
    ): CourseUseCase {
        return CourseUseCaseImpl(courseRepository)
    }
}