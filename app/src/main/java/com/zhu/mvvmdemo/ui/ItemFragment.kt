package com.zhu.mvvmdemo.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zhu.mvvmdemo.R
import com.zhu.mvvmdemo.databinding.FragmentItemListBinding
import com.zhu.mvvmdemo.ui.adapters.MyItemRecyclerViewAdapter
import com.zhu.mvvmdemo.ui.data.ContentResponse
import com.zhu.mvvmdemo.util.viewBindings

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment(R.layout.fragment_item) {

    companion object {
        const val ARG_COLUMN_COUNT = "column-count"

        @JvmStatic
        fun newInstance(columnCount: Int) =
                ItemFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }

    private val columnCount by lazy { arguments?.getInt(ARG_COLUMN_COUNT) ?: 1 }

    private val binding by viewBindings(FragmentItemListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Set the adapter
        with(binding.list) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = MyItemRecyclerViewAdapter(ContentResponse.ITEMS)
        }
    }
}