package com.asifddlks.icinema.views

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.asifddlks.icinema.R
import com.asifddlks.icinema.databinding.FragmentExploreBinding
import com.asifddlks.icinema.viewmodels.ExploreViewModel


class ExploreSearchResultFragment : Fragment() {

    private lateinit var exploreViewModel: ExploreViewModel
    private var _binding: FragmentExploreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        exploreViewModel =
            ViewModelProvider(this).get(ExploreViewModel::class.java)

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.editTextSearch.setText(arguments?.getString("query"))

        initListeners()

        return root
    }

    private fun initListeners() {
        binding.buttonCancel.setOnClickListener {
            if (binding.buttonCancel.text.equals(getString(R.string.cancel))) {
                findNavController().popBackStack()
            } else {

            }

        }

        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.length > 0) {
                    binding.buttonCancel.text = getString(R.string.search)
                } else {
                    binding.buttonCancel.text = getString(R.string.cancel)
                }

            }
        })

        binding.editTextSearch.setOnEditorActionListener { view, actionId, keyEvent ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

            }
            handled
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}