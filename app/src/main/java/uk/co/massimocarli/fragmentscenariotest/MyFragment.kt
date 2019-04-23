package uk.co.massimocarli.fragmentscenariotest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.view.*

class MyFragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_main, container, false)
    view.showToastButton.setOnClickListener {
      showToast()
    }
    return view
  }
  
  fun showToast() {
    Toast.makeText(activity, R.string.toast_message, Toast.LENGTH_SHORT).show()
  }
}