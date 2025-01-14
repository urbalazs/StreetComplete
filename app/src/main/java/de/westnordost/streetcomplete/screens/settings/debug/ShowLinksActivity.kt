package de.westnordost.streetcomplete.screens.settings.debug

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import de.westnordost.streetcomplete.R
import de.westnordost.streetcomplete.databinding.FragmentShowLinksBinding
import de.westnordost.streetcomplete.screens.BaseActivity
import de.westnordost.streetcomplete.screens.user.links.GroupedLinksAdapter
import de.westnordost.streetcomplete.util.ktx.openUri
import de.westnordost.streetcomplete.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/** activity only used in debug, to show all achievement links */
class ShowLinksActivity : BaseActivity() {

    private val binding by viewBinding(FragmentShowLinksBinding::inflate)
    private val viewModel by viewModel<ShowLinksActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_show_links)
        binding.toolbarLayout.toolbar.navigationIcon = getDrawable(R.drawable.ic_close_24dp)
        binding.toolbarLayout.toolbar.setNavigationOnClickListener { onBackPressed() }
        binding.toolbarLayout.toolbar.title = "Show Achievement Links"

        binding.linksList.apply {
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(context)
            adapter = GroupedLinksAdapter(viewModel.links, ::openUri)
        }
    }
}
