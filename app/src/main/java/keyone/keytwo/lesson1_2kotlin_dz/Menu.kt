package keyone.keytwo.lesson1_2kotlin_dz

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Menu : Parcelable {
    constructor(imageIndex: Int, name: String?) {
        this.imageIndex = imageIndex
        this.name = name
    }

    protected constructor(`in`: Parcel) {
        imageIndex = `in`.readInt()
        name = `in`.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(imageIndex)
        dest.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    var imageIndex = 0
    var name: String?

    constructor(name: String?) {
        this.name = name
    }

    companion object {
        @JvmField val CREATOR: Creator<Menu?> = object : Creator<Menu?> {
            override fun createFromParcel(`in`: Parcel): Menu? {
                return Menu(`in`)
            }

            override fun newArray(size: Int): Array<Menu?> {
                return arrayOfNulls(size)
            }
        }
    }
}