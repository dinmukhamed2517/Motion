package kz.just_code.motion

import androidx.navigation.fragment.findNavController
import kz.just_code.motion.base.BaseFragment
import kz.just_code.motion.databinding.FragmentMainBinding

class MainFragment:BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onBindView() {
        super.onBindView()
        binding.startBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_photosFragment
            )
        }
    }
}