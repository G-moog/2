package com.example.a2.navigation.first
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.sample.R
import com.example.sample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        binding.apply {

            if(arguments?.getString("3번이1번에게") != null) {
                Toast.makeText(
                    requireActivity(),
                    arguments?.getString("3번이1번에게"),
                    Toast.LENGTH_SHORT
                ).show()
            }

            setFragmentResultListener("백버튼") { _, bundle ->
                Toast.makeText(requireActivity(),bundle.getString("2번이1번에게"), Toast.LENGTH_LONG).show() // value
            }

            textViewToSecond.setOnClickListener(){

                // FirstFragment.kt
                val bundle = bundleOf("1번이2번에게" to "원")

                /*findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)*/
                val id = FirstFragmentDirections.actionFirstFragmentToSecondFragment(1)
                findNavController().navigate(id)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}