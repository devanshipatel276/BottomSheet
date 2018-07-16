package inexture.com.simpledemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import com.livinglifetechway.k4kotlin.toastNow
import inexture.com.simpledemo.databinding.ActivityPersistentBottomsheetBinding

class PersistentBottomSheetActivity : AppCompatActivity() {
    lateinit var binding: ActivityPersistentBottomsheetBinding
    lateinit var sheetBehavior: BottomSheetBehavior<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@PersistentBottomSheetActivity, R.layout.activity_persistent_bottomsheet)


        binding.content?.btnCollapsed?.setOnClickListener {
            state(binding.peekheight?.layoutPeekheight, BottomSheetBehavior.STATE_COLLAPSED)
            callback()
        }
        binding.content?.btnExpanded?.setOnClickListener {
            state(binding.peekheight?.layoutPeekheight, BottomSheetBehavior.STATE_EXPANDED)
            callback()

        }
        binding.content?.btnHidden?.setOnClickListener {
            state(binding.peekheight?.layoutPeekheight, BottomSheetBehavior.STATE_HIDDEN)
            callback()

        }
        binding.content?.btnDone?.setOnClickListener {
            val value = binding.content?.editPeekvalue?.text.toString()
            if (value.isNullOrEmpty()) {
                toastNow("Please enter the peek value")
            } else {
                sheetBehavior.peekHeight = value.toInt()
            }
            binding.content?.editPeekvalue?.setText("")
        }


    }

    private fun state(layout: LinearLayout?, state: Int) {
        sheetBehavior = BottomSheetBehavior.from(layout)
        sheetBehavior.state = state

    }

    private fun callback() {

        sheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {

                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        toastNow("State Hideen")
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {

                        toastNow("State Expandend")
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        toastNow("State Collapsed")
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        toastNow("State Dragging")
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        toastNow("State Settling")
                    }
                }


            }
        })

    }

}
