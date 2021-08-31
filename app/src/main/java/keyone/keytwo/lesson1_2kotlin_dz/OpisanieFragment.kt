package keyone.keytwo.lesson1_2kotlin_dz

import androidx.fragment.app.Fragment

class OpisanieFragment : Fragment() {
    private var menu: Menu? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_opisanie, container, false)
        val imageView: ImageView = view.findViewById<ImageView>(R.id.imageView)
        val textView: TextView = view.findViewById<TextView>(R.id.textView)
        textView.setText(menu!!.name)
        val typedArray: TypedArray = resources.obtainTypedArray(R.array.opisanie_imgs)
        imageView.setImageResource(typedArray.getResourceId(menu!!.imageIndex, -1))
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            menu = arguments!!.getParcelable(ARG_MENU)
        }
    }

    companion object {
        var ARG_MENU = "menu"
        @JvmStatic
        fun newInstance(menu: Menu?): OpisanieFragment {
            val fragment = OpisanieFragment()
            val bundle = Bundle()
            bundle.putParcelable(ARG_MENU, menu)
            fragment.arguments = bundle
            return fragment
        }
    }
}