package com.example.netclanapp.extras.ui.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.netclanapp.MainActivity
import com.example.netclanapp.R
import com.example.netclanapp.databinding.FragmentFilterBinding
import com.google.android.material.snackbar.Snackbar

class FilterFragment : Fragment() {

    private var _binding: FragmentFilterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    lateinit var binding: FragmentFilterBinding
    private lateinit var topToolbar: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MainActivity.navView?.visibility = View.GONE
        setHasOptionsMenu(true)

        AllButtonClicksetup()
        LightUpTextChipWithBoolean()
        seekbarSetUp()

    }

    private fun AllButtonClicksetup() {
        (activity as MainActivity).showTopToolbar(false)

        binding.closeButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            (activity as MainActivity).showTopToolbar(true)
        }

        binding.clearTextView.setOnClickListener {
            Snackbar.make(binding.root, "working", Snackbar.LENGTH_SHORT).show()
        }

        binding.BtnApply.setOnClickListener {
            Snackbar.make(binding.root, "Filter Applied", Snackbar.LENGTH_SHORT).show()
            requireActivity().supportFragmentManager.popBackStack()
            (activity as MainActivity).showTopToolbar(true)

        }

//        topToolbar = binding.topToolbar
//        (activity as MainActivity).showTopToolbar(false)
//        topToolbar.setOnMenuItemClickListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.action_close -> {
//                    requireActivity().supportFragmentManager.popBackStack()
//
//                    true
//                }
//                R.id.action_clear -> {
//                    Snackbar.make(binding.root, "working", Snackbar.LENGTH_SHORT).show()
//
//                    true
//                }
//                else -> false
//            }
//        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
    override fun onDetach() {
        super.onDetach()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        MainActivity.navView?.visibility = View.VISIBLE
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    fun seekbarSetUp() {
        val seekBar = binding.seekBar
        val seekBarValueTextView = binding.seekbarTextValue

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarValueTextView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Not needed in this case
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Not needed in this case
            }
        })

        // Custom ThumbDrawable to display the progress value on the thumb and apply padding
        val thumbDrawable = resources.getDrawable(R.drawable.thumb_drawable, null)
        thumbDrawable.setBounds(0, 0, thumbDrawable.intrinsicWidth, thumbDrawable.intrinsicHeight)
        seekBar.thumb = thumbDrawable
    }





    fun LightUpTextChipWithBoolean() {
        val chip  = binding.chip
        val chip2 = binding.chip2
        val chip3 = binding.chip3
        val chip4 = binding.chip4
        val chip5 = binding.chip5
        val chip6 = binding.chip6
        val chip7 = binding.chip7
        val chip8 = binding.chip8
        val chip9 = binding.chip9

        val clickListener = View.OnClickListener { view ->
            val textView = view as TextView
            textView.isSelected = !textView.isSelected

            if (textView.isSelected) {
                textView.setBackgroundResource(R.drawable.bg_chip_light_up)
            } else {
                textView.setBackgroundResource(R.drawable.bg_chip_light_off)
            }
        }

        chip.setOnClickListener(clickListener)
        chip2.setOnClickListener(clickListener)
        chip3.setOnClickListener(clickListener)
        chip4.setOnClickListener(clickListener)
        chip5.setOnClickListener(clickListener)
        chip6.setOnClickListener(clickListener)
        chip7.setOnClickListener(clickListener)
        chip8.setOnClickListener(clickListener)
        chip9.setOnClickListener(clickListener)
    }
}