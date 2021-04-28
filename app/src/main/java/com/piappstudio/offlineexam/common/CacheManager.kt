package com.piappstudio.offlineexam.common

import android.content.Context
import org.json.JSONException
import java.io.*

/**
 * Cache manager helps us to store or retrieve the data from cache folder
 * */
class CacheManager {

    // To save json in the cache folder
    fun saveJson(context: Context, outputJson: String) {

        try {
            val out: ObjectOutput = ObjectOutputStream(
                FileOutputStream(
                    File(context.cacheDir, "").path + File.separator.toString() + "cacheFile.srl"
                )
            )
            out.writeObject(outputJson)
            out.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    // To retrieve the json from cache folder
    fun retrieveJson(context: Context):String? {

        try {
            val coInObject =
                ObjectInputStream(FileInputStream(File(context.cacheDir.path + File.separator.toString() + "cacheFile.srl")))
            val jsonObj = coInObject.readObject() as String
            coInObject.close()
            return jsonObj
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: OptionalDataException) {
            e.printStackTrace()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: StreamCorruptedException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return null
    }
}
