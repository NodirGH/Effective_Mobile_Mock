package app.market.effectivemobilemock.di

import app.market.effectivemobilemock.ui.adapter_delegate.CourseAdapter
import app.market.effectivemobilemock.ui.adapter_delegate.HomeHeaderAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    fun provideCourseAdapter() = CourseAdapter()

    @Provides
    fun provideHomeHeaderAdapter() = HomeHeaderAdapter()
}