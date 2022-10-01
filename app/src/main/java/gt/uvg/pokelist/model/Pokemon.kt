/*---------------------------------------------------------------------------
Copyright (C), 2022-2023, Sara Echeverria (bl33h)
@author Sara Echeverria
FileName: Pokemon
@version: I - Kotlin
Creation: 29/09/2022
Last modification: 30/09/2022
------------------------------------------------------------------------------*/

package gt.uvg.pokelist.model

// Imports
import android.os.Parcel
import android.os.Parcelable

// Attributes
data class Pokemon(
    val id: Int,
    val name: String?

    // Parcel config
): Parcelable
{
    val imageUrlFront: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    val imageUrlShinnyFront: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/$id.png"
    val imageUrlBack: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/$id.png"
    val imageUrlShinnyBack: String get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/$id.png"

    // Constructor
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    )
    // Write
    override fun writeToParcel(parcel: Parcel, flags: Int)
    {
        parcel.writeInt(id)
        parcel.writeString(name)
    }
    // Describe
    override fun describeContents(): Int
    {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Pokemon> // *Object type: Pokemon
    {
        override fun createFromParcel(parcel: Parcel): Pokemon
        {
            return Pokemon(parcel)
        }
        override fun newArray(size: Int): Array<Pokemon?>
        {
            return arrayOfNulls(size)
        }
    }
}