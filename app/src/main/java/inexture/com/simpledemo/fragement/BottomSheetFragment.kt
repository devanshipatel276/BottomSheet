package inexture.com.simpledemo.fragement


import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import inexture.com.simpledemo.R


class BottomSheetFragment : BottomSheetDialogFragment() {
    fun BottomSheetFragment() {
        // Required empty public constructor
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)



        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // var builder=AlertDialog.Builder(context)

        val closebutton=view.findViewById<Button>(R.id.btn_closefragment)
        closebutton.setOnClickListener {
            onDestroyView()
        }



    }


}
