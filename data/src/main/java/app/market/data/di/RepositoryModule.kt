package app.market.data.di

import app.market.data.repository.CourseRepository
import app.market.data.repository.CourseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCourseRepository(
//        service: CourseService
    ): CourseRepository {
        return CourseRepositoryImpl()
    }
}