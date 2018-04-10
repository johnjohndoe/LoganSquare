package com.bluelinelabs.logansquare.demo.parsetasks

import android.util.Log
import com.beust.klaxon.Klaxon
import com.bluelinelabs.logansquare.demo.model.Response

class KlaxonParser(parseListener: Parser.ParseListener, jsonString: String, private val klaxon: Klaxon) : Parser(parseListener, jsonString) {

    override fun parse(json: String): Int {
        return try {
            val response = klaxon.parse<Response>(json)
            if (response!!.users == null) {
                Log.e(javaClass.name, "users is null")
            }
            response.users.size
        } catch (e: Exception) {
            // e.printStackTrace()
            0
        } finally {
            System.gc()
        }
    }

}
