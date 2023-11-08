package com.example.a2.navigation.third
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
import com.example.sample.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private var _binding : FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()

    }

    private fun initView() {
        binding.apply {
            if(arguments?.getString("2번이3번에게") != null) {
                Toast.makeText(
                    requireActivity(),
                    arguments?.getString("2번이3번에게"),
                    Toast.LENGTH_SHORT
                ).show()
            }


            buttonToFirst.setOnClickListener() {
                // ThirdFragment.kt

                val bundle = bundleOf("3번이1번에게" to "첨으로왔다")

                findNavController().navigate(R.id.action_thirdFragment_to_firstFragment, bundle)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_third, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}