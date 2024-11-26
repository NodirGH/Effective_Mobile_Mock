package app.market.effectivemobilemock.ui.adapter_delegate

import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.market.domain.adapter_delegate.DisplayableItem
import app.market.domain.models.CourseModel
import app.market.domain.models.HomeHeaderModel
import app.market.effectivemobilemock.R
import app.market.effectivemobilemock.databinding.ItemCourseBinding
import app.market.effectivemobilemock.databinding.ItemHomeHeaderBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun homeHeaderAdapter(courseAdapter: CourseAdapter) = adapterDelegateViewBinding<HomeHeaderModel, DisplayableItem, ItemHomeHeaderBinding>(
    {layoutInflater, root -> ItemHomeHeaderBinding.inflate(layoutInflater, root, false) }
){
    bind {
        binding.rvCourses.apply {
            adapter = courseAdapter
            layoutManager = LinearLayoutManager(itemView.context, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
        courseAdapter.setCourses(item.courses)

        binding.tvSearchType.text = getString(R.string.ByDateAdded)
    }
}

fun coursesAdapter() = adapterDelegateViewBinding<CourseModel, DisplayableItem, ItemCourseBinding>(
    {layoutInflater, root -> ItemCourseBinding.inflate(layoutInflater, root, false) }
){
    bind {
        binding.apply {
            tvCourseTitle.text = item.courseTitle
            tvPrice.text = item.price.toString()
            tvCourseDescription.text = item.description
            tvRating.text = item.rating.toString()
            tvDate.text = item.publishedDate
//            ivFavorite todo
//            ivCoursePicture todo
        }

    }
}