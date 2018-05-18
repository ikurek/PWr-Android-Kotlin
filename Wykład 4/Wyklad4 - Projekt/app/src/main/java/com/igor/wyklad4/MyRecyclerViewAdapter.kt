package com.igor.wyklad4

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_row.view.*

/**
 * Implementacja Adaptera, czyli klasy, której zadaniem jest
 * Zamiana zbioru danych wejściowych na widok
 * @param context jest potrzebny, aby móc tworzyć obiekt widoku z plików xml
 * @param list to zestaw danych wejsciowych w dowolnym formacie
 * W tym przypadku jest to lista obiektów typu [String]
 * @param clicked to wartość typu [Unit], czyli funkcja, która zostanie wywołana
 * W momencie podjęcia jakiejś akcji (w tym wypadku kliknięcia elementu)
 */
class MyRecyclerViewAdapter(var context: Context,
                            var list: List<String>,
                            var clicked: (Int) -> Unit) : RecyclerView.Adapter<MyViewHolder>() {

    // Funckja wywoływana dla każdego z elementów listy
    // Odpowiada za zwrócenie gotowego widoku (obiektu View) w postaci zdefiniowanej poniżej
    // Klasy przechowującej widok, nazywanej ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        // Zamiana pliku xml na obiekt typu View
        // Przy wykorzystaniu klasy LayoutInflater androida
        val rowView: View = LayoutInflater
                .from(context)
                .inflate(R.layout.list_row, null)

        // Zwrócenie ViewHoldera, zawierającego stworzony widok
        return MyViewHolder(rowView)
    }

    // Metoda określająca ilość elementów
    // Jakie będą wyświetlane w RecyclerView
    override fun getItemCount(): Int {
        return list.size
    }

    // Metoda odpowiadająca za dowiązanie danych
    // Do stworzonego widoku
    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        // Wywołanie metody bind(), zadeklarowanej w ViewHolderze
        holder!!.bind(list[position], clicked, position)
    }


}

/**
 * Implementacja ViewHoldera, czyli klasy, której
 * Zadaniem jest przechowywanie stworzonego widoku, do momentu, w
 * Któreym bedzie on potrzebny
 * @param itemView to widok klasy [View]
 * Który będzie przechowywany w klasie
 */
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    /**
     * Metoda, której zadaniem jest przypisanie danych
     * Do przechowywanego widoku
     * @param textFromBinder to [String], przypisywany do pola textowego
     * @param clicked to [Unit], który zostawnie wywołany w momencie kliknięcia
     * @param position to pozycja danego elementu w liście RecyclerView
     */
    fun bind(textFromBinder: String,
             clicked: (Int) -> Unit,
             position: Int) {
        itemView.list_row_text.text = textFromBinder
        itemView.setOnClickListener {
            clicked(position)
        }
    }

}