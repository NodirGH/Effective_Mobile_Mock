package app.market.effectivemobilemock.ui.adapter_delegate

import app.market.domain.adapter_delegate.DisplayableItem
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class HomeMainAdapter(courseAdapter: CourseAdapter): ListDelegationAdapter<List<DisplayableItem>>(
    homeHeaderAdapter(courseAdapter),
//    coursesAdapter()
)