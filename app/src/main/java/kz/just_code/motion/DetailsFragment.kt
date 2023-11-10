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
            title.text = args.title
            image.setImageResource(args.image)
            description.text = args.description
            title.transitionName = "title_${args.id}"
            image.transitionName = "image_${args.id}"
            container.transitionName = "container_${args.id}"

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