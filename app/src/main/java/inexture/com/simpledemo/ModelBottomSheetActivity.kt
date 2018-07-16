package inexture.com.simpledemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import inexture.com.simpledemo.databinding.ActivityModelBottomsheetBinding
import inexture.com.simpledemo.fragement.BottomSheetFragment

class ModelBottomSheetActivity : AppCompatActivity() {
    lateinit var binding: ActivityModelBottomsheetBinding
    lateinit var sheetBehavior: BottomSheetBehavior<*>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ModelBottomSheetActivity, R.layout.activity_model_bottomsheet)
        binding.btnFragementbottomsheet?.setOnClickListener {
            showBottomSheetDialogFragment()
        }
        binding.btnLayoutbottomsheet?.setOnClickListener {
            showbottomsheetdialog()
        }

    }

    private fun showBottomSheetDialogFragment() {

        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

    private fun showbottomsheetdialog() {
        val view = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null)
        val dialog = BottomSheetDialog(this)
        val closebutton = view.findViewById<Button>(R.id.btn_closedialog)
        closebutton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.setContentView(view);
        dialog.show();

    }
}
