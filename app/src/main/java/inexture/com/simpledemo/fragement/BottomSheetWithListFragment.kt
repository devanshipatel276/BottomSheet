package inexture.com.simpledemo.fragement

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.nitrico.lastadapter.LastAdapter
import inexture.com.simpledemo.BR
import inexture.com.simpledemo.CustomListener
import inexture.com.simpledemo.R
import inexture.com.simpledemo.databinding.FragmentBottomSheetWithListBinding
import inexture.com.simpledemo.databinding.ListRowBinding
import inexture.com.simpledemo.model.ListModel


class BottomSheetWithListFragment : BottomSheetDialogFragment() {
    lateinit var binding: FragmentBottomSheetWithListBinding
    var listener: CustomListener? = null
    var list: ArrayList<ListModel> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet_with_list, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listFunction()

        val linearLayoutManager = LinearLayoutManager(context)
        binding.recyclerview.layoutManager = linearLayoutManager

        LastAdapter(list, BR.item)
                .map<ListModel, ListRowBinding>(R.layout.list_row) {
                    onClick {
                        var data = it.binding.item?.name
                        if (listener != null)
                            listener?.Callback(data.toString())
                        dismiss()
                    }

                    onBind {

                    }
                }
                .into(binding.recyclerview)

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

    fun setCustomObjectListener(mylistener: CustomListener) {
        this.listener = mylistener
    }

}


