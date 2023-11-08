package com.example.a2.navigation.second
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sample.R
import com.example.sample.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        binding.apply {
            // SecondFragment.kt

            if(arguments?.getString("1번이2번에게") != null) {
                Toast.makeText(
                    requireActivity(),
                    arguments?.getString("1번이2번에게"),
                    Toast.LENGTH_SHORT
                ).show()
            }

            textViewBack.setOnClickListener(){
                parentFragmentManager.setFragmentResult(
                    "백버튼",
                    bundleOf("2번이1번에게" to "백백백")
                )
                findNavController().popBackStack()
            }

            textViewToThird.setOnClickListener(){
                // SecondFragment.kt

                val bundle = bundleOf("2번이3번에게" to "숭")

                findNavController().navigate(R.id.action_secondFragment_to_thirdFragment, bundle)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}