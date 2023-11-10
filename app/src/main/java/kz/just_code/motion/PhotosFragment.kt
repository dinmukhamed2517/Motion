package kz.just_code.motion

import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kz.just_code.motion.base.BaseFragment
import kz.just_code.motion.databinding.FragmentPhotosBinding
import kz.just_code.motion.model.ItemDto

class PhotosFragment:BaseFragment<FragmentPhotosBinding>(FragmentPhotosBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        val adapter = Adapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter.submitList(getItems())


        adapter.itemClick = {it, shared ->
            val extras = FragmentNavigatorExtras(*shared.toList().toTypedArray())
            val action = PhotosFragmentDirections.actionPhotosFragmentToDetailsFragment(it)
            findNavController().navigate(action, extras)
        }
    }
    private fun getItems():List<ItemDto>{
        return listOf(
            ItemDto(1, "Street", R.drawable.photo_1, "This is the street of NY city"),
            ItemDto(2, "Advertisement", R.drawable.photo_2, "This is the advertisement in NY city"),
            ItemDto(3, "Statue of liberty", R.drawable.photo_3, "This is the statue of liberty"),
            ItemDto(4, "Statue of liberty", R.drawable.photo_4, "This is the statue of liberty"),
            ItemDto(5, "Dog", R.drawable.photo_5, "This is dog"),
            ItemDto(6, "Bridge", R.drawable.photo_6, "This is the bridge"),


        )
    }
}