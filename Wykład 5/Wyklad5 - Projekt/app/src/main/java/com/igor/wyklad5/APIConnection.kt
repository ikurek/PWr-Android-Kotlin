package com.igor.wyklad5

import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.result.Result
import org.json.JSONArray
import org.json.JSONObject

// Klasa przechowująca metdy połączenia z API
class APIConnection {

    // Przykładowa metoda z requestem GET
    // Pobiera listę pytań z serwera
    fun getAllQuestions(success: (JSONArray) -> Unit) {

        // Wykonanie requestu GET na podany adres
        Fuel.get("http://37.233.102.13:3000/api/questions")
                // Przypisanie do requestu odpowiedniego nagłówka
                // W tym wyadku, informacje, że oczekiwany typ to json
                .header(Pair("Content-Type", "application/json"))
                // Odpowiedź w formacie JSON
                .responseJson { request, response, result ->
                    // Metoda fold rozdziela akcje w zależonści od wyniku zapytania
                    result.fold({ json ->
                        // Jeżeli otrzymany został JSON, wykonujemy callback
                        success(json.array())
                    },{ error ->
                        // Jeżeli otrzymany został błąd, powinniśmy go obsłużyć
                        // UWAGA: W tym miejscu pojawią się jedynie błędy związane zz działaniem biblioteki
                        // Jezeli błąd wystąpi po stronie serwera, otrzymamy zazwyczaj pusty JSON i kod błędu
                    })
                }
    }

    // Przykładowa metoda z requestem POST
    // Dodaje nowe pytanie na serwerze
    fun addQuestion(jsonObject: JSONObject) {
        // Wykonanie requestu POST
        Fuel.post("http://37.233.102.13:3000/api/questions")
                // Nagłówek informujący, że wysłany będzie JSON
                .header(Pair("Content-Type", "application/json"))
                // Body zawiera obiekt JSON, jako ciąg tekstu
                .body(jsonObject.toString())
                // Przechwycenie odpowiedzi z serwera
                .response { request, response, result ->
                    // Metoda fold rozdziela akcje w zależonści od wyniku zapytania
                    result.fold({
                        // Sprawdzenie, czy otrzymana odpowiedź zawiera kod błędu
                        if (response.statusCode > 400) {
                            // W tym miejscu powinno być obsłużenie błędów serwera
                        }
                    },{ exception ->
                        // Przechwycenie błędu połączenia / biblioteki
                    })
                }
    }
}