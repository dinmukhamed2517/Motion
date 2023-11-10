package kz.just_code.motion

import android.transition.TransitionInflater
import android.view.ViewGroup
import androidx.core.view.doOnPreDraw
import androidx.navigation.fragment.navArgs
import kz.just_code.motion.base.BaseFragment
import kz.just_code.motion.databinding.FragmentDetailsBinding

class DetailsFragment:BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    private val args: DetailsFragmentArgs by navArgs()
    override fun onBindView() {
        super.onBindView()
        with(binding){
            title.text = args.itemDto.title
            image.setImageResource(args.itemDto.image)
            description.text = args.itemDto.description
            title.transitionName = "title_${args.itemDto.id}"
            image.transitionName = "image_${args.itemDto.id}"
            container.transitionName = "container_${args.itemDto.id}"

            image.setOnClickListener{
                image.animate()
                    .rotationX(360f)
                    .setDuration(500)
            }
        }

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
//        postponeEnterTransition()

//        (view?.parent as? ViewGroup)?.doOnPreDraw {
//            startPostponedEnterTransition()
//        }

    }
}