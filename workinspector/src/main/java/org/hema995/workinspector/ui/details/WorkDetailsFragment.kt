package org.hema995.workinspector.ui.details

import android.os.Bundle
import android.view.View
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.hema995.workinspector.IsolatedKoinComponent
import org.hema995.workinspector.R
import org.hema995.workinspector.databinding.WiFragmentWorkListBinding
import org.hema995.workinspector.ui.util.collectInLifecycle
import org.hema995.workinspector.ui.util.showErrorDialog

internal class WorkDetailsFragment : Fragment(R.layout.wi_fragment_work_list),
    IsolatedKoinComponent,
    OnApplyWindowInsetsListener {

    private val viewModel by viewModel<WorkDetailsViewModel>()
    private var binding: WiFragmentWorkListBinding? = null

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        val listAdapter = WorkDetailsAdapter()
        binding = WiFragmentWorkListBinding.bind(view).apply {
            ViewCompat.setOnApplyWindowInsetsListener(root, this@WorkDetailsFragment)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = listAdapter
        }
        viewModel.workers.collectInLifecycle(viewLifecycleOwner) {
            listAdapter.submitList(it)
            binding?.textViewHolder?.isVisible = it.isEmpty()
        }
        viewModel.onError.collectInLifecycle(viewLifecycleOwner) { e ->
            showErrorDialog(requireContext(), e)
        }
    }

    override fun onApplyWindowInsets(
        v: View,
        insets: WindowInsetsCompat,
    ): WindowInsetsCompat {
        binding?.recyclerView?.run {
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            updatePadding(
                left = systemBarsInsets.left,
                right = systemBarsInsets.right,
                bottom = systemBarsInsets.bottom + paddingTop,
            )
        }
        return WindowInsetsCompat.CONSUMED
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        activity?.title = arguments?.getString(ARG_WORKER_CLASS_NAME)?.substringAfterLast('.')
            ?: getString(R.string.wi_lib_name)
    }

    companion object {
        const val ARG_WORKER_CLASS_NAME = "workerClassName"
    }
}
