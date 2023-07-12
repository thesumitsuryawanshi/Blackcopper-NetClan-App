package com.example.netclanapp.ui.Explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.netclanapp.adapters.rv_PersonListAdapter
import com.example.netclanapp.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    private var _binding: FragmentExploreBinding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//Use of ViewModel
//        val exploreViewModel =
//            ViewModelProvider(this).get(ExploreViewModel::class.java)
//        val textView: TextView = binding.
//        exploreViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

//temp p-list
        val personList =
            listOf(
                "Electronics",
                "Fasion",
                "Furniture",
                "Gifts",
                "Grosery",
                "Mobiles",
                "Grosery -2 ",
                "Grosery -3  "
            )

        rvSetUp(personList)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun rvSetUp(personList: List<String>) {
        val adapter = rv_PersonListAdapter(personList)

        binding.rvMusicList.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvMusicList.adapter = adapter
        adapter.notifyItemInserted(personList.size - 1)
    }


}