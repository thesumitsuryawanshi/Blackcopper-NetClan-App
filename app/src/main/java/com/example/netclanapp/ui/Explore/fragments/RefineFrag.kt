package com.example.netclanapp.ui.Explore.fragments

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.netclanapp.MainActivity
import com.example.netclanapp.R
import com.example.netclanapp.databinding.FragmentRefineBinding
import com.google.android.material.snackbar.Snackbar


class RefineFrag : Fragment() {

    lateinit var binding: FragmentRefineBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentRefineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seekbarSetUp()


        (activity as MainActivity).showTopToolbar(false)
        MainActivity.navView?.visibility = View.GONE
        spinnerInit()

        (activity as MainActivity).showTopToolbar(false)
        binding.saveAndExplore.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            (activity as MainActivity).showTopToolbar(true)
        }


        setWordCountFromText()
        LightUpChipsWithBoolean()

        binding.saveAndExplore.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            Snackbar.make(view, "Details Saved.", Snackbar.LENGTH_SHORT).show()
            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            MainActivity.navView?.visibility = View.VISIBLE

            (activity as MainActivity).showTopToolbar(true)
        }

        allButtonClicks()

    }

    private fun allButtonClicks() {
        binding.RefineFragcloseButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
            (activity as MainActivity).showTopToolbar(true)

        }

    }

    fun setWordCountFromText() {
        val editText = binding.editTextTextPersonName4
        val wordCountTextView = binding.tvWordCount

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not used
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Calculate the word count
                val alphabetCount = s?.count { it.isLetter() }
                // Update the alphabet count TextView
                wordCountTextView.text = "$alphabetCount/250"
            }

            override fun afterTextChanged(s: Editable?) {
                // Not used
            }
        })
    }

    private fun spinnerInit() {

        val spinner: Spinner = binding.spinner

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.Availability_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun seekbarSetUp() {
        val seekBar = binding.seekBar3
        val seekBarValueTextView = binding.seekBarValueTextView

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekBarValueTextView.text = progress.toString()

                // Update the position of the value TextView above the thumb
                val thumb = seekBar!!.thumb
                val thumbBounds = thumb.bounds
                val thumbOffset = thumbBounds.left + thumbBounds.width() / 2
                val thumbCenterX = seekBar.x + thumbOffset.toFloat()
                val textViewWidth = seekBarValueTextView.width
                val textViewOffsetX = thumbCenterX - textViewWidth / 2
                seekBarValueTextView.translationX = textViewOffsetX
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

    override fun onDetach() {
        super.onDetach()
        MainActivity.navView?.visibility = View.VISIBLE
    }

    fun LightUpChipsWithBoolean() {
        val chip16 = binding.chip16
        val chip13 = binding.chip13
        val chip10 = binding.chip10
        val chip14 = binding.chip14
        val chip6 = binding.chip6
        val chip9 = binding.chip9
        val chip5 = binding.chip5
        val chip8 = binding.chip8

        val clickListener = View.OnClickListener { view ->
            val textView = view as TextView
            textView.isSelected = !textView.isSelected

            if (textView.isSelected) {
                textView.setBackgroundResource(R.drawable.bg_chip_light_up)
            } else {
                textView.setBackgroundResource(R.drawable.bg_chip_light_off)
            }
        }

        chip16.setOnClickListener(clickListener)
        chip13.setOnClickListener(clickListener)
        chip10.setOnClickListener(clickListener)
        chip14.setOnClickListener(clickListener)
        chip6.setOnClickListener(clickListener)
        chip9.setOnClickListener(clickListener)
        chip5.setOnClickListener(clickListener)
        chip8.setOnClickListener(clickListener)
    }


}