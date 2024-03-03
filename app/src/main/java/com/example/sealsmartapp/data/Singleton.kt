package com.example.sealsmartapp.data

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.sealsmartapp.app.Navigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class SharedPreferencesAppSettings @Inject constructor(
    @ApplicationContext appContext: Context
) : AppSettings {

    private val sharedPreferences =
        appContext.getSharedPreferences("settings", Context.MODE_PRIVATE)

    override fun getCurrentToken(): String? {
        return sharedPreferences.getString("currentToken", null)
    }

    override fun setCurrentToken(token: String?) {
        val editor = sharedPreferences.edit()
        if (token == null)
            editor.remove("currentToken")
        else
            editor.putString("currentToken", token)
        editor.apply()
    }
}


interface AppSettings {

    fun getCurrentToken(): String?

    fun setCurrentToken(token: String?)
}

fun Fragment.navigator() = requireActivity() as Navigator

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsModule {

    @Binds
    abstract fun bindAppSettings(
        appSettings: SharedPreferencesAppSettings
    ): AppSettings

}
