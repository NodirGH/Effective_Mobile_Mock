package app.market.effectivemobilemock.ui.adapter_delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.market.domain.models.CourseModel
import app.market.effectivemobilemock.databinding.ItemCourseBinding

class CourseAdapter : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    private val courses = ArrayList<CourseModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            ItemCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
            holder.bind(courses[position])
    }

    override fun getItemCount(): Int {
       return courses.size
    }

    inner class CourseViewHolder(private val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(course: CourseModel){
                binding.tvCourseTitle.text = course.courseTitle
                binding.tvCourseDescription.text = course.description
                binding.tvDate.text = course.publishedDate
                binding.tvPrice.text = course.price.toString()
                binding.tvRating.text = course.rating.toString()
                binding
            }
    }

    fun setCourses(courseList: List<CourseModel>){
        courses.clear()
        courses.addAll(courseList)
        notifyDataSetChanged()
    }
}