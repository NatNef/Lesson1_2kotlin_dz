package keyone.keytwo.lesson1_2kotlin_dz

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class ZametkiFragment : Fragment() {
    var currentMenu: Menu? = null
    var isLandScape = false
    private val LinearLayout: Any? = null

    // у фрагмента есть макет, задаем его , метод onCreateView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // переопределим его. В контейнер МэйнАктивити
        //inflater впихивает в активити контейнер с макетом (макет пустой)
        val view = inflater.inflate(R.layout.fragment_zametki, container, false)
        // выводим список (заполняем пустой макет)
        val linearLayout = view as LinearLayout


        //TextView списки внедряем, item( не генерируем класс)
        // взяли макет и сделали как объект
        val menu_zametki = resources.getStringArray(R.array.menu_zametki)
        val layoutInflater = layoutInflater
        for (i in menu_zametki.indices) {
            val name = menu_zametki[i]
            val textView = TextView(context)
            textView.text = name
            textView.textSize = 30f
            linearLayout.addView(textView)
            textView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View) {
                    currentMenu = Menu(
                        i,
                        resources.getStringArray(R.array.menu_zametki)[i]
                    )
                    // для ландшафтной
                    isLandScape =
                        resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
                    showOpisanieZametki()
                }

                private fun showOpisanieZametki() {
                    if (isLandScape) {
                        showOpisanieZametkiLand()
                    } else { // portret
                        showOpisanieZametkiPort()
                    }
                }

                private fun showOpisanieZametkiPort() {
                    requireActivity()
                        .supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.zametki_container, OpisanieFragment.newInstance(currentMenu))
                        .addToBackStack("") // обязательно вкл назад
                        .commit()
                }

                private fun showOpisanieZametkiLand() {
                    requireActivity()
                        .supportFragmentManager
                        .beginTransaction()
                        .replace(
                            R.id.opisanie_zametki_container,
                            OpisanieFragment.newInstance(currentMenu)
                        )
                        .commit()
                }
            })
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(): ZametkiFragment {
            return ZametkiFragment()
        }

    }
}