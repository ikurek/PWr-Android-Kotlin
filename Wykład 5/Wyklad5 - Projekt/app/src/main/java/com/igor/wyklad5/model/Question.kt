package com.igor.wyklad5.model

import org.json.JSONObject

// Prosty model danych, przechowujący pytanie
data class Question(
        var id: Int,
        var author: String,
        var title: String,
        var body: String
) {

    // Companion object pozwala tworzyć metody, które traktowane będą jak funkcje statyczne
    // Dzięki temu, wywołać możemy Question.fromJSON() z dowolnego miejsca
    companion object {

        // Metoda zamienia otrzymany JSON na obiekt typu Question
        fun fromJSON(jsonObject: JSONObject): Question {

            // Pobieramy z JSONa odpowiednie pola i podajemy do konstruktora
            return Question(
                    jsonObject.getInt("id"),
                    jsonObject.getString("author"),
                    jsonObject.getString("title"),
                    jsonObject.getString("body"))
        }
    }

    // Metoda zamienia obiekt typu Question na JSON
    fun toJson(): JSONObject {

        // Stworzenie pustego JSONa
        var json = JSONObject()

        // Dodanie do niego pól
        json.put("author", this.author)
        json.put("title", this.title)
        json.put("body", this.body)

        return json

    }

}