package inexture.com.simpledemo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomSheetDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.github.nitrico.lastadapter.LastAdapter
import inexture.com.simpledemo.databinding.ActivityModelBottomsheetWithListBinding
import inexture.com.simpledemo.databinding.ListRowBinding
import inexture.com.simpledemo.fragement.BottomSheetWithListFragment
import inexture.com.simpledemo.model.ListModel

class ModelBottomSheetWithListActivity : AppCompatActivity() {


    lateinit var binding: ActivityModelBottomsheetWithListBinding
    var list: ArrayList<ListModel> = ArrayList()
    val bottomsheet = BottomSheetWithListFragment()
    var name: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@ModelBottomSheetWithListActivity, R.layout.activity_model_bottomsheet_with_list)

        listFunction();

        binding.btnLayoutbottomsheet.setOnClickListener {
            showbottomsheetdialog()
        }
        binding.btnFragementbottomsheet.setOnClickListener {
            showBottomSheetDialogFragment()
        }
        bottomsheet.setCustomObjectListener(object : CustomListener {
            override fun Callback(data: String) {
                binding.tvPosition.setText(data)
            }
        })
    }

    private fun showBottomSheetDialogFragment() {
        bottomsheet.show(supportFragmentManager, bottomsheet.tag)
    }

    private fun listFunction() {
        list.add(ListModel("devi"))
        list.add(ListModel("Dhruvin"))
        list.add(ListModel("jigar"))
        list.add(ListModel("kt"))
        list.add(ListModel("devi"))
        list.add(ListModel("Dhruvin"))
        list.add(ListModel("jigar"))
        list.add(ListModel("kt"))
        list.add(ListModel("devi"))
        list.add(ListModel("Dhruvin"))
        list.add(ListModel("jigar"))
        list.add(ListModel("kt"))
        list.add(ListModel("devi"))
        list.add(ListModel("Dhruvin"))
        list.add(ListModel("jigar"))
        list.add(ListModel("kt"))
        list.add(ListModel("devi"))
        list.add(ListModel("Dhruvin"))
        list.add(ListModel("jigar"))
        list.add(ListModel("kt"))

    }

    private fun showbottomsheetdialog() {
        val dialog = BottomSheetDialog(this)
        val view = getLayoutInflater().inflate(R.layout.bottom_sheet_dialog_list, null)
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = linearLayoutManager
        LastAdapter(list, BR.item)
                .map<ListModel, ListRowBinding>(R.layout.list_row) {
                    onClick {
                        name = it.binding.item?.name
                        binding.tvPosition.setText(name)

                        dialog.dismiss()
                    }
                }
                .into(recyclerview)
        dialog.setContentView(view);
        dialog.show();
    }

}
